package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		
			File inputFile = userInputFile();
			File replacedWord = userDestinationFile();
			replacedWord.createNewFile();
			Scanner fileScanner = new Scanner(inputFile);
			
			Scanner keys = new Scanner(System.in);
			System.out.println("What is the word that you are looking for?");
			String searchWord = keys.nextLine();
			System.out.println("What word would you like to replace it with?");
			String newWord = keys.nextLine();
			
			try (PrintWriter writer = new PrintWriter(replacedWord)) {
				
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					if(line.contains(searchWord)) {
						String lineNew = line.replaceAll(searchWord, newWord);
						 {
							writer.println(lineNew);
						}
					}
					else { writer.println(line); }
				}
				
			} catch (Exception e) {
			}
		}

		private static File userInputFile() {
			Scanner keys2 = new Scanner(System.in);
			System.out.print("What is the file that should be searched?\n");
			String input = keys2.nextLine();
			File inputFile = new File(input);
			if(!inputFile.exists()) {
				System.out.println(input+" is nonexistent.");
				System.exit(1);
			} else if(!inputFile.isFile()) {
				System.out.println(input+" is not a file.");
				System.exit(1);
			}
			return inputFile;
		}
		
		private static File userDestinationFile() {
			Scanner keys3 = new Scanner(System.in);
			System.out.print("What is the destination?\n");
			String input = keys3.nextLine();
			File replacedWord = new File(input);
			if(!replacedWord.exists()) {
				System.out.println(input+" is nonexistent.");
				System.exit(1);
			} else if(!replacedWord.isFile()) {
				System.out.println(input+" is not a file.");
				System.exit(1);
			}
			return replacedWord;
		}

	}

