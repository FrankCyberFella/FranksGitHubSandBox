package com.techelevator;

import java.util.Scanner;

import java.text.DecimalFormat;
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
		
		Scanner keyBoard = new Scanner (System.in);
		
		double billAmount = 0.0;
		double amountTendered = 0.0;
		double change = 0.0;
		
		String billLine = "";
		
		System.out.println("Please enter the amount of the bill: ");
		billLine = keyBoard.nextLine();
		billAmount = Double.parseDouble(billLine);
		
		System.out.println("Please enter the amount tendered: ");
		billLine = keyBoard.nextLine();
		amountTendered = Double.parseDouble(billLine);
		
		change = amountTendered - billAmount;
		DecimalFormat dec = new DecimalFormat("#0.00");
		String changeFormatted = dec.format(change);
		
		System.out.println("The change required is $" + changeFormatted);
		
	} 

}
