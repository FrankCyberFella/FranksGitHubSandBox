package com.techelevator;

import java.io.File;
import java.util.Scanner;
//  Craig, I couldn't quite remember the strategy you outlined today for the 
//  second part.  I came up with an alternative that seems to work...
public class WordSearch {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter search word :");
			String searchWord = scan.nextLine();
			System.out.println("Should the search be case sensitive? (Y/N)");
			String caseAnswer = scan.nextLine();
			System.out.print("Please enter path to input file >>> ");
			String path = scan.nextLine();
			System.out.println("Path entered: " + path + "\n");
			File inputFile = new File(path);
			Scanner fileScanner = new Scanner(inputFile);

			int lineCount = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lineCount++;
				if (caseAnswer.equals("N") && (line.contains(searchWord))) {
					System.out.println(lineCount + ") " + line);
				}
				if (caseAnswer.equals("Y") && (line.contains(searchWord))) {
					String[] words = line.split(" ");
					for (int i = 0; i < words.length; i++) {
						if (words[i].compareTo(searchWord) == 0) {
							System.out.println(lineCount + ") " + line);
						}

					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

