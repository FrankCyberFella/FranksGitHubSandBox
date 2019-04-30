package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {

		File inputFile = getInputFileFromUser();
		String searchWord = getWord();
		boolean caseSensitive = caseMatters();

		Scanner fileScanner = new Scanner(inputFile);
		//Scanner tester = new Scanner(inputFile);

		try {
			int lineNumber = 1;
			while (fileScanner.hasNextLine()) {
				String caseLine = tester.nextLine();
				String[] splitText = caseLine.split("\n");
				for (String container : splitText) {

					if (container.contains(searchWord) && caseSensitive == true) {
						System.out.println("(" + lineNumber + ")" + ": " + container);

					}
					if (container.contains(searchWord) || container.contains(searchWord.toLowerCase()) && caseSensitive == false) {

						System.out.println("(" + lineNumber + ")" + ": " + container);
					}
				}
				lineNumber++;

			}

		}

		catch (

		Exception e) {
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

	public static String getWord() {
		System.out.println("What is the search word you are looking for? ");
		Scanner word = new Scanner(System.in);
		String searchWord = word.nextLine();

		return searchWord;
	}

	public static boolean caseMatters() {

		System.out.println("Should the search be case sensitive (Y/N) ");
		Scanner kb = new Scanner(System.in);
		String caseSensitive = kb.nextLine();
		if (caseSensitive == "Y") {
			return true;
		} else
			return false;

	}

}
