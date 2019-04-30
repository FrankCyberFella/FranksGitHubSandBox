package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		final double TEMP_CONVERSION_FACTOR = 1.8;
			
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the temperature: ");
		String tempString = input.nextLine();
		int temperature = Integer.parseInt(tempString);
		
		System.out.print("Is the temperature in (C)elsius, or (F)arenheit? ");
		tempString = input.nextLine();
		
		if (tempString.equals("C")) {
			double tempFaren = temperature * TEMP_CONVERSION_FACTOR + 32;
			System.out.println((int)temperature + tempString + " is " + (int)tempFaren + "F.");
		}
		
		if (tempString.equals("F")) {
			double tempCels = (temperature - 32) / TEMP_CONVERSION_FACTOR;
			System.out.println((int)temperature + tempString + " is " + (int)tempCels + "C.");
		}	
	}

}
