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
		
		Scanner keyBoard= new Scanner(System.in);
		
		double weightEarth = 0;
		double weightMars = 0;
		double conversion = 0.378;
		
		String aLine = "";
		
		System.out.println("Enter a series of weights (space-seperated): ");
		aLine = keyBoard.nextLine();
		weightEarth = Integer.parseInt(aLine);
		
		weightMars = weightEarth * conversion;
		
		System.out.println(weightEarth + "lbs. on Earth, is " + weightMars + " on Mars.");
		
		/* System.out.println("Enter a series of weights (space-seperated): ");
		aLine = keyBoard.nextLine();
		weightEarth = Integer.parseInt(aLine);
		
	
		
		System.out.println(weightEarth + "lbs. on Earth, is " + weightMars + " on Mars.");
		
		System.out.println("Enter a series of weights (space-seperated): ");
		aLine = keyBoard.nextLine();
		weightEarth = Integer.parseInt(aLine);
		
		
		System.out.println(weightEarth + "lbs. on Earth, is " + weightMars + " on Mars."); */


	}

}
