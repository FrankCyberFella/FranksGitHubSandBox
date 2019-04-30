package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		String aLine = new String();
		
		int sum = 0;
		
		Scanner keyBoard = new Scanner(System.in); 
		
		System.out.println("Please enter three positive numbers separated by spaces ");
		
		aLine = keyBoard.nextLine();
		
		System.out.println("You entered: " + aLine);
		
		String[] numsAsStrings = aLine.split(" ");
		
		for (int i = 0; i < numsAsStrings.length; i++);
		
		sum += Integer.parseInt(numsAsStrings[sum]);
		
		System.out.println("Sum of values is: " + sum);

	} 

}
 