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
		
		Scanner  keyBoard = new Scanner(System.in);
		
		double totalBill = 0;
		double totalPaid = 0;
		
		String aLine = "";
		
		System.out.println("Please enter amount due");
		aLine = keyBoard.nextLine();
		totalBill = Double.parseDouble(aLine);
		
		System.out.println("Please enter amount paid");
		aLine = keyBoard.nextLine();
		totalPaid = Double.parseDouble(aLine);
		
		double changeMade = totalPaid - totalBill;
		
		System.out.println("Change due " + changeMade);
		
		
		
		
		

	}

}
