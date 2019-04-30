package com.techelevator;

import java.util.Scanner;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		final double CONVERSION_FACTOR = 0.378;
		
		String temp = "";
		
		System.out.print("Enter a series of Earth weights (space-separated): ");
		temp = keyBoard.nextLine();
		String[] tempStringArray = temp.split(" ");
		
		double[] weightMars = new double[tempStringArray.length];
		double[] weightEarth = new double[tempStringArray.length];
		
		for(int i = 0; i < tempStringArray.length; i++) {

			weightEarth[i] = Double.parseDouble(tempStringArray[i]);
			
			weightMars[i] = weightEarth[i] * CONVERSION_FACTOR;
		}
			
		System.out.println("---");
		for(int i = 0; i < tempStringArray.length; i++) {
			System.out.println((int)weightEarth[i] + " lbs. on Earth, is " + (int)weightMars[i] + " lbs. on Mars.");
			
		}
		
		

	}

}
