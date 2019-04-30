package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);
		int binaryInt;
		String binaryLine;
		
		System.out.println("Please enter in a series of decimal values seperated by spaces:");
		
		binaryLine = keyBoard.nextLine();
		String[] multipleStringNumsToIntNums = binaryLine.split(" ");
		
		int numsToConvertToBinary[] = new int[multipleStringNumsToIntNums.length];
		
		for(int i = 0; i < multipleStringNumsToIntNums.length; i++) {
			numsToConvertToBinary[i] = Integer.parseInt(multipleStringNumsToIntNums[i]);
		}
		
		for(int i = 0; i < numsToConvertToBinary.length; i++) {
			System.out.println(numsToConvertToBinary[i] + " in binary = " 
			+ Integer.toBinaryString(numsToConvertToBinary[i]));
		}
		
	}

}

//binaryInt = Integer.parseInt(binaryLine);


//Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

//Integer.toBinaryString(124)
//460 in binary is 111001100

/*
 * 
 		 * You should consider refactoring (changing) your "Decimal to Binary" and "Martian Weight" exercises to accept 
 		 * multiple values at a time from the keyboard. We will review this Monday morning.
		 * 
		 * 
		 * The String split() method may be used to divide a string into individual pieces based 
		 * on a delimiter/separator character passed to split.
		 * 
		 * The split method returns an array of Strings where each element is one of the pieces of the string.
		 * ****************************************************************************************************
		 * Example 1
		 * 
		 * String aString = "Bob, Carol, Ted, Alice";
		 * 
		 * String[] words = aString.split(",");  // Divide the string into pieces based on commas
		 * 
		 *                                   [0]     [1]    [2]     [3]    
		 * The words array would contain:  ------------------------------
		 *                                | Bob   | Carol | Ted   | Alice|
		 *                                 ------------------------------
		 *****************************************************************************************************
		 * Example 2
		 * 
		 * String phoneNum = "440-555-1234";
		 * 
		 * String[] phoneNumParts = phoneNum.split("-");
		 * 
		 *                                          [0]    [1]    [2]
		 * The phoneNumParts array would contain:  --------------------
		 *                                        | 440  | 555  | 1234 |
		 *                                         --------------------
		 * *****************************************************************************************************
		 * Example 3
		 * 
		 * String someNums = "100 34 27";
		 * 
		 * String[] someNumsParts = someNums.split(" ");
		 * 
		 *                                          [0]  [1]   [2]
		 * The SomeNumsParts array would contain:  ----------------
		 *                                        | 100 | 34  | 27 |
		 *                                         ----------------
		 * *****************************************************************************************************		 * 
		 */
		
		/*System.out.print("Please enter a series of integer values separated by spaces: ");
		aLine = keyBoard.nextLine();
		
		String[] theNums = aLine.split(" ");       // split the values into individual elements of a String array
		int[] nums = new int[theNums.length];      // define an int array to hold the String array elements converted to ints
		
		for (int i=0; i<theNums.length; i++) {     // Loop through String array one element at a time
			nums[i] = Integer.parseInt(theNums[i]);// Convert the current element in String array to an int and store in an int array
		}
		double sum = 0;                            // Variable to hold the sum of the numbers
		
		for (int i=0; i<nums.length;i++) {         // Loop through the array of ints
			sum += nums[i];                        // Add an int array element to sun
		}
		double avg = sum / (double) nums.length;   // Calculate the average of the numbers	
		
		System.out.println("\nThe sum of your numbers is: " + sum);
		
		System.out.printf("The average of your number is: %.3f", avg);  // print avg with 3-decimal places */

