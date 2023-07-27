package com.alicmn.javaio.ioexamples;

import org.apache.commons.io.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedReaderExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(BufferedInputStreamExample.class);
	public static void main(String[] args) {
		Path path = Paths.get("./folders/BufferedReaderExample.txt");
		try(
				BufferedReader bf  = Files.newBufferedReader(path, Charsets.UTF_8);
				){
			String line ;
			while (bf.ready()){
				System.out.println((char)bf.read());
			}
		}catch (IOException e){
			LOGGER.error("File could not be read: "+path.getFileName());
		}

	}
}
