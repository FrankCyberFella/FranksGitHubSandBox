package com.techelevator;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class WordSearch {
													// alices_adventures_in_wonderland.txt
	public static void main(String[] args) {
		
	
		File inputFile = getInputFileFromUser(); // Define a File object to represent the file
		String search = getStringFromUser();
		String yesOrNo = getYesOrNo();
		String lowerCase = search.toLowerCase();
		String upperCase = search.toUpperCase();
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			int lineNumber = 1;
			while(fileScanner.hasNextLine()) { 		// loop while the file has a next line
				String line = fileScanner.nextLine(); // read a line from file
					String words[] = line.split("\n");
				for(String test: words) {
					if(yesOrNo.equals("Y")) {
						if(test.contains(search)) {
							System.out.println(lineNumber+") "+test);
					}
					}
					else if(yesOrNo.equals("N")) {
						if(test.contains(lowerCase) || test.contains(upperCase)){
							System.out.println(lineNumber+") "+test);
					}
					}
					lineNumber++;
				}
				}
			} 
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Invalid file");
		}
	}
	@SuppressWarnings("resource")
	private static String getStringFromUser() {
		Scanner searchWord = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String search = searchWord.nextLine();
		System.out.print("Search word is: " + search +"\n" +"\n");
	
		return search;
	}
		
		@SuppressWarnings("resource")
		private static String getYesOrNo() {
			Scanner searchYesOrNo = new Scanner(System.in);
			System.out.println("Should the search be case sensitive? (Y/N) ");
			String yesOrNo = searchYesOrNo.nextLine();
	
			return yesOrNo;
		
	}
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {	// return a File object for a file that exists (its a pointer, does not contain data within file)
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the file that should be searched? ");
		String path = userInput.nextLine();			//get the path for the file from user
		System.out.println("Path entered: "+ path + "\n");
		
		File inputFile = new File(path);	// define a File object to represent the file
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
