package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		String fibon = "";
		int fibVal = 0;
		int val1 = 0;
		int val2 = 1;
		int storeVal = 0;

		Scanner keyBoard = new Scanner(System.in);
		System.out.print("Please enter the Fibonacci number: ");
		
		fibon = keyBoard.nextLine();
		fibVal = Integer.parseInt(fibon);
		
		System.out.print(0 + " ");
		
		for(int i = 0; val2 <= fibVal; i++) {
			System.out.print(val2 + " ");
			storeVal = val2;
			val2 = val1 + storeVal;
			val1 = storeVal;


		
		}

	}

}
