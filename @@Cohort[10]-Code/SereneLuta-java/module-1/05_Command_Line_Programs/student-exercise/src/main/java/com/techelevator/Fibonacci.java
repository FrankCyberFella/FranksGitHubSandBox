package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		 
		int firstFibNumber = 0;
		int secondFibNumber = 1;
		int fibNumber = firstFibNumber + secondFibNumber;
		int fibNumberInput = 0;
		
		String aLine = "";
		
		System.out.println("Please enter the Fibonacci number:");
		aLine = keyBoard.nextLine();
		fibNumberInput = Integer.parseInt(aLine);
		
		System.out.print("0" + " " + "1" + " ");
		
		while (secondFibNumber + firstFibNumber < fibNumberInput) {
			fibNumber = (secondFibNumber + firstFibNumber);
			firstFibNumber = secondFibNumber;
			secondFibNumber = fibNumber;
			
			System.out.print(fibNumber + " ");
			
		}
		
	}
}
		
