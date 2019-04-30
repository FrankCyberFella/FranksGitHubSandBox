package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
	
		File input = getNewFile();
		String word = wordToSearch();
		boolean caseCheck = checkCase();
		
		try(Scanner file = new Scanner(input)){
			int lineCount = 1;
			while(file.hasNextLine()) {
				String line = file.nextLine();
				if(!caseCheck) {
					line = line.toLowerCase();
					word = word.toLowerCase();
				}
				if(line.contains(word)) {
					System.out.println(lineCount + ") " + line);			
				}
				lineCount++;
			}
		}
		
	}

	public static File getNewFile() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the search word you are looking for? ");
		String path = input.nextLine();
		File file = new File(path);
		if(file.exists() == false) {
			System.out.println("The file does not exist");
			System.exit(1);
		}
		if(file.canExecute() == false) {
			System.out.println("The file can not be executed");
			System.exit(2);
		}
		return file;
	}
	
	public static String wordToSearch() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String word = input.nextLine();
		return word;
	}
	
	public static boolean checkCase() {
		Scanner input = new Scanner(System.in);
		System.out.println("Should the search be case sensitive? (Y\\N)");
		String checkCase = input.nextLine().toUpperCase();
		if(checkCase.equals("Y")) {
			return true;
		} else {
			return false;
		}
	}
	
}
