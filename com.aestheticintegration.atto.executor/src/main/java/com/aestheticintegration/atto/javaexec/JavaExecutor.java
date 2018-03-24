package com.aestheticintegration.atto.javaexec;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

import com.aestheticintegration.atto.dataobject.TimObject;
import com.aestheticintegration.atto.dataobject.TimObject.Datatype;
import com.aestheticintegration.atto.dataobject.TimObject.Datavalue;
import com.aestheticintegration.atto.dataobject.TimObject.Field;
import com.aestheticintegration.atto.dataobject.TimObject.Function;
import com.aestheticintegration.atto.dataobject.TimObject.Function.TestCase;
import com.aestheticintegration.atto.dataobject.TimObject.Test;
import com.aestheticintegration.atto.dataobject.TimObjectBuilder;

import lombok.Getter;

public class JavaExecutor {
	private static String PROPERTIES_FILE = "/Executor.properties";
	
	@Getter
	private Properties properties;
	

	public static void main(String[] args) {
		JavaExecutor javaExecutor = new JavaExecutor();
		
		TimObjectBuilder timObjectBuilder = new TimObjectBuilder();
		
		try {
			javaExecutor.properties = javaExecutor.readProperties();
			String timFilesPath = javaExecutor.getProperties().getProperty("tim.files.path");
			
			javaExecutor.addClassPath();
			
			Files.newDirectoryStream(Paths.get(timFilesPath), path -> path.toString().endsWith(".tim"))
				.forEach(new Consumer<Path>() {
					public void accept(Path timFilePath) {
						System.out.println(timFilePath);
						// Read Tim-file from the tim-file
						try {
							TimObject timObject = timObjectBuilder.readTimObjectFromFile(timFilePath);
							
							for (Function function : timObject.getFunctions()) {
								// Run the function from the tim-file
								javaExecutor.invokeFunction(timObject, function);
							}
							
							for (Test test : timObject.getTests()) {
								// Run the test from the tim-file
								javaExecutor.invokeTest(timObject, test);
							}
						
						timObjectBuilder.writeTimObjectToFile(timObject, timFilePath);
							
						} catch (Exception e){
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Invoke the method for each input generated by Imandra
	@SuppressWarnings("unchecked")
	private void invokeFunction(TimObject timObject, Function function) throws Exception {
		Class<?> clazz = this.createClassFromClassName(timObject.getImports(), function.getName());
		
		Method method = this.buildMethodByFunction(timObject, clazz, function);
		
		String returnTypeName = method.getGenericReturnType().getTypeName();
		if (!returnTypeName.endsWith("." + function.getReturnType()) &&
			!returnTypeName.equals(function.getReturnType())) 
		{
			throw new NoSuchMethodException("Wrong the returned type");
		}

		Object instance = clazz.newInstance();
		for (TestCase testCase : function.getTestCases()) {
			LinkedHashMap<String, Object> inputMap = testCase.getInput();
			int index1 = 0;
			Object[] inputParamValues = new Object[inputMap.size()];
			for (Object input : inputMap.values()) {
				Object input2 = input;
				if (input instanceof LinkedHashMap) {
					// User Type object
					input2 = this.createObject(timObject, (LinkedHashMap<String, ?>) input);
				} else {
					String inputType = function.getInputParams().get(index1).getType();
					Class<?> valueClass = this.createClassFromClassName(timObject.getImports(), inputType);
					input2 = this.convertFromJsonValue(valueClass, input);
				}
				inputParamValues[index1++] = input2;
			}
		
			Object returnObj = null;
			try {
				returnObj = method.invoke(instance, inputParamValues);
			} catch (InvocationTargetException e) {
				returnObj = "EXCEPTION \"" +e.getTargetException().getMessage() + "\"";
			}
			
			testCase.setOutput_actual(returnObj);
		}

		return;
	}
	private Object createObject(TimObject timObject, LinkedHashMap<String, ?> linkedHashMap) throws Exception {
		Object object = null;
		if (linkedHashMap.get("datatype") != null) {
			object = this.createObjectFromDatatype(timObject, linkedHashMap);
		} else if (linkedHashMap.get("datavalue") != null) {
			object = this.createObjectFromDatavalue(timObject, linkedHashMap);
		}
		
		return object;
	}
	@SuppressWarnings("unchecked")
	private Object createObjectFromDatatype(TimObject timObject, LinkedHashMap<String, ?> linkedHashMap) throws Exception {
		String datatype = (String) linkedHashMap.get("datatype");
		ArrayList<?> fieldMap = (ArrayList<?>) linkedHashMap.get("fields");

		List<Class<?>> inputParamClass = new ArrayList<Class<?>>(fieldMap.size());
		List<Object> inputParamValue = new ArrayList<Object>(fieldMap.size());
		int index = -1;
		for (Object field : fieldMap) {
			index++;
			Object input = field;
			if (field instanceof LinkedHashMap) {
				// User Type object
				input = this.createObject(timObject, (LinkedHashMap<String, ?>) field);
			}
			Class<?> clazz = this.convertFromJsonClass(timObject, linkedHashMap, index);
			inputParamClass.add(clazz);
			inputParamValue.add(this.convertFromJsonValue(clazz, input));
		}
		Class<?>[] inputParamClasses = inputParamClass.toArray(new Class[0]);
		Object[] inputParamValues = inputParamValue.toArray(new Object[0]);
		
		Class<?> clazz = this.createClassFromClassName(timObject.getImports(), datatype);
		Constructor<?> constructor = clazz.getConstructor(inputParamClasses);
		Object object = constructor.newInstance(inputParamValues);
		
		return object;
	}
	private Class<?> convertFromJsonClass(TimObject timObject, LinkedHashMap<String, ?> linkedHashMap, int index) throws Exception {
		ArrayList<?> fieldMap = (ArrayList<?>) linkedHashMap.get("fields");
		Object input = fieldMap.get(index);
		
		Class<?> clazz = input.getClass();
		if (clazz ==  Double.class) {
			String datatypeName = (String) linkedHashMap.get("datatype");
			Object[] datatypes = timObject.getDatatypes().stream().filter(datatype -> datatype.getName().equals(datatypeName)).toArray();
			if (datatypes.length == 0) {
				throw new Exception("Wrong datatype");
			}
			Datatype datatype  = (Datatype)datatypes[0];
			String typeName = datatype.getFields().get(index).getType();
			
			clazz = this.createClassFromClassName(timObject.getImports(), typeName);
		}
		return clazz;
	}
	private Object convertFromJsonValue(Class<?> clazz, Object input) {
		Object input2 = input;
		if (input instanceof Double) {
			Double doubleValue = (Double) input;
			if (clazz == float.class || clazz == Float.class) {
				Float floatValue = Float.valueOf(doubleValue.floatValue());
				input2 = floatValue;
			}
		}
		return input2;
	}
	@SuppressWarnings("unchecked")
	private Object createObjectFromDatavalue(TimObject timObject, LinkedHashMap<String, ?> linkedHashMap) throws Exception {
		String datavalueName = (String) linkedHashMap.get("datavalue");
		Object[] datavalues = timObject.getDatavalues().stream().filter(datavalue -> datavalue.getName().equals(datavalueName)).toArray();
		if (datavalues.length == 0) {
			throw new Exception("Wrong datavalue");
		}
		
		Datavalue datavalue = (Datavalue)datavalues[0];
		ArrayList<?> fieldMap = (ArrayList<?>) datavalue.getFields();

		List<Object> inputParamValue = new ArrayList<Object>(fieldMap.size());
		List<Class<?>> inputParamClass = new ArrayList<Class<?>>(fieldMap.size());
		for (Object field : fieldMap) {
			Object input = field;
			if (field instanceof LinkedHashMap) {
				// User Type object
				input = this.createObject(timObject, (LinkedHashMap<String, ?>) field);
			}
			inputParamValue.add(input);
			inputParamClass.add(input.getClass());
		}
		Object[] inputParamValues = inputParamValue.toArray(new Object[0]);
		Class<?>[] inputParamClasses = inputParamClass.toArray(new Class[0]);
		
		Class<?> clazz = this.createClassFromClassName(timObject.getImports(), datavalue.getDatatype());
		Constructor<?> constructor = clazz.getConstructor(inputParamClasses);
		Object object = constructor.newInstance(inputParamValues);
		
		return object;
	}
	// Invoke the method for each input generated by Imandra
	@SuppressWarnings("unchecked")
	private Object invokeTest(TimObject timObject, Test test) throws Exception {
		Class<?> clazz = this.createClassFromClassName(timObject.getImports(), test.getFunction());
		Object instance = clazz.newInstance();

		// Find the function based on the test.function
		Function function = this.findFunctionByTest(timObject, test);
		
		Method method = this.buildMethodByFunction(timObject, clazz, function);
		
		List<Object> inputParamValue = new ArrayList<Object>(test.getInput().size());
		for (Object field : test.getInput()) {
			Object input = field;
			if (field instanceof LinkedHashMap) {
				// User Type object
				input = this.createObject(timObject, (LinkedHashMap<String, ?>) field);
			}
			inputParamValue.add(input);
		}
		Object[] inputParamValues = inputParamValue.toArray(new Object[0]);
		
		System.out.println("method is " + method.getName());

		Object returnObj = null;
		try {
			returnObj = method.invoke(instance, inputParamValues);
		} catch (InvocationTargetException e) {
			returnObj = "EXCEPTION \"" +e.getTargetException().getMessage() + "\"";
		}
		test.setOutput_actual(returnObj);

		return returnObj;
	}
	private Method buildMethodByFunction(TimObject timObject, Class<?> clazz, Function function) throws Exception {
		Class<?>[] inputParamObjects = new Class[function.getInputParams().size()];
		int index = 0;
		for (Field field : function.getInputParams()) {
			inputParamObjects[index++] = this.convertClassNameToClass(timObject, field.getType());
		}
		String[] funcName = function.getName().split("\\.");
		String methodName = funcName[1];
		Method method = clazz.getDeclaredMethod(methodName, inputParamObjects);
		
		return method;
	}
	private Function findFunctionByTest(TimObject timObject, Test test) {
		String funcName = test.getFunction();
		Function function = null;
		// Find by name
		Object[] functions = timObject.getFunctions().stream().filter(func -> func.getName().equals(funcName)).toArray();
		
		// Find by the input parameters' type
		for (Object funcObj: functions) {
			Function func = (Function) funcObj;
			for (int index = 0; index < func.getInputParams().size(); index++) {
				String functionInputType = func.getInputParams().get(index).getType();
				String functionInputWrapperType = this.convertTypeNameToWrapperClassName(functionInputType);
				Object input = test.getInput().get(index);
				String testInputType = this.getInputType(timObject, input);
				if (!testInputType.endsWith("." + functionInputWrapperType) &&
					!testInputType.equals(functionInputWrapperType)	) 
				{
					// Types in the function and the test are different
					break;
				}
				function = func;
			}
		}

		return function;
	}
	@SuppressWarnings("unchecked")
	private String getInputType (TimObject timObject, Object input) {
		String inputType = null;
		if (input instanceof LinkedHashMap) {
			LinkedHashMap<String, ?> linkedHashMap = (LinkedHashMap<String, ?>) input;
			if (linkedHashMap.containsKey("datatype")) {
				inputType = (String) linkedHashMap.get("datatype");
			} else if (linkedHashMap.containsKey("datavalue")) {
				// Needed to find DataType
				String datavalueName = (String) linkedHashMap.get("datavalue");
				Object[] datavalues = timObject.getDatavalues().stream().filter(datavalue -> datavalue.getName().equals(datavalueName)).toArray();
				if (datavalues.length != 0) {
					inputType = ((Datavalue)datavalues[0]).getDatatype();
				}
			}
		} else {
			inputType = input.getClass().getName();
		}
		return inputType;
	}
	
	
	private Class<?> createClassFromClassName(List<String> imports, String className) throws Exception {
		if (className.equals("int") ) return int.class;
		if (className.equals("Integer") ) return Integer.class;
		if (className.equals("float")) return float.class;
		if (className.equals("Float")) return Float.class;
		if (className.equals("String")) return String.class;
		if (className.equals("Boolean")) return Boolean.class;
		if (className.equals("boolean")) return boolean.class;
		
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			String[] funcName = className.split("\\.");
			// Probably we need to use "imports"
			imports.stream().filter(str -> str.endsWith("." + funcName[0])).forEach(System.out::println);
			
			Object[] packages = imports.stream().filter(str -> str.endsWith("." + funcName[0])).toArray();
			for (Object obj : packages) {
				String className2 = (String) obj;
				try {
					clazz = Class.forName(className2);
					break;
				} catch (ClassNotFoundException e1) {
				}
			}
		}
		if (clazz == null) {
			throw new Exception("No correct class found");
		}
		
		return clazz;
	}
	private String convertTypeNameToWrapperClassName(String className) {
		String classNameUpper = className.toUpperCase();
		
		return (
			classNameUpper.equals("BOOLEAN") ? "Boolean" :
			classNameUpper.equals("SHORT") ? "Short" :
			classNameUpper.equals("INT") ? "Integer" :
			classNameUpper.equals("INTEGER") ? "Integer" :
			classNameUpper.equals("LONG") ? "Long" : 
			classNameUpper.equals("FLOAT") ? "Float" : 
			classNameUpper.equals("DOUBLE") ? "Double" : 
			classNameUpper.equals("STRING") ? "String" : 									
			className);
	}

	private Class<?> convertClassNameToClass(TimObject timObject, String className) throws Exception {
		Class<?> clazz =  (
			className.equals("boolean") ? boolean.class :
			className.equals("Boolean") ? Boolean.class :
			className.equals("short") ? short.class : 
			className.equals("Short") ? Short.class : 
			className.equals("int") ? int.class : 
			className.equals("Integer") ? Integer.class : 
			className.equals("long") ? long.class : 
			className.equals("Long") ? Long.class : 
			className.equals("float") ? float.class : 									
			className.equals("Float") ? Float.class : 
			className.equals("double") ? double.class : 
			className.equals("Double") ? Double.class : 
			className.equals("String") ? String.class : 									
			null);
		if (clazz == null) {
			// It is a User object
			clazz = createClassFromClassName(timObject.getImports(), className);
		}
		
		return clazz;
	}
	private void addClassPath() throws Exception {
		String javaClassPath = this.getProperties().getProperty("java.classpath");
		String[] jarFullPaths = javaClassPath.split(";|,");
		
		for (String jarPath : jarFullPaths) {
			File file = new File(jarPath);
			URI uri = file.toURI();
			URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
			Class<URLClassLoader> urlClass = URLClassLoader.class;
			Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
			method.setAccessible(true);
			method.invoke(urlClassLoader, new Object[]{uri.toURL()});
		}
	}
	private Properties readProperties() throws IOException {
//		InputStream inputStream = new FileInputStream(JavaExecutor.PROPERTIES_FILE);
		InputStream inputStream = JavaExecutor.class.getResourceAsStream(JavaExecutor.PROPERTIES_FILE);
			 
		// Loading the properties.
		Properties properties = new Properties();
		properties.load(inputStream);
 
		return properties;
	}
}