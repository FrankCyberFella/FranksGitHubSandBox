package com.techelevator;


import java.io.File;

import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		int wordCount = 0;
		int sentenceCount = 0;
		//System.out.println("Enter File You Would Like to Use");
		File AliceText = new File("alices_adventures_in_wonderland.txt");
		try{
			Scanner fileScanner = new Scanner (AliceText);// encapsulated the object called file scanner
			while (fileScanner.hasNextLine()) { // loop while the file has a next line
				String line = fileScanner.nextLine(); 
				//line = line.replaceAll();
				String[] lineSplit =  line.split(" ");// As scan splits each line 
				for(int i = 0; i < lineSplit.length; i++) {
					if(lineSplit[i].length() > 0) {
				    wordCount ++;// Addi add file 
				    if(lineSplit[i].contains(".")) {
				    	sentenceCount ++;
				    if(lineSplit[i].contains("!")) {
				    	sentenceCount ++;
				    if(lineSplit[i].contains("?")) {
				    	sentenceCount ++;
				    	}
				    }
				  }
					
				}
			}  
		} 
	}
	catch(Exception e) {
			
} 
		System.out.println("Word Count: " + wordCount + " Sentence Count: " + sentenceCount);
		
	}
}

