package com.alicmn.javaio.fileoperations.fileexamples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFileExample {
	private final static Logger LOGGER = LoggerFactory.getLogger(CreateFileExample.class);

	public static void main(String[] args) {
		Path path = Paths.get("./folders/createFileExample.txt");

		createFile(path);
	}
	
	public static void createFile() {
		File file = new File("C:/workspace/java-io-guide/sample.txt");
		try {
			if (file.createNewFile()) {
				LOGGER.info("File is created !!");
			} else {
				LOGGER.info("File is already exist");
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	private static void createFile(Path path){
		boolean isFileExist = path.toFile().exists();
		try{
			if(isFileExist)
				LOGGER.info("File is already exist");
			else
				path.toFile().createNewFile();
		}catch (IOException e) {
			LOGGER.info("File could not be created");
		}
	}
}
