package com.alicmn.javaio.fileoperations.fileexamples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.nio.file.StandardOpenOption.*;

public class AppendFileExample {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppendFileExample.class);
	
	public static void main(String[] args) {
		appendToExitingFile();
	}
	
	public static void appendToExitingFile(){
		Path path = Paths.get("./folders/hello.txt");
		boolean isFileExist = path.toFile().exists();
		try(BufferedWriter bw = Files.newBufferedWriter(path, Charsets.UTF_8,
				isFileExist == false ? CREATE_NEW : APPEND)){
			bw.write("merhaba dünya mehrbafajfasdoaf\n");
		}
		catch (IOException e){
			LOGGER.info("Occured an exception!!!");
		}
	}
}
