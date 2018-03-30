package com.aestheticintegration.atto.imandraexec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.aestheticintegration.atto.dataobject.TimObject;
import com.aestheticintegration.atto.dataobject.TimObject.Field;
import com.aestheticintegration.atto.dataobject.TimObject.Function;
import com.aestheticintegration.atto.dataobject.TimObject.Function.TestCase;
import com.aestheticintegration.atto.dataobject.TimObjectBuilder;

public class ImandraCoreCall {
	private static String TERMINAL_OCAML = ";;";
	private static char[] TERMINAL_CHAR = {'#', '>'};
	
	public void executeSynch(String mlFilePath, TimObject timObject) throws Exception {
        String mlFileContent = new String(Files.readAllBytes(Paths.get(mlFilePath)));
        String[] mlFilePortions = mlFileContent.split(ImandraCoreCall.TERMINAL_OCAML);
        int mlFilePortionNumber = 0;
         		
		List<String> commandList = Arrays.asList("/Applications/Docker.app/Contents/Resources/bin/docker", "run", "-i", "eu.gcr.io/imandra-core-env/imandra-pure-bin");
		ProcessBuilder processBuilder = new ProcessBuilder(commandList);
		processBuilder.redirectErrorStream(true);

		Process process = null;
		try {
			process = processBuilder.start();
		} catch (Exception e) {
			//log.error("The process ["+ execFileName + "] was not started. The error is [" + e + "]"
			throw new Exception("error.core.notcalled.imandra", e);
		}

        boolean constraintFlag = false;
        boolean inputFlag = false;
        int functionNumber = 0;
        int regionNumber = -1;					// Test Case Number
		int regionCommandNumber = -1;
        String portion = null;

		StringBuilder bufferToAnalys = new StringBuilder("");;
		char[] buf = new char[1024];
		int qty = -1;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) 
		{
			while ((qty = reader.read(buf,  0, 1024)) != -1) {
				bufferToAnalys.append(new String(buf, 0, qty));
				
				if (buf[qty-2] != ImandraCoreCall.TERMINAL_CHAR[0] && buf[qty-1] != ImandraCoreCall.TERMINAL_CHAR[0] &&
					buf[qty-2] != ImandraCoreCall.TERMINAL_CHAR[1] && buf[qty-1] != ImandraCoreCall.TERMINAL_CHAR[1]) 
				{
					continue;
				}
				
				System.out.println(bufferToAnalys);
				
				if (constraintFlag) {
					// Reaction on "\nList.iter (fun r" - Read constraints
					this.extractConstrainsAndOutputExpect(bufferToAnalys.toString(), timObject, functionNumber);
					constraintFlag = false;
				}
				if (inputFlag) {
					// Reaction on "\nlet tcs = List" - Read the input for testcases (aka regions)
					this.extractInput(bufferToAnalys.toString(), timObject, functionNumber);
					inputFlag = false;
					
					if (functionNumber == timObject.getFunctions().size() - 1) {
						// It was a last one
						// Terminate the process
						reader.close();
						writer.close();
						process.destroy();
						break;
					} else {
						// New function
						functionNumber++;

						regionCommandNumber = -1;
					}

				}
				if (regionCommandNumber == 3) {
					// Reaction on the 3rd extra command - "Yojson.Basic.pretty_to_channel stdout params_json;;"
					// Read the region's test cases, Create the json object
					String jsonBuf = bufferToAnalys.substring(0, bufferToAnalys.indexOf("}-") + 1);
					Function function = timObject.getFunctions().get(functionNumber);
					
					LinkedHashMap<String, Object> helpObject = null;		//	new TimObjectBuilder().readHelpObjectFromString(jsonBuf);
					function.getTestCases().get(regionNumber).setInput(helpObject);

					if (regionNumber < function.getTestCases().size() - 1) {
						// Next region
						regionNumber++;
						regionCommandNumber = 0;
					} else {
						// No more regions
						if (functionNumber == timObject.getFunctions().size() - 1) {
							// It was a last one
							// Terminate the process
							reader.close();
							writer.close();
							process.destroy();
							break;
						} else {
							// New function
							functionNumber++;
	
							regionCommandNumber = -1;
						}
					}
				}

				if (regionCommandNumber == -1) {
					// Read a next command from the ml-file
					portion = mlFilePortions[mlFilePortionNumber] + ImandraCoreCall.TERMINAL_OCAML;
					mlFilePortionNumber++;
				}
				
				if (regionCommandNumber == 0) {
					// Reaction on the last 'regular' command - "let tcs = List.map Mex.of_region rs;;"
					portion = "let index_region = " + regionNumber + ";;";
					regionCommandNumber = 1;
				} else if (regionCommandNumber == 1) {
					// Extra lines for Region's test cases
					// Reaction on the 1st extra command - "let index_region ="
					String mlFuncName = "prep_" + timObject.getFunctions().get(functionNumber).getMlName();
					portion = "let params_json = `Assoc (" + mlFuncName;
					for (Field field : timObject.getFunctions().get(functionNumber).getInputParams()) {
						portion += " ((List.nth tcs index_region).Mex." + field.getName() + ")";
					}
					portion += ");;";
					
					regionCommandNumber = 2;
				} else if (regionCommandNumber == 2) {
					// Extra lines for Region's test cases
					// Reaction on the 2nd extra command - "let params_json = `Assoc ("
					portion = "Yojson.Basic.pretty_to_channel stdout params_json;;";
					regionCommandNumber = 3;
				}
				
				if (portion.startsWith("\nCaml.List.iter (fun r")) {
					// Print a string representations of each region
					// Constraints
					constraintFlag = true;
				}
				if (portion.startsWith("\nlet tcs = List")) {
					// Extract a test-case from each region, using the model extractor
					// Test-case inputs
					regionNumber = 0;
//					regionCommandNumber = 0;
					inputFlag = true;
				}
				
				writer.write(portion);
				writer.newLine();
				writer.flush();
				System.out.println(portion);
				
				bufferToAnalys.setLength(0);
			}
		} catch (IOException e) {
			throw new Exception("error.core.notreading.output", e);
		}
		
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			throw new Exception("error.core.technical.problem", e);
		}
		
		return;
	}
	private void extractConstrainsAndOutputExpect(String buffer, TimObject timObject, int functionNumber) {
		System.out.println("*********   analysConstrains start  ****");
		System.out.println(buffer);
		
		Function function = timObject.getFunctions().get(functionNumber);
		
		String phraseStart = "Constraints:";
		String phraseEnd   = "Invariant:";
		
		buffer = buffer.replaceAll("Exception_[0-9]+", "Exception");
		buffer = buffer.replaceAll("Something_[0-9]+\\s", "");


		int constrainNumber = 0;		// aka regionNumber, testNumber
		int posStart = -1;
		int posEnd   = -1;
		while ((posStart = buffer.indexOf(phraseStart)) != -1 &&
			   (posEnd = buffer.indexOf(phraseEnd)) != -1)
		{
			if (function.getTestCases().size() <= constrainNumber) {
				function.getTestCases().add(new TestCase());
			}
			String constraints = buffer.substring(posStart + phraseStart.length(), posEnd).replace("\n", "");
			constraints = constraints.substring(constraints.indexOf("(") + 1, constraints.lastIndexOf(")"));
			function.getTestCases().get(constrainNumber).setConstraints(constraints.trim());

			String invariant = buffer.substring(posEnd + phraseStart.length());
			
			if (invariant.startsWith(" (NO_EXN_")) {
				// A regular return value, not exception
				invariant = invariant.substring(invariant.indexOf("("));
				invariant = invariant.substring(invariant.indexOf(" ") + 1, invariant.indexOf(")"));
				
				String returnType = function.getReturnType();
				if (returnType.equalsIgnoreCase("short") ||
					returnType.equalsIgnoreCase("int") ||
					returnType.equalsIgnoreCase("Integer") ||
					returnType.equalsIgnoreCase("long")) 
				{
					try {
						Integer value = Integer.valueOf(invariant);
						invariant = value.toString();
					} catch (NumberFormatException e) {
						invariant = "";
					}
				}
			} else if (invariant.contains("Exception")) {
				// Exception starts with " (Exception "
				//  (Exception_826 "Wrong input for this function")
				invariant = invariant.substring(invariant.indexOf("Exception"), invariant.indexOf("\")") + 1);
			} else {
				invariant = invariant.substring(0, invariant.indexOf("\n"));
				if (invariant.indexOf("(") != -1) {
					invariant = invariant.substring(invariant.indexOf("(") + 1, invariant.lastIndexOf(")"));
				}
			}
			function.getTestCases().get(constrainNumber).setOutput_expect(invariant.trim());
			
			buffer = buffer.substring(posEnd + phraseEnd.length());
			constrainNumber++;
		}
		
		System.out.println("*********   analysConstrains end  ****");
		return;
	}
	@SuppressWarnings("unchecked")
	private void extractInput(String buffer, TimObject timObject, int functionNumber) throws Exception {
		System.out.println("*********   extractInput start  ****");
		System.out.println(buffer);
		
		Function function = timObject.getFunctions().get(functionNumber);

		String phraseStart = "[";
		String jsonObj = buffer.substring(buffer.indexOf(phraseStart));
		jsonObj = jsonObj.substring(0, jsonObj.indexOf("\n>"));
		
		jsonObj = jsonObj.replace("\n ", "");					// Remove a new line character
		jsonObj = jsonObj.replace("Mex.", "");					// Remove the module name
		jsonObj = jsonObj.replace("Something ", "");				// Remove the options
		jsonObj = jsonObj.replace("Nothing", "null");			// Replace an option by a real Java null
		jsonObj = jsonObj.replaceAll("\\};\\s+\\{", "}, {");		// Use a comma to separate items in an array
		jsonObj = jsonObj.replace(".}", ".0}");					// Add the zero to the end to make a float
		
		for (int paramNum = 0; paramNum < function.getInputParams().size(); paramNum++) {
			String paramName = function.getInputParams().get(paramNum).getName();
			jsonObj = jsonObj.replace(paramName + " = ", "\"" + paramName + "\" : ");
		}
		jsonObj = jsonObj.replace("; \"", ", \"");		// Use a comma to separate items in a json object
		
		List<LinkedHashMap<String, Object>> helpObject = (List<LinkedHashMap<String, Object>>) new TimObjectBuilder().readHelpObjectFromString(jsonObj);

		int testNumber = 0;
		for (LinkedHashMap<String, Object> linkedHashMap : helpObject) {
			function.getTestCases().get(testNumber).setInput(linkedHashMap);
			testNumber++;
		}
		System.out.println("*********   extractInput end  ****");
	}
}