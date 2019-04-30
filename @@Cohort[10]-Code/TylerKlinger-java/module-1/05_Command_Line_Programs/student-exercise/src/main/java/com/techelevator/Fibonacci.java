package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		
		int maxNumber;
		int prevNumber;
		int nextNumber;
		
		maxNumber = 0;
		prevNumber = 0;
		nextNumber = 1;
	
		System.out.println("How many fibonacci numbers would you like?");
		
		Scanner keyboard = new Scanner(System.in);
		maxNumber = keyboard.nextInt();
		System.out.println("Fibonacci series of " + maxNumber + " numbers: ");
		
		
		for (int i = 0; i < args.length; i++) {
			
			System.out.print(prevNumber + " ");
			
			int sum = prevNumber + nextNumber;
			prevNumber = nextNumber;
			nextNumber = sum;
			
		}

	}

}
