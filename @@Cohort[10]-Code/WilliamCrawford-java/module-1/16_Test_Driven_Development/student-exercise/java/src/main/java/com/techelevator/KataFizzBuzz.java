package com.techelevator;

import java.io.File;
import java.io.PrintWriter;

public class KataFizzBuzz {

	/* ************************
	 * CREATING A FILE 
	 * ************************/
	
	
	File newFile = new File("FizzBuzz.txt");
	
	try {
		newFile.createNewFile();
//	System.out.println();
//	System.out.println("name: "+newFile.getName());
//	System.out.println("absolutePath: "+newFile.getAbsolutePath());
//	System.out.println("size : "+newFile.length());
	}catch(IOException e) {
		
	}
	try(PrintWriter writer = new PrintWriter(newFile)){
		for(String ans: result) {
			writer.println(ans);
			}
		}
}
	/* ************************
	 * WRITING TO A FILE 
	 * ************************/
	
//	System.out.println();
//	System.out.println("Now let's write something in the new file.");
//	System.out.print("Enter a message to be stored in the new file >>> ");
//	String message = userInput.nextLine();
//	
//	try(PrintWriter writer = new PrintWriter(newFile)) {
//		writer.println(message);
//	} // When we exit the try block, this cause the file to be closed and an automatic flush of the buffer to trigger
//	
//	System.out.println();
//	System.out.println("name: "+newFile.getName());
//	System.out.println("absolutePath: "+newFile.getAbsolutePath());
//	System.out.println("size : "+newFile.length());	
//	
//System.out.println();
//System.out.println("Now let's put a file in the directory.");
//System.out.print("Enter a name for the new file >>> ");
//String fileName = userInput.nextLine();
//File newFile = new File(newDirectory, fileName);
//
//newFile.createNewFile();
//System.out.println();
//System.out.println("name: "+newFile.getName());
//System.out.println("absolutePath: "+newFile.getAbsolutePath());
//System.out.println("size : "+newFile.length());
