package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		//convert to new variable integer first 
		Scanner keyBoard = new Scanner (System.in);
		int numberChosen = 0;
		String yourNumber = "";
		
		System.out.println("Please enter the Fibonacci number");
		yourNumber = keyBoard.nextLine();
		numberChosen = Integer.parseInt(yourNumber);
		
		int[] fibonacciString = new int[numberChosen];
		
		for (int i = 0; i < 13; i++) {
			if (numberChosen == 0) {
			System.out.println("Your sequence is 0");
			break;
			}
			if (numberChosen == 1) {
				System.out.println("Your sequence is 0 , 1 , 1");
				break;
			}
			if (numberChosen == 2) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2");
				break;
			}
			if (numberChosen >= 3 && numberChosen < 5) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3");
				break;
			}
			if (numberChosen >= 5 && numberChosen < 8) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5");
				break;
			}
			if (numberChosen >= 8 && numberChosen < 21) { 
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5 , 8");
				break;
			}
			if (numberChosen >= 21 && numberChosen < 34) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5 , 8 , 21");
				break;
			}
			if (numberChosen >= 34 && numberChosen < 55) { 
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5 , 8 , 21 , 34 ");
				break;
			}
			if (numberChosen >= 55 && numberChosen < 89) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5 , 8 , 21 , 34 , 55");
				break;
			}
			if (numberChosen >= 89 && numberChosen < 144) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5 , 8 , 21 , 34 , 55 , 89");
				break;
			}
			if (numberChosen > 144) {
				System.out.println("Your sequence is 0 , 1 , 1 , 2 , 3 , 5 , 8 , 21 , 34 , 55 , 89 , 144");
				break;
			}
		}
		
		
}
}