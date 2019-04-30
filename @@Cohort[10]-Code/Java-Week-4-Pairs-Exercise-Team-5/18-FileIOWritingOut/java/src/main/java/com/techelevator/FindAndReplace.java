package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
	//File innputFile = getInputFileFromUser();	
//	File replacedWord = new File("replacedWord.txt");
	String wordToReplace = "";
	String wordNew = "";
	Scanner keyboard = new Scanner(System.in);
	
	
	File innputFile = getInputFileFromUser();
	System.out.println("What would you like to name your new File? ");
	String newFile = keyboard.nextLine();
	File replacedWord = new File(newFile);
	//System.out.println("Hey! What file do you want?");
	//String file = keyboard.nextLine();
	//File replacedWord = new File(file);
	replacedWord.createNewFile();
	
	Scanner reader = new Scanner(innputFile);
	System.out.println("Sup dog what word do you want to change? ");
	wordToReplace = keyboard.nextLine();
	System.out.println("What word do you want to replace it with? ");
	wordNew = keyboard.nextLine();
//		System.out.println(line);
	try (PrintWriter writer = new PrintWriter(replacedWord)){
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			line = line.replaceAll(wordToReplace, wordNew);
			writer.println(line);
		}
		writer.close();
	
		
	}
	
	
	
	}
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {  //return a File object for a file that exists
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();      //Get the path for the file from user
		System.out.println("Path entered: "+ path + "\n");
		File inputFile = new File(path);         //defining a File object to represent the file
		if(inputFile.exists() == false) {        // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}
}
