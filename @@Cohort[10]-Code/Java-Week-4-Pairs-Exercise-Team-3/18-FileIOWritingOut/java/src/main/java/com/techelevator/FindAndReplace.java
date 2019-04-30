package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException{
		System.out.println("Running program...");
		File inputFile = getInputFileFromUser();
	
		System.out.print("What name do you want to give the new file? >>> ");
		Scanner input = new Scanner(System.in);
		String newFileName = input.nextLine();
		
		File copiedFile = new File(newFileName);
		
		System.out.println("What is the search word you are looking for?");
		input = new Scanner(System.in);
		String currentSearch = input.nextLine();
		
		System.out.println("What is the word you want to replace it with?");
		String replaceWord = input.nextLine();
		
		try (PrintWriter writer = new PrintWriter(copiedFile)) {
			
			Scanner lineScanner = new Scanner(inputFile);
			
			while (lineScanner.hasNextLine()) {
				String currentLine = lineScanner.nextLine();
				
				if (currentLine.contains(currentSearch)) {
					currentLine = currentLine.replace(currentSearch, replaceWord);
				}
				
				writer.println(currentLine);
				
			}
		}
		
		System.out.println("Writing file...");
			
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
	
	
	
}
