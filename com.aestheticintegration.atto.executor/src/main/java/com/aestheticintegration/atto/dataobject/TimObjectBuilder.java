package com.aestheticintegration.atto.dataobject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TimObjectBuilder {
	
	public TimObject readTimObjectFromFile(String timFileName) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		TimObject timObject = objectMapper.readValue(new File(timFileName), TimObject.class);

		return timObject;
	}
	public TimObject readTimObjectFromFile(Path timFileFullPath) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		TimObject timObject = objectMapper.readValue(timFileFullPath.toFile(), TimObject.class);

		return timObject;
	}
	public void writeTimObjectToFile(TimObject timObject, Path timFileFullPath) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		objectMapper.writeValue(timFileFullPath.toFile(), timObject);
		
		return;
	}
	public void writeTimObjectToFile(TimObject timObject, String timFileName) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		objectMapper.writeValue(new File(timFileName), timObject);
		
		return;
	}
	
	public LinkedHashMap<String, Object> readHelpObjectFromString2(String str) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> helpObject = (LinkedHashMap<String, Object>) objectMapper.readValue(str, Object.class);

		return helpObject;
	}
	public Object readHelpObjectFromString(String str) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		Object helpObject = objectMapper.readValue(str, Object.class);

		return helpObject;
	}

	
}
