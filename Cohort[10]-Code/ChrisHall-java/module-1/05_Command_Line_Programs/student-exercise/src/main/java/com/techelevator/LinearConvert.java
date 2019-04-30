package com.techelevator;

import java.util.Scanner;
/*  Please enter the length: 58
	Is the measurement in (m)eter, or (f)eet? f
	58f is 17m.*/
public class LinearConvert {

	
	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Please enter the length: ");
		String aLine = keyBoard.nextLine();
		int length = Integer.parseInt(aLine);
		double mToF = length *  3.2808399;
		double fToM = length *  0.3048;
		System.out.println("Is the measurement in (m)eter, or (f)eet?");
		aLine = keyBoard.nextLine();
		
		if(aLine.equals("m")) {
			System.out.println(length + "m" + " is " + (int) fToM + "f");
		} else
			if (aLine.equals("f")) {
			System.out.println(length + "f" + " is " + (int) mToF + "m" );
		} 

	}

}
