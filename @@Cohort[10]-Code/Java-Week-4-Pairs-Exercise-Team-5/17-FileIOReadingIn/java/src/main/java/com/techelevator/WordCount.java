package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		int counter = 0;
		int counter2 = 0;
		File smallPoem = new File("alices_adventures_in_wonderland.txt");
		//File smallPoem = new File("small-poem.txt");
		try {
		Scanner keyboard = new Scanner(smallPoem);
		
		while(keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			line = line.replaceAll("  ", " ");
			String [] words=line.split(" ");
			for (String word: words) {
				//System.out.println(word);
				if (word.equals("")) {
					counter--;
					}
				if(word.contains("?") || word.contains(".") || word.contains("!")){
					counter2++;
				}
			}
			counter += words.length;
			
			}
		System.out.println("Word Count: " +counter);
		System.out.println("Sentence Count: " +counter2);
	}catch (FileNotFoundException e) {
		}
	}
}
