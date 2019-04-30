package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		String lengthVal = "";
		String mOrF = "";
	    double lengthFeet = 0;
	    double lengthMeter = 0;
		Scanner keyBoard = new Scanner(System.in);
		
		System.out.print("Please enter the length: ");
		lengthVal = keyBoard.nextLine();
		System.out.print("Is the measurement in (m)eter or (f)eet? ");
		mOrF = keyBoard.nextLine();
		
		if (mOrF.contentEquals("f")) {
			lengthFeet = Double.parseDouble(lengthVal);
			lengthMeter = lengthFeet * 0.3048;
			System.out.println(lengthFeet + "f is " + lengthMeter + "m.");
		} else {
			lengthMeter = Double.parseDouble(lengthVal);
			lengthFeet = lengthMeter * 3.2808399;
			System.out.println(lengthMeter + "m is " + lengthFeet + "f.");
		}

		
		
	}

}
