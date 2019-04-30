package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {

	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();

		File inputFile = getInputFileFromUser(); // define a file object to represent the file
		// the above assignment to method not really necessary

		// File inputFile = new File("rtn.txt") // another way to do it (directly), if
		// you know it is all correct

		try (Scanner fileScanner = new Scanner(inputFile)) {
			while (fileScanner.hasNextLine()) { // loop while the file has a next line
				String line = fileScanner.nextLine(); // read a line f
				String rtn = line.substring(0, 9);
				System.out.print("RTN : " + rtn);
				if (checksumIsValid(rtn) == false) {
					System.out.println(" - Invalid");
				} else {
					System.out.println(" - Valid");
				}
				fileScanner.close();
			}
		} catch (Exception e) {  
			   // get this in right place
		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() { // return a (reference/pointer to) File object for a file that that
													// exists (a
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		// because of file is in the same directory as our project, all we had to give
		// it was the name of the file.
		// If the file was in a different path we would have to type in the whole path
		// name.

		String path = userInput.nextLine(); // get path for file from user
		System.out.println("Path entered: " + path + "\n");
		File inputFile = new File(path); // Define a File object to represent the file ***
		// File is a class to represent files. It has a one arg ctor that takes the path
		// (path to the file) for the file.

		// inputFile. check out the methods available and play with these..
		if (inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path + " does not exist");
			System.exit(1); // Ends the program
		} else if (inputFile.isFile() == false) { // is it really a file
			System.out.println(path + " is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for (int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i + 1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
