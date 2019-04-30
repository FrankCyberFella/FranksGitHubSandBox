package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
									// alices_adventures_in_wonderland.txt
public class FindAndReplace {

	public static void main(String[] args) {
		
		File inputFile = getInputFileFromUser(); // Define a File object to represent the file
		File createdReplaceFile = createDestinationFile();
		
		
		String search = getStringFromUser();
		String replacement = getReplaceFromUser();
		String yesOrNo = getYesOrNo();
		String lowerCase = search.toLowerCase();
		String upperCase = search.toUpperCase();
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			int lineNumber = 1;
			try(PrintWriter writer = new PrintWriter(createdReplaceFile)){
				while(fileScanner.hasNextLine()) { 		// loop while the file has a next line
					String line = fileScanner.nextLine(); // read a line from file
					if(yesOrNo.toUpperCase().contains("Y")) {
						if(line.contains(search)) {
							
							line=line.replace(search, replacement);
							System.out.println(lineNumber+") "+line);
						}
					}else {
						if(line.contains(lowerCase) || line.contains(upperCase)){
							line=line.replace(search, replacement);
							System.out.println(lineNumber+") "+line);
							
						}
					}
					lineNumber++;
					
					writer.println(line);
				}
					
			}
		} 
		catch(FileNotFoundException e){
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
	private static String getReplaceFromUser() {
		Scanner replaceWord = new Scanner(System.in);
		System.out.println("What is the word you would like to replace with? ");
		String replacement = replaceWord.nextLine();
		System.out.print("Search word is: " + replacement +"\n" +"\n");
	
		return replacement;
	}
		
		@SuppressWarnings("resource")
		private static String getYesOrNo() {
			Scanner searchYesOrNo = new Scanner(System.in);
			System.out.println("Should the search be case sensitive? (Y/N) ");
			String yesOrNo = searchYesOrNo.nextLine();
	
			return yesOrNo;
		
	}
		private static File createDestinationFile() {
			Scanner userFile = new Scanner(System.in);
			System.out.println("What is the destination file name called? ");
			String createdFile = userFile.nextLine();
			System.out.println("Created file name is: " + createdFile);
			try {
				File createdReplaceFile = new File(createdFile);
				return createdReplaceFile;
			} catch(Exception e){
				System.out.println("Invalid file");
				System.exit(1);
			}
			return null;
		}
		
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {	// return a File object for a file that exists (its a pointer, does not contain data within file)
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the file that should be searched? ");
		String path = userInput.nextLine();			//get the path for the file from user
		System.out.println("Path entered: "+ path + "\n");
		try {
			File inputFile = new File(path);	// define a File object to represent the file
			if(inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path+" does not exist");
				System.exit(1); // Ends the program
			} else if(inputFile.isFile() == false) {
				System.out.println(path+" is not a file");
				System.exit(1); // Ends the program
			}
			return inputFile;
		} catch(Exception e) {
			System.out.println("You entered an invalid file");
			System.exit(1);
		}
		return null;
	}
}

