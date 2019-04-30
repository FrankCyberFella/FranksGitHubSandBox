package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		System.out.println("Path entered: "+ path + "\n");
		File inputFile = new File(path); 
		
		System.out.println("Please enter the word you would like to search for: ");
		String word = userInput.nextLine();
		System.out.println("Should the search be case sensitive? (Y/N)");
		String caseSensitive = userInput.nextLine().toUpperCase();
		int lineCounter = 1;
		
		try(Scanner wordSearch = new Scanner(inputFile)){
			while(wordSearch.hasNextLine()) {
				String aliceLine = wordSearch.nextLine();
				String [] aliceLineSplit = aliceLine.split(" ");
				for(int i = 0; i < aliceLineSplit.length; i++) {
					if(caseSensitive.equals("Y")) {
					if(aliceLineSplit[i].contains(word)) {
					  System.out.println(lineCounter + ") " + aliceLine);
						}
					} else {
						word = word.toLowerCase();
						if(aliceLineSplit[i].toLowerCase().contains(word)){
							System.out.println(lineCounter + ") " + aliceLine);
						}
					}
				} lineCounter ++;
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Invalid File");
		}
		
	}

}

//alices_adventures_in_wonderland.txt
