package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		
		File inputFile = getInputFileFromUser();
		
		getWordLine(inputFile); 
	

	}

	public static File getInputFileFromUser() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the file path: >>> ");
		File inputFile = new File(input.nextLine());
		
		if (inputFile.exists()) {
			return inputFile;
	    }
		
		else {
			System.out.println("File does not exist, exiting... ");
			System.exit(1);
			return inputFile;
		}
	}
	
	public static void getWordLine(File inputFile) {
		
		System.out.println("Please enter the word you would like to search for: ");
		Scanner input = new Scanner(System.in);
		
		
		int lineNumber = 0;
		String searchedWord = input.nextLine();
		
		try { Scanner lineScanner = new Scanner(inputFile);
			
			while (lineScanner.hasNextLine()) {
				String currentLine = lineScanner.nextLine();
				lineNumber++;
				if (currentLine.contains(searchedWord)) {
					System.out.println(lineNumber + ": " + currentLine);  
			}
				
			}
		
	
			}
			catch (Exception e) {
				
			}
	}
}
	

