package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		
		//File shortStory = new File("alices_adventures_in_wonderland.txt");
		//File shortStory = new File("computer10Commandments.txt");
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter search word: ");
		String searchWord = scan.nextLine();
		
		
		System.out.print("Please enter path to input file >>> ");
		String path = scan.nextLine();
		System.out.println("Path entered: " + path + "\n");
		File inputFile = new File(path);
		Scanner fileScanner = new Scanner(inputFile);
		int lineCount = 0;
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			lineCount ++;
			if(line.contains(searchWord)) {
				System.out.println(lineCount + ")" + line);
				}
			
			
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

