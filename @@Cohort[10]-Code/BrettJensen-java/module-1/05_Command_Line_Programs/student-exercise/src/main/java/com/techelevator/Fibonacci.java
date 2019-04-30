package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		String fibon = "";											// initial user input in type String 
		int maxValue = 0;
		int firstValue = 0;											// default first value
		int nextValue = 1;											// default second value (if  < fibValue )
		int lastValue = firstValue;									// sum of previous two values;
		
		System.out.println("Please enter the Fibonacci number: ");  // request for user input
		fibon = keyboard.nextLine();								// holder for user input
		maxValue = Integer.parseInt(fibon);							// input parsed to Integer
		
		if(nextValue > maxValue) {									// if next value is greater that maxValue
			System.out.print("{ " + firstValue + " }");				// print only firstValue and close
		} else {
			System.out.print("{ " + firstValue);					// print firstValue and leave open
			while(nextValue <= maxValue){							// while nextValue is less that maxValue
				System.out.print(", ");								// print punctuation
				System.out.print(nextValue);						// print nextValue
				int holdValue = lastValue + nextValue;				// create a variable to hold sum of last two
				lastValue = nextValue;								// assign lastValue to equal nextValue
				nextValue = holdValue;								// assign nextValue to equal holdValue
			}
			System.out.print(" }");									// close brackets when maxValue is reached		
		}	
	}

}
