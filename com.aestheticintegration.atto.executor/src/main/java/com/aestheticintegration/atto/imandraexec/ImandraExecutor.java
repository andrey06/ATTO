package com.aestheticintegration.atto.imandraexec;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.function.Consumer;

import com.aestheticintegration.atto.dataobject.TimObject;
import com.aestheticintegration.atto.dataobject.TimObjectBuilder;
import com.aestheticintegration.atto.imandraexec.util.ImandraCoreCallUtils;
import com.aestheticintegration.atto.javaexec.JavaExecutor;

import lombok.Getter;

public class ImandraExecutor {
	private static String PROPERTIES_FILE = "/Executor.properties";
	
	@Getter
	private Properties properties;

	public static void main(String[] args) {
		ImandraExecutor imandraExecutor = new ImandraExecutor();
		
		try {
			imandraExecutor.prepareAndExec();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void prepareAndExec() throws Exception {
		this.properties = this.readProperties();
		String timFilesPath = this.getProperties().getProperty("tim.files.path");
		
		TimObjectBuilder timObjectBuilder = new TimObjectBuilder();
		
		Files.newDirectoryStream(Paths.get(timFilesPath), path -> (path.toString().endsWith(".tim")))
		.forEach(new Consumer<Path>() {
			public void accept(Path timFilePath) {
				// Check if ML-file exists
				String timFileName = timFilePath.toString();
				int q1 = timFileName.lastIndexOf(".tim");
				String mlFileName = timFileName.substring(0, q1) + ".ml";
				
				if (new File(mlFileName).exists()) {
					System.out.println(timFilePath);
	
					try {
						TimObject timObject = timObjectBuilder.readTimObjectFromFile(timFileName);
						new ImandraCoreCallUtils().executeSynch(mlFileName, timObject);
						
						timObjectBuilder.writeTimObjectToFile(timObject, timFileName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
				
		return;
	}

	private Properties readProperties() throws IOException {
//		InputStream inputStream = new FileInputStream(ImandraExecutor.PROPERTIES_FILE);
		InputStream inputStream = JavaExecutor.class.getResourceAsStream(ImandraExecutor.PROPERTIES_FILE);
			 
		// Loading the properties.
		Properties properties = new Properties();
		properties.load(inputStream);
 
		return properties;
	}

}
