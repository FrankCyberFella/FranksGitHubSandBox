package com.techelevator;

import java.util.Scanner;

public class LinearConvert {
	
	

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		double lengthInput = 0;
		String lengthType = "";
		String aLine = "";
		
		System.out.println("Enter length");
		aLine = keyBoard.nextLine();
		lengthInput = Double.parseDouble(aLine);
		
		System.out.println("Is the length [M]eters or [F]eet?");
		lengthType = keyBoard.nextLine();
		
		
		if (lengthType.equalsIgnoreCase("M")) {
			System.out.println(lengthInput + "M is " + (lengthInput * 0.3048) + "F");
		}
		if (lengthType.equalsIgnoreCase("F")) {
			System.out.println(lengthInput + "F is " + (lengthInput * 3.2808399) + "M");
		}	
	}
	}


