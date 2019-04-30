package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCount {

	public static void main(String[] args) {

	File inputFile = getInputFileFromUser();
	
	System.out.println("Word Count: " + getNumberOfWords(inputFile));
	System.out.println("Sentence Count: " + getNumberOfSentences(inputFile));
			
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
	
	public static int getNumberOfWords(File inputFile) {
		
		int wordCounter = 0;
		String currentLine = "";
		
		try { Scanner wordScanner = new Scanner(inputFile); 
			
		while (wordScanner.hasNextLine()) {
			currentLine = wordScanner.nextLine(); 
			currentLine = currentLine.replaceAll("  ", " ");
			wordCounter += currentLine.split(" ").length;
		}
		
		String[] tempStringArray = currentLine.split(" ");
		
		for (String temp : tempStringArray) {
			if (temp.contains("")) {
				wordCounter--;
			}
		}
		
		
		
			return wordCounter;
		}
		catch (Exception e) {
			return wordCounter;
		}
	}
	
	public static int getNumberOfSentences(File inputFile) {
		
		int sentenceCounter = 0;
		
		try { Scanner sentenceScanner = new Scanner(inputFile); 
			
		while (sentenceScanner.hasNextLine()) {
			String currentLine = sentenceScanner.nextLine();
		
			if (currentLine.contains(".") || currentLine.contains("!") || currentLine.contains("?")) {
				sentenceCounter++;
			}
			
		}
			return sentenceCounter;
		}
		catch (Exception e) {
			return sentenceCounter;
		}
	}
	

	
}
