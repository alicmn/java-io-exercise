package com.alicmn.javaio.ioexamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedInputStreamExample {
	private static Logger LOGGER = LoggerFactory.getLogger(BufferedInputStreamExample.class);
	public static void main(String[] args) {
		Path path = Paths.get("./folders/newfile.txt");
		try(
				InputStream is = Files.newInputStream(path,StandardOpenOption.READ);
				BufferedInputStream bs = new BufferedInputStream(is);
				){
			int buff = 0;
			while ((buff = bs.read()) != -1){
				System.out.print((char) buff);
			}
		}catch (IOException e){
			LOGGER.error("file could not be read");
		}
	}
}
