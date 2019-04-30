package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	static int searchLine = 1;//starts at line 1
	static File aliceText = new File("alices_adventures_in_wonderland.txt");

	public static void main(String[] args) throws FileNotFoundException {
		//**********wrap in a try catch
		// Ask user search for string
		Scanner keyBoard = new Scanner(System.in);// Create a scanner object to read users keyBoard.
		System.out.println(" Please Enter Word to Search");
		String wordSearch = keyBoard.nextLine();// takes the word and puts into word search

		// Ask user search for filesystem path
		System.out.println("What is the File Path");
		String filePath = keyBoard.nextLine();
		File fileSearch = new File(filePath);
		// Search file for occurrences of the string
		try (Scanner fileScanner = new Scanner(fileSearch)) {
			// loop while the file has a next line
			while (fileScanner.hasNextLine()) {
				// read a line from the file
				String lineInTheFile = fileScanner.nextLine();
				if (lineInTheFile.contains(wordSearch)) {
					//if word is found print number line and line in file 
					System.out.println(searchLine);
					System.out.println(lineInTheFile);
					//then increase line number when it loops back 
				searchLine++;
				} else {
					
					//then increase line number when it loops back
					searchLine++;
				}
			}
			fileScanner.close();
			keyBoard.close();
			// alices_adventures_in_wonderland.txt
		}
///Users/antoinettemckinney/workspace/AntoinetteMcKinney-java/module-1/17_FileIO_Reading_in/student-exercise/java/alices_adventures_in_wonderland.txt
	}
}
