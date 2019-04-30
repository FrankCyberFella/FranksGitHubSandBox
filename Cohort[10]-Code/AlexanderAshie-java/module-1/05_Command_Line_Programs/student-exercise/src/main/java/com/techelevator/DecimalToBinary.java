package com.techelevator;

import java.util.Scanner;

//Imported Arrays so I could quickly handle printing arrays so I could go to sleep
import java.util.Arrays;

//The point of this particular exercise was to try and go a little above and beyond and make my brain think.  Writing a custom method, etc.
//The output isn't exactly like the PDF because of the Arrays method usage
public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Get the raw user input
		System.out.print("Please enter a series of decimal values (separated by spaces): ");
		String rawUserInput = input.nextLine();
		
		//Parse the raw user input into a String array based on spaces
		String[] userInputStringArray = rawUserInput.split(" ");
		
		//Declare an int array to hold int values for conversion
		int[] userInputIntArray = new int[userInputStringArray.length];
		
		//Parse the String array into a new integer array
		for (int i = 0; i < userInputStringArray.length; i++) {
			userInputIntArray[i] = Integer.parseInt(userInputStringArray[i]);
		}
		
		//Do conversion as many times as the user has inputed data
		//Call custom method that performs the calculation, then output result		
		for (int i = 0; i < userInputIntArray.length; i++) {
			System.out.println(userInputIntArray[i] + " in binary is " + Arrays.toString(convertIntDecimalToBinary(userInputIntArray[i])));
			
		}
		
	}
	
	//Custom method to do the conversion of one entry
	public static String[] convertIntDecimalToBinary(int anInteger) {
		
		//Flag for while loop -- Finding the length of an array
		boolean continueToDivideLengthFind = true;
		
		//Define variables for conversion calculation and finding the length of a needed array to store values
		int quotient = anInteger;
		int remainder = quotient % 2;
		int arraySize = 0;
		
		//Loop that simply finds the needed length of the array to store remainder values
		while (continueToDivideLengthFind) {
	
			quotient = quotient / 2;
			
			if(quotient < 1) {
				continueToDivideLengthFind = false;
			}
			
			arraySize++;
			
		}
		
		//Set quotient back to original value so actual calculation can be done
		quotient = anInteger;
		remainder = quotient % 2;
		
		//Declare a String array based on the found array size as to subvert any limitations of int or long data types
		String[] stringArray = new String[arraySize];
		
		//Loop that does the actual calculation and stores values in the array	
		//Uses the reset arraySize as a counter for array elements
		//Using the toString method because I've been trying to be too fancy already, so I may as well just go big or go home at this point
		
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = Integer.toString(remainder);
	
			quotient = quotient / 2;
			remainder = quotient % 2;
			
		}
		
		//Reverses the generated array to reflect correct Binary values
		//Still using arraySize as a value for loop or array length
		//Declare a temp array to be written to
		String[] reversedArray = new String[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++) {
			reversedArray[i] = stringArray[stringArray.length - 1 - i];  
		}
		
		return reversedArray;
		
	}
	
	
}
