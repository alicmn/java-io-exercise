package com.alicmn.javaio.ioexamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedOutputStreamExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(BufferedInputStreamExample.class);
	public static void main(String[] args) {
		Path path = Paths.get("./folders/bufferedoutputstreamfile.txt");
		String content = "This is the text content";

		try(OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE_NEW);
		BufferedOutputStream bs = new BufferedOutputStream(os);
		){
			bs.write(content.getBytes());
		}catch (IOException e){
			LOGGER.error("Failed to write the file: "+path.getFileName());
		}

	}
}
