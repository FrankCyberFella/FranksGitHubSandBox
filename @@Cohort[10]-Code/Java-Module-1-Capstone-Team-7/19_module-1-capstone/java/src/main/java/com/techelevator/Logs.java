package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Logs {
	private String name;
	private PrintWriter logWriter;
	String totalString = "";
	File fileFile;
	
	public Logs(String name, String file) throws IOException {
		this.name = name;
		this.fileFile = new File(file);
		fileFile.createNewFile();
		logWriter = new PrintWriter(fileFile);
	}
	
	public void logToFile(String thing) throws FileNotFoundException {
		try(PrintWriter logWriter = new PrintWriter(fileFile)){
			totalString += thing + "\n";
			logWriter.print(totalString);		
		}

	}
}
	

