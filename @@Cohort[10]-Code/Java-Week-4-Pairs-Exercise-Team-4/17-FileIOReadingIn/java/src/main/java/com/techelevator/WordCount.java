package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		File inputFile = new File ("alices_adventures_in_wonderland.txt");
		int wordCount = 0;
		int sentenceCount = 0;
	try {
		Scanner fileScanner = new Scanner(inputFile);
		Scanner fileScanner2 = new Scanner(inputFile);
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
				String[] words = line.split(" ");
				for(int i=0; i<words.length; i++) {
					if(words[i].length()>0) {
						wordCount++;
					}
				}
			}
		while(fileScanner2.hasNextLine()) {
			String line2 = fileScanner2.nextLine();
			if(line2.contains("!")) {
				sentenceCount++;
			}
			if(line2.contains(".")) {
				sentenceCount++;
			}
			if(line2.contains("?")) {
				sentenceCount++;
			}
			else {sentenceCount+=0;}
		}
	}
		catch (Exception e) {
		}
		finally {
			System.out.println("Word Count: " + wordCount);
			System.out.println("Sentence Count: " + sentenceCount);
		}
		
	}
}
