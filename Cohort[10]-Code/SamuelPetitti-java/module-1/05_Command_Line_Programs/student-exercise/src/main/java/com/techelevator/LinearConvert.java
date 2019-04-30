package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner keyBoard = new Scanner(System.in);
		double meterOrFeet = 0.0;
		
		String lengthLine;
		System.out.println("Please enter the length: ");
		lengthLine = keyBoard.nextLine();
		meterOrFeet = Double.parseDouble(lengthLine);
		
		String measurementLine;
		System.out.println("Is the measurement in (m)eter or (f)eet?");
		measurementLine = keyBoard.nextLine();
		if(measurementLine.equalsIgnoreCase("m")) {
			System.out.println(meterOrFeet+ "m is " + (meterOrFeet * 3.2808399 ) + "f");
		} else {
			if(measurementLine.equalsIgnoreCase("f")) {
				System.out.println(meterOrFeet+ "f is " + (meterOrFeet * 0.3048) + "m");
			}
		}
	}
	
}

//m = f * 0.3048
//f = m * 3.2808399
//Please enter the length: 58
//Is the measurement in (m)eter, or (f)eet? f
//58f is 17m. 

