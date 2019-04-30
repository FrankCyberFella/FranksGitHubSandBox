package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		File inputFile = userInputFile();
		int lines = 0;
		Scanner keys = new Scanner(System.in);
		
		try {
			Scanner fileScanner = new Scanner(inputFile);
			System.out.println("What is the search word that you are looking for?");
			String searchWord = keys.nextLine();
			System.out.println("Should the search be case sensitive? (Y/N)");
			String caseOrNo = keys.nextLine();
			if(caseOrNo.equalsIgnoreCase("n")) {
				String lowerCase = searchWord.toLowerCase();
				String upperCase = searchWord.toUpperCase();
				String capital = searchWord.substring(0,1).toUpperCase();
				String theRest = searchWord.substring(1).toLowerCase();
				String capitalized = capital + theRest;
				while(fileScanner.hasNextLine()) {
						String line = fileScanner.nextLine();
						lines++;
						if(line.contains(lowerCase) || line.contains(upperCase) || line.contains(capitalized)) {
							System.out.println(lines + " " + line);
						}
					}
			}
			if(caseOrNo.equalsIgnoreCase("y")) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lines++;
				if(line.contains(searchWord)) {
					System.out.println(lines + " " + line);
				}
			}
			}
		} catch (Exception e) {
		}
	}

	private static File userInputFile() {
		Scanner keys2 = new Scanner(System.in);
		System.out.print("What is the file that should be searched?\n");
		String input = keys2.nextLine();
		File inputFile = new File(input);
		if(inputFile.exists() == false) {
			System.out.println(input+" is nonexistent.");
			System.exit(1);
		} else if(inputFile.isFile() == false) {
			System.out.println(input+" is not a file.");
			System.exit(1);
		}
		return inputFile;
	}
}
