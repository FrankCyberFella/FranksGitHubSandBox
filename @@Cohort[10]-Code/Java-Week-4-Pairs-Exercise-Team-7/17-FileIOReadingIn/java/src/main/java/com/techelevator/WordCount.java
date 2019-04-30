package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {

		File inputFile = getFile();
		Scanner fileScanner = new Scanner(inputFile);

		try {
			int numberOfWords = 0;
			int numberOfSentences = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.next();

				String[] stringOfWords = line.split(" ");
				for (String word : stringOfWords) {
					String newWord = word.replaceAll("\\s", "");
					if (newWord.length() > 0) {
						numberOfWords++;
					}
					if (newWord.contains(".") || newWord.contains("!") || newWord.contains("?")) {
						numberOfSentences++;
					}
				}

			}

			System.out.println("Word Count: " +numberOfWords);
			System.out.println("Sentence Count: " +numberOfSentences);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fileScanner.close();
		}
	}

	public static File getFile() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		File file = new File(path);
		return file;
	}

}
