package com.alicmn.javaio.fileoperations.fileexamples;

import java.io.File;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveFileExample {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoveFileExample.class);

	public static void main(String[] args) {
		moveFile();
	}

	public static void moveFile() {

		boolean hasRename = Paths.get("./destination.txt").toFile().renameTo(new File("./folders/newfile.txt"));
		if (hasRename) {
			LOGGER.info("File is moved successful!");
		} else {
			LOGGER.info("File is failed to move!");
		}
	}
}
