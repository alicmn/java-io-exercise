package com.alicmn.javaio.ioexamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedWriterExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(BufferedWriterExample.class);
	private static final String text = "“The Wheel of Time turns, and Ages come and pass, leaving memories that become legend. Legend fades to myth, and even myth is long forgotten when the Age that gave it birth comes again.”";
	public static void main(String[] args) {
		Path path = Paths.get("./folders/BufferedWriterExample.txt");
		try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)) {
			bw.write(text);
			System.out.println("Success");
		} catch (IOException e) {
			LOGGER.error("Failed to write to file!!");
		}

	}
}
