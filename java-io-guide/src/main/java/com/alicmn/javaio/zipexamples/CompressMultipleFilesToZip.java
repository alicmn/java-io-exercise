package com.alicmn.javaio.zipexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class CompressMultipleFilesToZip {
	List<String> fileList;
	private static final String OUTPUT_ZIP_FILE = "C:\\Project_Work\\samples\\dest_sample.zip";
	private static final String SOURCE_FOLDER = "C:\\Project_Work\\samples\\src_sample";

	CompressMultipleFilesToZip() {
		fileList = new ArrayList<String>();
	}

	public static void main(String[] args) {
		CompressMultipleFilesToZip appZip = new CompressMultipleFilesToZip();
		appZip.generateFileList(new File(SOURCE_FOLDER));
		appZip.zipIt(OUTPUT_ZIP_FILE);
	}


	public void zipIt(String zipFile) {

		byte[] buffer = new byte[1024];

		try (FileOutputStream fos = new FileOutputStream(zipFile); ZipOutputStream zos = new ZipOutputStream(fos);) {
			System.out.println("Output to Zip : " + zipFile);

			for (String file : this.fileList) {

				System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);

				try (FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);) {
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				}
			}
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void generateFileList(File node) {

		// add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}

	}


	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}
}
