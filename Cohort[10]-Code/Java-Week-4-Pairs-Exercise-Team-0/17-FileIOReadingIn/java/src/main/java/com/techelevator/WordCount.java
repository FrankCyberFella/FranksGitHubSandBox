package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {

		// printApplicationBanner();
		File inputFile = getInputFileFromUser();
		Scanner fileScanner = new Scanner(inputFile);
		try {
			int wordCount = 0;
			int sentenceCount = 0;
			while (fileScanner.hasNextLine()) {
				String lineText = fileScanner.nextLine();
				String[] splitText = lineText.split(" ");
				for (String counter : splitText) {
					lineText = lineText.replaceAll("\\s", "");
					if (counter.length() > 0) {
						wordCount++;
					}
					if (counter.contains(".") ||  counter.contains("!") || counter.contains("?")) {
						sentenceCount++;
					}
				}
			}
			System.out.println("Word Count: " + wordCount);
			System.out.println("Sentence Count: " + sentenceCount);
		}

		catch (Exception e) {
			fileScanner.close();
		}
	}

	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter path to input file>>> ");
		String path = userInput.nextLine();
		System.out.println("Path entered " + path + "\n");
		File inputFile = new File(path);
		if (inputFile.exists() == false) {
			System.out.println(path + " does not exist");
			System.exit(1);
		} else if (inputFile.isFile() == false) {
			System.out.println(path + " is not a file");
			System.exit(1);
		}
		return inputFile;
	}
}
