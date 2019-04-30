package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser()  //Define file object that represents the file
				
				Scanner fileScanner = new Scanner(inputFile);
		
		try{
			while(fileScanner.hasNextLine()) {					// loop while file has a next line
				String line = fileScanner.nextLine();			// read a line from a file
				String rtn = line.substring(0, 9);
				System.out.print("RTN : " + rtn);
				if(checksumIsValid(rtn) == false) {
					System.out.println(" - Invalid");
				}
					else {
						System.out.println(" - Valid");
				}
			}	
			}
		catch (Exception e) {
			fileScanner.close();
		}
		}
	

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {		// return a File object for a file that exists
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();			// Get the path for the file from the user
		System.out.println("Path entered: "+ path + "\n");
		File inputFile = new File(path);		//Define a file object to represent a file
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
