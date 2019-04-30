package com.techelevator;

import java.util.Scanner;
//public static void main(String[] args) {
//
//    Scanner input = new Scanner(System.in);
//
//    //greet the user and prompt them to enter a start from, end with, and increment value
//    System.out.print("Enter a kilometer value to start at: ");
//    String value = input.nextLine();
//    int kilometerStart = Integer.parseInt(value);
//
//    System.out.print("Enter a kilometer value to end with: ");
//    value = input.nextLine();
//    int kilometerEnd = Integer.parseInt(value);
//
//    System.out.print("How many should it increment by: ");
//    value = input.nextLine();
//    int incrementBy = Integer.parseInt(value);
//
//    System.out.println("Going from " + kilometerStart + "km to " + kilometerEnd + 
//        "km in increments of " + incrementBy + "km.");
//
//    //print out each value converted into miles from start from to end with 
//    for (int i = kilometerStart; i <= kilometerEnd; i += incrementBy) {
//        System.out.println(i + "km is " + i * 0.621371 + "mi.");
//    }
//}

public class DecimalToBinary {
	
			
	
	public static void main(String[] args) {
		//greet the user and prompt them to enter a series of decimal values between 255 and 0 (separated by spaces)
		//print out each value converted into binary
		 Scanner kbd = new Scanner(System.in);
		
			System.out.println("Hello! Please enter a series of decimal values (separated by spaces):"); //prints out a message
			
			String numString = kbd.nextLine();//sets the value of the user input to "numValue"
			
			String [] userInput = numString.split(" ");
			
			for(int i = 0; i < userInput.length; i++) {
				
				int decimalValue = Integer.parseInt(userInput[i]);
				String binaryString = new String("");
				
			
				for(; decimalValue > 0;) {
				
					binaryString = (decimalValue %2) + binaryString;
			
					decimalValue = (decimalValue / 2);
				
				}
				System.out.println(userInput[i] + " is " + binaryString + " in binary");
			}
			
}
}			
		
		
		

	


