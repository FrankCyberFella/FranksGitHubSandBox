package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		Scanner userInput = new Scanner(System.in);

		File inputFile = getFile();
		String wordToReplace = getWordToReplace();
		String wordToInsert = getWordToInsert();
		File newFileName = getNewFileName();

		try (Scanner documentScanner = new Scanner(inputFile)) {
			PrintWriter writer = new PrintWriter(newFileName);
			newFileName.createNewFile();

			int lineNumber = 1;

			while (documentScanner.hasNextLine()) {
				String doc = documentScanner.nextLine();
				// String[] lines = doc.split("\n");
				String newDoc = doc.replaceAll(wordToReplace, wordToInsert);

				writer.println(newDoc);
			}
		}
	}

//				//String other = doc.replaceAll("\\s", "");
//				String[] words = doc.split(" ");
//
//				//String caseIgnoreWord = "";
//
//				//for (String number : lines) {
////					String newNumber = number.replaceAll("\"", "");
////					String[] lineWords = newNumber.split(" ");
//						for (String instance : words) {
//							String newInstance = instance.replaceAll("\"", "");
//							if (newInstance.equals(wordToReplace)) {
//								try(PrintWriter writer = new PrintWriter(newFileName)){
//									
//								}
//								System.out.print(lineNumber + ") ");
//								System.out.println(doc);
//							}
//						}
//
//					}
//					lineNumber++;
//				}
//			
//			}
//			} catch (FileNotFoundException e) {
//			System.out.println("File Does Not Exist");
//		}
//		
//
//		
//		
//	
//		
//		
//	}
//
//	
//	
//	

	public static File getFile() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		File file = new File(path);
		return file;
	}

	public static String getWordToReplace() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a word to replace >>> ");
		String word = userInput.nextLine();
		return word;
	}

	public static String getCasePreference() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Do you want the search to be case sensitive? Y or N >>> ");
		String capitals = userInput.nextLine();
		return capitals;
	}

	public static String getWordToInsert() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a word to replace it with >>> ");
		String capitals = userInput.nextLine();
		return capitals;
	}

	public static File getNewFileName() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a file name for the new file >>> ");
		String newFile = userInput.nextLine();
		File file = new File(newFile);
		return file;
	}
}
