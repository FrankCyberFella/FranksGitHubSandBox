//  Tc = (Tf - 32) / 1.8

package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		double fTemp = 0.0;
		double cTemp = 0.0;
		double thirdNum = 0.0;
		
		String C = "C"; 
		String F = "F";
		String tempLine = "";
		String degreeLine = "";
		
		System.out.println("Please enter your temperature:");
		
		tempLine = keyBoard.nextLine();
		
		thirdNum = Double.parseDouble(tempLine);
		
		System.out.println("Is your temperature F or C?");
		
		degreeLine = keyBoard.nextLine();
		
		
		if (degreeLine.equals("F")) {
			System.out.println("Your temperature in Celsius is " + ((thirdNum - 32) / 1.8) + "C");
		}
		 
		fTemp = Double.parseDouble(tempLine); 
		
		if (degreeLine.equals("C")) {
			System.out.println("Your temperature in Fahrenheit is " + (thirdNum * 1.8 + 32) + "F");
		}
	
		cTemp = Double.parseDouble(tempLine);
		

		

	}

}
