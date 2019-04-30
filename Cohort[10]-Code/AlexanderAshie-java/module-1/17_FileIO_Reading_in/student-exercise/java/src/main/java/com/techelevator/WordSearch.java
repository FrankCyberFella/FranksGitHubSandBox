package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		
		int lineCounter = 1;
	
		File inputFile = getInputFileFromUser();
		
		System.out.println("What is the search word you are looking for?");
		Scanner input = new Scanner(System.in);
		String currentSearch = input.nextLine();
		
		System.out.println("Should the search be case sensitve? Y / N");
		String ignoreCase = input.nextLine();
		
		currentSearch.equalsIgnoreCase(currentSearch);
		
		
		try { Scanner lineScanner = new Scanner(inputFile);
		
			while (lineScanner.hasNextLine()) {
				String currentLine = lineScanner.nextLine();
				
				if (ignoreCase.contains("Y") && currentLine.contains(currentSearch)) {
					System.out.println(lineCounter + ") " + currentLine);
				}
				
				if (ignoreCase.contains("N") && currentLine.toLowerCase().contains(currentSearch.toLowerCase())) {
					System.out.println(lineCounter + ") " + currentLine);
				}
				
				lineCounter++;	
			}
		
		} catch (Exception e) {
			
		}
	
		
	}

public static File getInputFileFromUser() {
		
		Scanner input = new Scanner(System.in);
				
		System.out.print("Please enter the file path: >>> ");
		File inputFile = new File(input.nextLine());
		
		if (inputFile.getName().contentEquals("alices_adventures_in_wonderland.txt")) {
			return inputFile;
		}
		
		else {
			System.out.println("File does not exist, exiting... ");
			System.exit(1);
			return inputFile;
		}
			
	}
	
}
