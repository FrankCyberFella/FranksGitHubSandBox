package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	
	
	public static void main(String[] args) {
		
		File inputFile = getInputFileFromUser();
		
		String wordToSearch = wordToSearch();
		
		boolean caseSensitive = getCaseSensitive();
		
		int lineCounter = 1;
		String line = "";
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				if(caseSensitive) {
					if(line.contains(wordToSearch)) {
						System.out.println(lineCounter + ") "+line);
					}
				} else {
					if(line.toLowerCase().contains((wordToSearch).toLowerCase())) {
						System.out.println(lineCounter + ") "+line);
					}
				}
				
				lineCounter++;
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Invalid file");
		}

	}
	
	private static String wordToSearch() {

		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the word you are looking for?");

		return userInput.nextLine();
		
	}
	
	private static boolean getCaseSensitive() {

		Scanner userInput = new Scanner(System.in);
		System.out.println("Should the search be case sensitive? (Y/N)");
		
		
		
		return userInput.nextLine().equalsIgnoreCase("Y");
		
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the file that should be searched?");
		String path = userInput.nextLine();
		System.out.println("Path entered: "+ path + "\n");
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

}
