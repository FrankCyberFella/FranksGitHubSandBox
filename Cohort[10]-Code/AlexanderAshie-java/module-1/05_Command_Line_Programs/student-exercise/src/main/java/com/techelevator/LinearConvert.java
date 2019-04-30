package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		final double FEET_TO_METER_CONVERSION = 0.3048;
		final double METER_TO_FEET_CONVERSION = 3.2808399;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the length: ");
		String tempString = input.nextLine();
		int enteredUnit = Integer.parseInt(tempString);
		
		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		tempString = input.nextLine();
		
		if (tempString.equals("f")) {
			double metersConverted = enteredUnit * FEET_TO_METER_CONVERSION;
			System.out.println((int)enteredUnit + tempString + " equals " + (int)metersConverted + "m.");
		}
		
		if (tempString.equals("m")) {
			double feetConverted = enteredUnit * METER_TO_FEET_CONVERSION;
			System.out.println((int)enteredUnit + tempString + " equals " + (int)feetConverted + "f.");
		}
		
		

	}

}
