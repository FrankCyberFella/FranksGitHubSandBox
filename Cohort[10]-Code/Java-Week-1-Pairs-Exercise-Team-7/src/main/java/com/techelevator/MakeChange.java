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
		
		Scanner keyboard = new Scanner(System.in);
		double bill = 0;
		double tendered = 0;
		double change;
		String amount = "";
		
		System.out.println("Please enter the amount of the bill: ");
		amount = keyboard.nextLine();
		bill = Double.parseDouble(amount);
		
		System.out.println("Please enter the amount tendered: ");
		amount = keyboard.nextLine();
		tendered = Double.parseDouble(amount);
		
		change = tendered - bill;
		System.out.println("The change required is " + change);
		
	}

}
