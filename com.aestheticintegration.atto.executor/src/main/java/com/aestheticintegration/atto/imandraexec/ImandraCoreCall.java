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
        boolean runFunctionFlag = false;
        int functionNumber = 0;
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
					
					if (functionNumber < timObject.getFunctions().size()) {
						// New function
						functionNumber++;
					}
				}
				if (runFunctionFlag) {
					// Reaction on "\nlet tcs = List" - Read the input for testcases (aka regions)
					this.extractFunctionReturn(bufferToAnalys.toString(), timObject, functionNumber);
					runFunctionFlag = false;
					
					if (functionNumber < timObject.getFunctions().size() - 1) {
						// New function
						functionNumber++;
					}
				}
				if (mlFilePortionNumber == mlFilePortions.length) {
					// It was a last one
					// Terminate the process
					reader.close();
					writer.close();
					process.destroy();
					break;
				}
				// Read a next command from the ml-file
				
				portion = mlFilePortions[mlFilePortionNumber] + ImandraCoreCall.TERMINAL_OCAML;
				mlFilePortionNumber++;
				
				if (portion.startsWith("\nCaml.List.iter (fun r")) {
					// Print a string representations of each region
					// Constraints
					constraintFlag = true;
				}
				if (portion.startsWith("\nlet tcs = List")) {
					// Extract a test-case from each region, using the model extractor
					// Test-case inputs
					inputFlag = true;
				}
				if (portion.startsWith("\n(* Run function *)")) {
					// Extract a test-case from each region, using the model extractor
					// Test-case inputs
					runFunctionFlag = true;
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
		String phraseInvariantEnd   = "-----";
		
		buffer = buffer.replaceAll("Exception_[0-9]+", "Exception");
		buffer = buffer.replaceAll("Some_[0-9]+\\s", "");


		int constrainNumber = 0;		// aka regionNumber, testNumber
		int posStart = -1;
		int posEnd   = -1;
		while ((posStart = buffer.indexOf(phraseStart)) != -1 &&
			   (posEnd = buffer.indexOf(phraseEnd)) != -1)
		{
			if (function.getTestCases().size() <= constrainNumber) {
				function.getTestCases().add(new TestCase());
			}
			String constraints = buffer.substring(posStart + phraseStart.length(), posEnd).replace("\n", "").trim();
			if (constraints.lastIndexOf(")") != -1) {
				constraints = constraints.substring(constraints.indexOf("(") + 1, constraints.lastIndexOf(")"));
			}
			function.getTestCases().get(constrainNumber).setConstraints(constraints.trim());

			String invariant = buffer.substring(posEnd + phraseStart.length());
			
			if (invariant.contains("Exception")) {
				// Exception starts with " (Exception "
				//  (Exception_826 "Wrong input for this function")
				invariant = invariant.substring(invariant.indexOf("Exception"), invariant.indexOf("\")") + 1);
			} else {
				invariant = invariant.substring(0, invariant.indexOf(phraseInvariantEnd));
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
		jsonObj = jsonObj.replace("Some ", "");				// Remove the options
		jsonObj = jsonObj.replace("None", "null");			// Replace an option by a real Java null
		jsonObj = jsonObj.replaceAll("\\};\\s+\\{", "}, {");		// Use a comma to separate items in an array
		jsonObj = jsonObj.replace(".}", ".0}");					// Add the zero to the end to make a float
		jsonObj = jsonObj.replace(".;", ".0;");					// Add the zero to the end to make a float
		
		// Name's parameters in quotes
		jsonObj = jsonObj.replace("{", "{\"");		// Name's parameters in quotes
		jsonObj = jsonObj.replace("; ", "; \"");		// Name's parameters in quotes
		jsonObj = jsonObj.replace(" = ", "\" : ");		// Name's parameters in quotes
		
/*
		for (int paramNum = 0; paramNum < function.getInputParams().size(); paramNum++) {
			String paramName = function.getInputParams().get(paramNum).getName();
			jsonObj = jsonObj.replace(paramName + " = ", "\"" + paramName + "\" : ");
		}
*/
		
		jsonObj = jsonObj.replace("; \"", ", \"");		// Use a comma to separate items in a json object
		
		List<LinkedHashMap<String, Object>> helpObject = (List<LinkedHashMap<String, Object>>) new TimObjectBuilder().readHelpObjectFromString(jsonObj);

		int testNumber = 0;
		for (LinkedHashMap<String, Object> linkedHashMap : helpObject) {
			function.getTestCases().get(testNumber).setInput(linkedHashMap);
			testNumber++;
		}
		System.out.println("*********   extractInput end  ****");
	}
	private void extractFunctionReturn(String buffer, TimObject timObject, int functionNumber) throws Exception {
		System.out.println("*********   extractFunctionReturn start  ****");
		System.out.println(buffer);
		
		Function function = timObject.getFunctions().get(functionNumber);

		String phraseStart = "=\n";
		String jsonObj = buffer.substring(buffer.indexOf(phraseStart) + phraseStart.length());
		jsonObj = jsonObj.substring(0, jsonObj.indexOf("\n>"));
		
		jsonObj = jsonObj.replace("Some\n ", "");			// Remove the options
		jsonObj = jsonObj.replace("\n ", "");					// Remove a new line character
		jsonObj = jsonObj.replace("Mex.", "");					// Remove the module name
		jsonObj = jsonObj.replace("Some ", "");				// Remove the options
		jsonObj = jsonObj.replace("None", "null");			// Replace an option by a real Java null
		jsonObj = jsonObj.replaceAll("\\};\\s+\\{", "}, {");		// Use a comma to separate items in an array
		jsonObj = jsonObj.replace(".}", ".0}");					// Add the zero to the end to make a float
		jsonObj = jsonObj.replace(".;", ".0;");					// Add the zero to the end to make a float
		
		// Name's parameters in quotes
		jsonObj = jsonObj.replace("{", "{\"");		// Name's parameters in quotes
		jsonObj = jsonObj.replace("; ", "; \"");		// Name's parameters in quotes
		jsonObj = jsonObj.replace(" = ", "\" : ");		// Name's parameters in quotes
				
		jsonObj = jsonObj.replace("; \"", ", \"");		// Use a comma to separate items in a json object
		
		Object helpObject = new TimObjectBuilder().readHelpObjectFromString(jsonObj);
		function.getTestCases().get(0).setOutput_expect(helpObject);

/*		int testNumber = 0;
		for (LinkedHashMap<String, Object> linkedHashMap : helpObject) {
			function.getTestCases().get(testNumber).setInput(linkedHashMap);
			testNumber++;
		}
*/
		System.out.println("*********   extractFunctionReturn end  ****");
	}
}
