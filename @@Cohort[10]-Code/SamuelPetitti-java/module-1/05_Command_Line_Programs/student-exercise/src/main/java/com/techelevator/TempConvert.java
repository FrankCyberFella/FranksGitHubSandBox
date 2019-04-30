package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner keyBoard = new Scanner(System.in);
		
		double tempNumHolder = 0.0;
		double tempC = 0.0;
		double tempF = 0.0;
		
		String tempNumLine;
		//String tempCTempFLine;
		
		System.out.println("Please enter your temperature:");
		tempNumLine = keyBoard.nextLine();
		tempNumHolder = Double.parseDouble(tempNumLine);
		
		System.out.println("Please enter F for Fahrenheit or C for Celsius:");
		tempNumLine = keyBoard.nextLine();
		
		
		if(tempNumLine.equalsIgnoreCase("F")){ 
			tempC = ((tempNumHolder - 32) / 1.8);
			System.out.println(tempNumHolder + "F is " + tempC + "C");
			} else {
				if(tempNumLine.equalsIgnoreCase("C")) {
					tempF = ((tempNumHolder * 1.8) + 32);
					}
			System.out.println(tempNumHolder + "C is " + tempF + "F");
		}
	}

}


