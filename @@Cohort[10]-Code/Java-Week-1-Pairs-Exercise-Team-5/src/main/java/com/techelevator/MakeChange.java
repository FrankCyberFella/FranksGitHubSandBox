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
		
		Scanner keyBoard = new Scanner(System.in);
		double bill = 0.0;
		double amtTender = 0.0;
		double change = 0.0;
		
		String aLine = "";
		
		System.out.println("Please enter the amount of the bill: ");
		aLine = keyBoard.nextLine();
		bill = Double.parseDouble(aLine);
		
		System.out.println("Please entered amount tendered: ");
		aLine = keyBoard.nextLine();
		amtTender = Double.parseDouble(aLine);
		
		
		change = amtTender - bill;
		System.out.println("Your change is: " + change);
		
;		
	}

}
