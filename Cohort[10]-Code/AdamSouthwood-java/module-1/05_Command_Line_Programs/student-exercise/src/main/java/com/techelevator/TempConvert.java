package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		int aNumber = 0;
		String aLine1 = "";
		String aLine2 = "";
		
		
		
		System.out.println("Please enter the temperature:");
		aLine1 = keyboard.nextLine();
		aNumber = Integer.parseInt(aLine1);
		
		System.out.println("Is the temperature in (C)elsius or (F)ahrenheit?");
		aLine2 = keyboard.nextLine();
		
		double tC = (aNumber - 32) / 1.8;
		double tF = (aNumber * 1.8) + 32;
		
		aLine2.equals("F");
		System.out.println(aNumber + "F is " + (int) tC + "C");
	
		aLine2.equals("C");
		System.out.println(aNumber + "C is " + (int) tF + "F");
	}}
