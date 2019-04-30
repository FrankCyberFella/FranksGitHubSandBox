package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = getFile();
		String word = getWord();

		String capitals = getCasePreference();

		Scanner documentScanner = new Scanner(inputFile);

		
			int lineNumber = 1;

			while (documentScanner.hasNextLine()) {
				
				String doc = documentScanner.nextLine();


					if (capitals.equalsIgnoreCase("Y")) {
							if (doc.contains(word)) {
								System.out.print(lineNumber + ") ");
								System.out.println(doc);
							}
						}

					 else if (capitals.equalsIgnoreCase("N")) {
						String lowWord = word.toLowerCase();
						String lowDoc = doc.toLowerCase();
						if (lowDoc.contains(lowWord)){
							System.out.print(lineNumber + ") ");
							System.out.println(doc);
							}
						}
					lineNumber++;
					}
		
				
			
		} 

	

	// ------------------------------------------------------------------------------------------------
	// ALL THE GETTERS
	// ------------------------------------------------------------------------------------------------
	public static File getFile() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		File file = new File(path);
		return file;
	}

	public static String getWord() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a word to search >>> ");
		String word = userInput.nextLine();
		return word;
	}

	public static String getCasePreference() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Do you want the search to be case sensitive? Y or N >>> ");
		String capitals = userInput.nextLine();
		return capitals;
	}
}
