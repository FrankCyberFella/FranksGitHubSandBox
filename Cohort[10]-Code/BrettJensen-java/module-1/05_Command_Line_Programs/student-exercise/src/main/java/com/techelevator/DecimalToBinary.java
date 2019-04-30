package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		String newBinary = "";
		String aLine = "";
		
		System.out.println("Please enter a series of decimal values (separated by spaces): ");
		aLine = keyboard.nextLine();								// place input in string aLine
		String[] stringArray = aLine.split(" ");					// create stringArray to hold aLine values
		int[] decimalArray = new int[stringArray.length];			// create int decimalArray length of stringArray
		for(int i = 0; i < stringArray.length; i++) {				// for loop to pareseInt stringArray into decimalArray
			decimalArray[i] = Integer.parseInt(stringArray[i]);
		}
		for(int i = 0; i < decimalArray.length; i++) {				// for loop of decimalArray.length
			newBinary = Integer.toBinaryString(decimalArray[i]);	// assign decimalArray[i] to newBinary
			System.out.println(decimalArray[i] + " in binary is " + newBinary);		// print to console
		}

	}

}
