package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		int temperature = 0;
		final double CONVERSION_FACTOR_1 = 1.8;
		final double CONVERSION_FACTOR_2 = 32;

		String temporaryInputTemperature = "";
		String temporaryInputLetter = "";
		
		System.out.print("Please enter the temperature: ");
		temporaryInputTemperature = keyBoard.nextLine();
		temperature = Integer.parseInt(temporaryInputTemperature);
		
		System.out.print("Is the temperature provided (C)elsius, or (F)arenheit? ");
		temporaryInputLetter = keyBoard.nextLine();
	
		if(temporaryInputLetter.equals("F")) {
			double convertToCelsius = (temperature - CONVERSION_FACTOR_2) / CONVERSION_FACTOR_1;
			System.out.print(temperature + "F is " + (int)convertToCelsius + "C.");	
				} 
		if(temporaryInputLetter.equals("C")) {
			double convertToFahrenheit = temperature * CONVERSION_FACTOR_1 + CONVERSION_FACTOR_2;
			System.out.print(temperature + "C is " + (int)convertToFahrenheit + "F.");
				}
	}
}
/*
 * return (Integer.parseInt(temporary) * 1.8 + 32 + "F");
 * 	fahrenheit = Integer.parseInt(temporaryInputLetter);
 */
