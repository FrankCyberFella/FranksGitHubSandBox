package com.techelevator;

import java.util.Scanner; //include java code to support the Scanner class

public class Lecture {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in); //defining scanner object to access keyboard
		
		int aNumber = 0; //variable to hold keyboard input
		
		String aLine = ""; // variable to hold a line from the keyboard
		System.out.println("Please enter a number");
		aLine = keyboard.nextLine(); //get a line from keyboard and put it in variable aLine
		
		aNumber = Integer.parseInt(aLine); //convert a string to an integer
		aNumber++;
		
		System.out.println("The number you type incremented is: " + aNumber++);
	}

}
