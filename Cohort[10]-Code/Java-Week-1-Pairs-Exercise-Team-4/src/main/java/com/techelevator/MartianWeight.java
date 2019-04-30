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
		
		Scanner keyBoard = new Scanner (System.in);
		String weightLine = "";
		
		System.out.println("Please enter a series of Earth weights (space-seperated):");
		weightLine = keyBoard.nextLine();
		String[] weightLineSplit = weightLine.split(" ");
		int[] multipleEarthWeights = new int[weightLineSplit.length];
		
		for(int i = 0; i < weightLineSplit.length; i++) {
			multipleEarthWeights[i] = Integer.parseInt(weightLineSplit[i]);
		}
		
		for(int i = 0; i < multipleEarthWeights.length; i++) {
			System.out.println(multipleEarthWeights[i] + " lbs. on Earth, is " + (multipleEarthWeights[i] * 0.378) + " lbs. on Mars.");
		}
		
		
		
		
	
	}
}
// marsWeight = earthWeight * 0.378;
//earthWeight = Integer.parseInt(weightLine);


