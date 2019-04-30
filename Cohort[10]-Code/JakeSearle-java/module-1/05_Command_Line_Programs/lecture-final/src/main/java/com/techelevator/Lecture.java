package com.techelevator;

import java.util.Scanner; // Include Java code to support Scanner

public class Lecture {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in); // defining scanner object to access keyboard
		
		int aNumber = 0; // variable to hold keyboard input
		
		String aLine = ""; // variable to hold line from keyboard
		
		System.out.println("Please enter a number");
		
		aLine = keyBoard.nextLine(); // get a line from keyboard and put it in variable aLine
		
		aNumber = Integer.parseInt(aLine); // converts a string to an integer
		
		aNumber++;
		
		System.out.println("The number you type incremented is: " + aNumber);
		
	}

}
