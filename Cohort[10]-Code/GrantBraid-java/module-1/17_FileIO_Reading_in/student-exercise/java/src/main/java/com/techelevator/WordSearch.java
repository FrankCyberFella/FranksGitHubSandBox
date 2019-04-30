package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
	

		int count = 0;
		//File wordSearch = new File("WordSearchTesting");
		System.out.print("What file are you trying to search >>> ");
		Scanner keyboard = new Scanner(System.in);
		String file = keyboard.nextLine();
		//File wordSearch = new File("alices_adventures_in_wonderland.txt");

		
		try {
			File wordSearch = new File(file);
			Scanner input = new Scanner(wordSearch);
			System.out.print("What is the search you are looking for? ");
			String word = keyboard.nextLine();
			word = word;
			
			System.out.print("Should the search be case sensitive (Y/N) ");
			boolean isCaseSensitive = false;
			String yesNo = keyboard.nextLine();
			yesNo = yesNo.toUpperCase();
			if (yesNo.equals("Y")) {
				isCaseSensitive = true;
			} else {
				word = word.toLowerCase();
			}

			
			while (input.hasNextLine()) {
				//System.out.println(count);
				count++;
				String line = input.nextLine();
				String line2 = line;
				line = line.toLowerCase();
				
				if (isCaseSensitive) {
					if (line2.contains(word)) {
						System.out.println(count + ") " + line2);
					}
				}

				if (!isCaseSensitive) {
					if (line.contains(word)) {
						System.out.println(count + ") " + line2);
					}
				}

				}
		
		} catch (Exception e) {
			
		}

		
		
	}

}
