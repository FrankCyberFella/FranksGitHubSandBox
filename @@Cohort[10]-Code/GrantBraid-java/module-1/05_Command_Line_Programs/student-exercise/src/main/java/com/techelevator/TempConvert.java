package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);
		
		double tc = 0;
		double tf = 0;
		String temp = "";
		String value = "";
		
		System.out.print("Please enter the temperature: ");
		value = keyBoard.nextLine();
		tc = Double.parseDouble(value);
		System.out.print("Is the temperature in (C)elcius or (F)ahrenheit? ");
		value = keyBoard.nextLine();
		temp = value;
		
		if (temp.contentEquals("C")) {
			tf = tc * 1.8 + 32;
			System.out.println(tc + "C is " + tf + "F.");
		} else {
		    tf = tc;
		    tc = (tf - 32) / 1.8;
		    System.out.println(tf + "F is " + tc + "C.");
		}
		
	}

}
