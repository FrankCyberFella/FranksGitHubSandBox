package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) throws FileNotFoundException {
		
		File bigFile = getNewFile();
		
		try(Scanner input = new Scanner(bigFile)){
			while(input.hasNextLine()) {
			String lines = input.nextLine();
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

}
