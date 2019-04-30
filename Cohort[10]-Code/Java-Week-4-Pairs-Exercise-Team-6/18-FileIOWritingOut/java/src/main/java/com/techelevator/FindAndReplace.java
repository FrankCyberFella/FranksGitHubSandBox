package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {		
			Scanner userInput = new Scanner(System.in);
			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();
			File inputFile = new File(path); 
			System.out.println("We got to line 35");
			if(inputFile.exists()) {
				System.out.println("name: " + inputFile.getName());
				System.out.println("absolutePath: " + inputFile.getAbsolutePath());
				if(inputFile.isDirectory()) {
					System.out.println("type: directory");
				}else if(inputFile.isFile()) {
					System.out.println("type: file");
				}
				System.out.println("size :" + inputFile.length());
			} else {
				System.out.println(inputFile.getAbsolutePath()+ " does not exist");
			}
			
			String newFileName = "replace_" + path;
			File newFile = new File(newFileName);
			
			try {
				newFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println();
			System.out.println("name: "+newFile.getName());
			System.out.println("absolutePath: "+newFile.getAbsolutePath());
			System.out.println("size : "+newFile.length());
			
			
			
			
			
			
			System.out.println("Please enter the word you would like to replace: ");
			String word = userInput.nextLine();
			System.out.println("Please enter the replacement: ");
			String replacement = userInput.nextLine();
			System.out.println("Should the search be case sensitive? (Y/N)");
			String caseSensitive = userInput.nextLine().toUpperCase();
			
			
			
			     Scanner wordSearch = new Scanner(inputFile);
			     try(PrintWriter writer = new PrintWriter(newFile)){
			    	while(wordSearch.hasNextLine()) {
					String aliceLine = wordSearch.nextLine();
					String newAliceLine = "";
					if(aliceLine.contains(word)) {
						newAliceLine = aliceLine.replace(word, replacement);
						writer.println(newAliceLine);
					} else {
						writer.println(aliceLine);
					}

				}
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("Invalid File");
				
			}

	}
}

