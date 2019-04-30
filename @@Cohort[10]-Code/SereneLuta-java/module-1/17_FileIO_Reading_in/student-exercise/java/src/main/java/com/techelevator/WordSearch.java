package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
	
		
		File inputFile = getFile();
		getWord(inputFile);
		
		
	}
		
		
		private static File getFile() {
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("What is the file that should be searched?");
			File inputFile = new File(userInput.nextLine());
			
			if(inputFile.exists()) {
				return inputFile;
			}
			else {
				if(inputFile.exists() == false) {
					System.out.println("File does not exist");
					System.exit(1);
				}
				return inputFile;
		}
	}
			
			public static void getWord(File inputFile) {
				Scanner userWordInput = new Scanner(System.in);
				System.out.println("What is word you wish to search?");
				String word = userWordInput.nextLine();
				System.out.println("Do you want the search to be case sensitive? (Y/N)");
				String caseSensitive = userWordInput.nextLine();
				int counter = 0;
				
				try {
					Scanner wordSearch = new Scanner(inputFile);
					while (wordSearch.hasNextLine()) {
						String currentLine = wordSearch.nextLine();
						counter++;
						if(caseSensitive.equals("Y")) {
							if (currentLine.contains(word)) {
								System.out.println(counter + ":" + currentLine);
							}
	
							}
						if(caseSensitive.equals("N")) {
							if (currentLine.toUpperCase().contains(word.toUpperCase())) {
								System.out.println(counter + ":" + currentLine);
							}
	
							}
						}
			} catch (Exception e) {
			
			}
			
		}
}

