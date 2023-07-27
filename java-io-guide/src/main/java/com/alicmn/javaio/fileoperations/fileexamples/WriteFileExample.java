package com.alicmn.javaio.fileoperations.fileexamples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.io.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteFileExample {
	private final static Logger LOGGER = LoggerFactory.getLogger(WriteFileExample.class);
	public static void main(String[] args) {
		writeFile();
	}

	// Write file using BufferedWriter
	public static void writeFile() {
		Path path = Paths.get("./folders/demoFile.txt");
		try(
				BufferedWriter bw = Files.newBufferedWriter(path, Charsets.UTF_8, StandardOpenOption.CREATE_NEW);
				){
			String txt = "YYYYYYYYYYYYYYYYYYYYYYYYYYY";
			bw.write(txt);
		}catch (IOException e){
			LOGGER.error("filr could not be created!!!");
		}
	}
}
