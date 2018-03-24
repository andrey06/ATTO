package com.aestheticintegration.atto.dataobject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class TimObject {
	List<String> imports;
	List<Datatype> datatypes;
	List<Datavalue> datavalues;
	List<Function> functions;
	List<Test> tests;

	@Setter
	@Getter
	@NoArgsConstructor
	@FieldDefaults(level=AccessLevel.PRIVATE)
	public static class Datavalue {
		String name;
		String datatype;
		List<Object> fields;
		
	}
	
	@Setter
	@Getter
	@NoArgsConstructor
	@FieldDefaults(level=AccessLevel.PRIVATE)
	public static class Datatype {
		String name;
		List<Field> fields;
		
	}
	@Setter
	@Getter
	@NoArgsConstructor
	@FieldDefaults(level=AccessLevel.PRIVATE)
	public static class Field {
		String name;
		String type;
	}

	@Setter
	@Getter
	@NoArgsConstructor
	@FieldDefaults(level=AccessLevel.PRIVATE)
	public static class Function {
		String name;
		String mlName;
		List<Field> inputParams = new ArrayList<Field>();
		String returnType;
	
		private List<TestCase> testCases = new ArrayList<TestCase>();		
		
		@Setter
		@Getter
		@NoArgsConstructor
		@FieldDefaults(level=AccessLevel.PRIVATE)
		public static class TestCase {
			String constraints;
			LinkedHashMap<String, Object> input;
			Object output_expect;
			Object output_actual;
		}
	}
	@Setter
	@Getter
	@NoArgsConstructor
	@FieldDefaults(level=AccessLevel.PRIVATE)
	public static class Test {
		String name;
		String function;
		List<Object> input;
		Object output_expect;
		Object output_actual;
		
	}
}
