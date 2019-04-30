package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {
	
//	String filepath = "Users/antoinettemckinney/workspace/AntoinetteMcKinney-java/module-1/18_FileIO_Writing_out/student-exercise/java/FizzBuzz.txt";
	
	public static File createNewFile() throws IOException {
		File newFile = new File("FizzBuzz.txt");
		if (!newFile.exists()) {
			newFile.createNewFile();// Creates the file at the specified location
		}
		return newFile;
	}
	
	public static void  writeToFizzBuzzFile(File createdFile) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(createdFile);
		for(int i=1; i<301; i++) { // i less then 300
			if(i%3==0 && i%5==0 ) {
				writer.println("FizzBuzz");
			}else if(i%3==0 || String.valueOf(i).contains("3")) { // checks if number is divisible by 3
				writer.println("Fizz");
			}else if(i%5==0 || String.valueOf(i).contains("5")) { // checks if number is divisible by 5
				writer.println("Buzz");
			}else {
				writer.println(i);
			}
		}
		writer.close();
	}
	
	public static void main(String[] args)  throws IOException {		
		// create file goes first then wrtites to the file
		writeToFizzBuzzFile(createNewFile());
		System.out.println("Done."); // print out done when finished 
		
	}
}
////Users/antoinettemckinney/workspace/AntoinetteMcKinney-java/module-1/18FileIO_Writing_out/student-exercise/java/input.txt



	