package com.alicmn.javaio.fileoperations.fileexamples;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteFileExample {
	private final static Logger LOGGER = LoggerFactory.getLogger(DeleteFileExample.class);
	
	public static void main(String[] args) {
		Path path = Paths.get("./folders/hello.txt");
		deleteFile(path);
	}
	public static void deleteFile() {
		File file = new File("C:/workspace/sample.txt");
		if (file.delete()) {
			LOGGER.info(file.getName() + "created !!");
		} else {
			LOGGER.info("Delete operation failed");
		}
	}
	public static void deleteFile(Path path){
		if(path.toFile().delete())
			LOGGER.info(path.getFileName()+" is deleted succesfully");
		else
			LOGGER.error(path.getFileName()+" is not deleted");
	}
}
