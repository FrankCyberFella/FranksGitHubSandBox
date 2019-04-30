package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then display the change required.
 
 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		Scanner keyBoard = new Scanner(System.in); //Define a Scanner object to access keyboard
		
		double amountOfBill = 0; //variable to hold keyboard input
		double amountTendered = 0;
		double amountOfChange = 0;
		
		String aLine = ""; //variable to hold a line from the keyboard
		System.out.print("Please enter the amount of the bill: ");
		
		aLine = keyBoard.nextLine(); //.nextLine() <--return a line from keyboard as a string
		amountOfBill = Double.parseDouble(aLine); //convert a string to an double
		
		System.out.print("Please enter the amount tendered: ");
		
		aLine = keyBoard.nextLine(); //.nextLine() <--return a line from keyboard as a string
		amountTendered = Double.parseDouble(aLine); //convert a string to an double
		
		System.out.printf("The change required is: %.2f", (amountTendered - amountOfBill));
	}

}
