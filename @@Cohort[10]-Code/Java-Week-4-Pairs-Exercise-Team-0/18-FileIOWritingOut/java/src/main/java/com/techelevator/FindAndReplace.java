package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		File inputFile = getFile();
		getWord(inputFile);
		
		File replaceWordFile = new File("replaceWordFile.txt");	
		replaceWordFile.createNewFile();
	}
		
		
		private static File getFile() {
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("What is the file that should be searched?");
			File inputFile = new File(userInput.nextLine());
			
			if(inputFile.exists()) {
				return inputFile;
			}
			else {
				if(inputFile.exists() == false) {
					System.out.println("File does not exist");
					System.exit(1);
				}
				return inputFile;
		}
	}
			
			public static void getWord(File inputFile) {
				Scanner userWordInput = new Scanner(System.in);
				System.out.println("What is word you wish to replace?");
				String word = userWordInput.nextLine();
				System.out.println("What word do you want to replace it with?");
				String newWord = userWordInput.nextLine();
				
				try {
					Scanner wordSearch = new Scanner(inputFile);
					File replaceWordFile = new File("replaceWordFile.txt");	
					replaceWordFile.createNewFile();
					PrintWriter writer = new PrintWriter(replaceWordFile);
					
					while (wordSearch.hasNextLine()) {
						String currentLine = wordSearch.nextLine();
//						String[] splitArray = currentLine.split(" ");
						
//						String[] spaceSplit = currentLine.split(" ");
//						for(String replace: splitArray) {
							String newAlice = currentLine.replaceAll(word, newWord);
							writer.println(newAlice);
							
//						}
//							if (replace.contains(word)) {
//								currentLine.split(" ");
//								String newContent = word.replaceAll(word, newWord);
//								writer.print(newContent);
//							}
//							else {
//								writer.println(currentLine);;
//							}
//						}
//						
						}
			} catch (Exception e) {
			
			}
			
		}

}
