package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
	

	public static void main(String[] args) {
		
		int lineNumber = 0;
		File inputFile = getInputFileFromUser(); // gets input from user for the file path
		Scanner userStringInput = new Scanner(System.in); //sets up scanner to allow the computer to search for keyboard input
		System.out.println("Type the word you would like to find: ");
		String stringToSearch = userStringInput.nextLine(); // saves the user input to the string
		System.out.println("Will this search be case sensitive? [Y]es [N]o");
		String userResponse = userStringInput.nextLine(); //saves user input to string
		
		try { // 
			Scanner fileScanner = new Scanner(inputFile);//creates a scanner to scan the file for the data typed in
			
			if(userResponse.contains("y") || userResponse.contains("Y")) { //
				while(fileScanner.hasNextLine()) { // creates loop to check each line in the loop
					String line = fileScanner.nextLine(); //creates a string for the line scanned in the file
					String lineNoPunct = line.replaceAll("\\p{Punct}", "");//removes punctuation in the search
					String[] words = lineNoPunct.split(" ");//turns the line into a string array, indexes split by spaces
					lineNumber ++;// counts lines
					for (String wordsInArray : words) {// creates loop to check the strings in the indexes to match user input
						if(wordsInArray.equals(stringToSearch)) { 
							System.out.println(lineNumber + ": " + line);//if matches, prints the line number and the line with the input
						}
					}
				}
			}
			if(userResponse.contains("n") || userResponse.contains("N")) {
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					String lineNoPunct = line.replaceAll("\\p{Punct}", "");
					String[] words = lineNoPunct.split(" ");
					lineNumber ++;
					for (String wordsInArray : words) {
						if(wordsInArray.equalsIgnoreCase(stringToSearch)) {
							System.out.println(lineNumber + ": " + line);
							
						}
					}
				}
			}
		
		} catch (FileNotFoundException e) {//
			e.printStackTrace();
		} // scans the file

	}

	private static File getInputFileFromUser() { //method used to ask user for file path
		Scanner userInput = new Scanner(System.in); //input from the keyboard
		System.out.println("Please enter the path to a file: ");
		String filePath = userInput.nextLine(); //variable to store the user input of the file path
		File inputFile = new File(filePath); //allows the computer to find the file
		
		if(inputFile.exists() == false) {
			System.out.println("File does not exist.");
			System.exit(1); // closes program if file does not exist
		}
		else if(inputFile.isFile() == false) {
				System.out.println(filePath + " is not a file.");
				System.exit(1);// closes program if not a file
			}
			return inputFile;
		
		
	}

}
