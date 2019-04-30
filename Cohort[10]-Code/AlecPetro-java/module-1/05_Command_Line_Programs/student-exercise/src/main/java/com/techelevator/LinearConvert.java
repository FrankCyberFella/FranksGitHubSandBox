package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		final double CONVERSION_FACTOR_TO_METERS = 0.3048;
		final double CONVERSION_FACTOR_TO_FEET = 3.2808399;
		
		double length = 0;
		
		String temporaryNumber = "";
		String temporaryLetter = "";
		
		
		System.out.println("This program converts meters to feet and vice-versa");
		System.out.println("---");

		System.out.print("Please enter the length: ");
		temporaryNumber = keyBoard.nextLine();
		length = Double.parseDouble(temporaryNumber);
		
		System.out.print("Is the measurement in (m)eter or (f)eet: ");
		temporaryLetter = keyBoard.nextLine();
		
		if(temporaryLetter.equals("m")) {
			double convertToFeet = length * CONVERSION_FACTOR_TO_FEET;
			System.out.print((int)length + "m is " + (int)convertToFeet + "f.");
		}
		if(temporaryLetter.equals("f")) {
			double convertToMeter = length * CONVERSION_FACTOR_TO_METERS;
			System.out.print((int)length + "f is " + (int)convertToMeter + "m.");
		}
		
		
		
	}

}
