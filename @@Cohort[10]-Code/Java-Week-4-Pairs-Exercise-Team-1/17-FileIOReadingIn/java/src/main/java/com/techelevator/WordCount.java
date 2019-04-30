package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		int wordCount = 0;
		int sentenceCount = 0;
		
		
		File inputFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if(line.length() != 0) {
					String words[] = line.trim().split("[ ]+");
					wordCount += words.length;
				for(String test : words) {
					if(test.endsWith(".") || test.endsWith("?") || test.endsWith("!")) {
					sentenceCount++;
				}
				}
					//String sentence[] = (line.trim()+" ").split("\\?|\\!|\\.");
				//	sentenceCount += sentence.length-1;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Invalid file");
		}
		System.out.println("Word Count: "+ wordCount);
		System.out.println("Sentence Count: "+ sentenceCount);
	}
	
	

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
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
