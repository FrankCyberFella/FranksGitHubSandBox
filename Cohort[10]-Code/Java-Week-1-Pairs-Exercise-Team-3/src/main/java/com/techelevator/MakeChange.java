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

		double bill;
		double tendered;
		double change;
		String words;

		System.out.print("Please enter the amount of the bill: ");

		words = keyBoard.nextLine();

		bill = Double.parseDouble(words);

		System.out.print("Please enter the amount tendered: ");

		words = keyBoard.nextLine();

		tendered = Double.parseDouble(words);

		change = tendered - bill;

		System.out.println("The change required is: " + change);
	}

}
