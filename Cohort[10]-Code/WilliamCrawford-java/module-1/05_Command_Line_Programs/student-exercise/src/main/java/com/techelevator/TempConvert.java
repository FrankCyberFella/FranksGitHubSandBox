/*Please enter the temperature: 58
Is the temperature in (C)elcius, or (F)arenheit? F
58F is 14C.
 * 
 */
package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		
		
		double tempInput = 0.0;
		double tempConverted = 0.0;
		String aLine = "";
		String choice = "";
		
		System.out.println("Please enter a Temperature:   ");
		aLine = keyboard.nextLine();
		
		tempInput = Double.parseDouble(aLine);
		
		
		
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?   ");
		
		choice = keyboard.nextLine();
		
		if(choice.equalsIgnoreCase("c")){
			
			tempConverted = tempInput * 1.8 + 32;
			
			System.out.printf("%.1f C is %.1f F", tempInput, tempConverted);
		}
		else {
			tempConverted = (tempInput - 32) / 1.8;
			
			System.out.printf("%.1f F is %.1f C", tempInput, tempConverted);
		
		}
		
		
	}

}
