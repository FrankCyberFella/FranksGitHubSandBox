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
		
		double dollaBills = 0.0;
		String aLine = "";
		double amountTendered = 0.0;
		double changeRequired = 0.0;
		
		
		System.out.println("Please enter the amount of the bill:");
		aLine = keyBoard.nextLine();
		dollaBills = Double.parseDouble(aLine);
		
		System.out.println("Please enter the amount tendered:");
		aLine = keyBoard.nextLine();
		amountTendered = Double.parseDouble(aLine);
		
		
		changeRequired = amountTendered - dollaBills;
		System.out.println("The change required is:" + changeRequired);
		
	}

}
 