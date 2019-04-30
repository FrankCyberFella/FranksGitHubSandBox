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
		Scanner keyboard = new Scanner(System.in);
		
		String userInput;
		double earthWeight;
		double martianWeight;
		final double conversionFactor = 0.378; 
		boolean userContinue=true;
		

			System.out.print("Enter a series of Earth Weights (separated by spaces): ");
			
			userInput=keyboard.nextLine();
			String[]userInputSplit = userInput.split(" ");
			for  (int i = 0; i<userInputSplit.length; i++) 
			{
				earthWeight=Double.parseDouble(userInputSplit[i]);
				martianWeight=earthWeight*conversionFactor;
				System.out.printf ("%.2f lbs. on Earth, is %.2f lbs. on Mars.",earthWeight,martianWeight);
				System.out.println();
			}

			

			

		

	}

}
