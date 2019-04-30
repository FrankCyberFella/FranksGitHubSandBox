package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		double tempInPut = 0;
		
		String tempType = "";
		
		String aLine = "";
		////greet the user and prompt them to enter a start from, end with, and increment value
		System.out.println("Please enter temperature");
		aLine = keyBoard.nextLine();
		tempInPut = Double.parseDouble(aLine);
		
		System.out.println("Is the temperature [C]elsius or [F]ahrenheit?");
		tempType = keyBoard.nextLine();
		
		if (tempType.contentEquals("C")) {
			System.out.println (tempInPut + "C is " + ((tempInPut * 1.8) + 32) + "F");
		}
		
		if (tempType.contentEquals("F")) {
			System.out.println(tempInPut + "F is " + ((tempInPut - 32) / 1.8) + "C");
		} //print out each value converted into temp from start from to end with 
		keyBoard.close();
	}

}
