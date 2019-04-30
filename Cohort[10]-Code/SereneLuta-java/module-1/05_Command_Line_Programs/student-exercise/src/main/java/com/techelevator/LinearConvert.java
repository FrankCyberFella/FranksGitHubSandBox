package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
Scanner  keyBoard = new Scanner(System.in);
		
		double lengthInput = 0;
		
		String lengthType = "";
		
		String aLine = "";
		
		System.out.println("Please enter the length");
		aLine = keyBoard.nextLine();
		lengthInput = Double.parseDouble(aLine);
		
		System.out.println("Is the measurement in [m]eters, or [f]eet?");
		lengthType = keyBoard.nextLine();
		
		if (lengthType.equals("m")) {
			System.out.println(lengthInput + "m is " + (lengthInput * 3.2808399) + "f");
		}
	
		if (lengthType.equals("f")) {
			System.out.println(lengthInput + "f is " + ((lengthInput * 0.3048) + "m"));
		}
	}

}

