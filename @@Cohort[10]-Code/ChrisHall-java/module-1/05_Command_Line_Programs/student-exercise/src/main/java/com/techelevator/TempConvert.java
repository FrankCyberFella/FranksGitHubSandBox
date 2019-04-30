package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);

		System.out.println("Please enter the temperature: ");
		String aLine = keyBoard.nextLine();
		int temp1 = Integer.parseInt(aLine);
		
		double tempF;
		double tempC = (temp1 - 32) / 1.8;
		tempF = (temp1 * 1.8) + 32;
	
		
		System.out.println("Is the temperature in (C)elcius, or (F)arenheit?");
		aLine = keyBoard.nextLine();
		
		
		if(aLine.equals("F")) {
			System.out.println(temp1 + "F" + " is " + (int)tempC + "C" );
		} else
			if (aLine.equals("C")) {
			System.out.println(temp1 + "C" + " is " + (int)tempF + "F");
		} 

	}

}



//Is the temperature in (C)elcius, or (F)arenheit?