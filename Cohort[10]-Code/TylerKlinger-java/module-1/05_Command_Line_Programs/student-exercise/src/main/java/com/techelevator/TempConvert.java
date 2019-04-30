package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		double tempInput = 0;
		String tempType = "";
		String aLine = "";
		
		System.out.println("Enter temperature");
		aLine = keyBoard.nextLine();
		tempInput = Double.parseDouble(aLine);
		
		System.out.println("Is the temperature [C]elsius or [F]ahrenheit?");
		tempType = keyBoard.nextLine();
		
		
		if (tempType.equals("C")) {
			System.out.println(tempInput + "C is " + ((tempInput * 1.8) + 32) + "F");
		}
		if (tempType.equals("F")) {
			System.out.println(tempInput + "F is " + ((tempInput - 32) / 1.8) + "C");
		}	
	}
}
