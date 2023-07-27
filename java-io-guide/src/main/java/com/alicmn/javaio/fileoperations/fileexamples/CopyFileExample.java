package com.alicmn.javaio.fileoperations.fileexamples;

import java.io.*;
import java.nio.file.*;

import org.apache.commons.io.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyFileExample {
	private final static Logger LOGGER = LoggerFactory.getLogger(CopyFileExample.class);

	public static void main(String[] args) {
		Path current = Paths.get("sample1.txt");
		Path destination = Paths.get("destination.txt");
		copyFile(current,destination);
	}

	public static void copyFile() {
		try (InputStream inStream = new FileInputStream("sample1.txt");
				OutputStream outStream = new FileOutputStream("sample2.txt")) {
			LOGGER.info("File Reading Started");
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			LOGGER.info("Reading file is completed");
		} catch (IOException e1) {
			LOGGER.error(e1.getMessage());
		}
	}
	public static void copyFile(Path current, Path destination) {
		boolean isFileExist = destination.toFile().exists();
		final String NEWLINE = "\n";
		try (BufferedReader br = Files.newBufferedReader(current);
			 BufferedWriter bw = Files.newBufferedWriter(destination, Charsets.UTF_8,isFileExist == true ? StandardOpenOption.APPEND :
					 StandardOpenOption.CREATE_NEW)
		) {
			while (br.ready())
				bw.write(br.readLine().concat(NEWLINE));
		} catch (IOException e) {
			LOGGER.info("Come across while reading file");
		}
	}
}
