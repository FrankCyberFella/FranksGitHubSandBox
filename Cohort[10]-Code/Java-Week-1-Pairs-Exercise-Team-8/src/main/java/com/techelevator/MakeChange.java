package com.techelevator;

import java.util.Scanner;


/*
 Write a command line program which prompts the user for 
 the total bill, and the amount tendered. It should then display the change required.
 
 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		
		double bill;
		double tendered;
		double change;
		
		String temp = "";
		
		Scanner keyBoard = new Scanner(System.in);
		
		System.out.print("Please enter the amount of the bill: ");
		temp = keyBoard.nextLine();
		bill = Double.parseDouble(temp);
		
		System.out.print("Please enter the amount tendered: ");
		temp = keyBoard.nextLine();
		tendered = Double.parseDouble(temp);
		
		change = tendered - bill;

		System.out.println("The change required is " + change);
	
		
		

	}

}
