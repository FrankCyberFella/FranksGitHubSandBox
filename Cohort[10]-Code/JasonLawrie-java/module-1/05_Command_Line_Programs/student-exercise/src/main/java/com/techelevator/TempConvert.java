package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double givenTemp=0;
		String givenUnit="";
		String userString="";
		System.out.print("Please enter the temperature: ");
		userString=keyboard.nextLine();
		givenTemp=Double.parseDouble(userString);
		System.out.print("Is the temperature in (C)elsius or (F)ahrenheit?: ");
		userString=keyboard.nextLine();
		if(userString.equals("F")||userString.contentEquals("f")) {
			//System.out.print(givenTemp+" Fahrenheit is " +((givenTemp-32)/1.8)+" Celsius.");
			System.out.printf("%.0f degrees Fahrenheit is %.0f degrees Celsius", givenTemp, (givenTemp-32)/1.8);
		}
		if(userString.equals("C")||userString.contentEquals("c")) {
			//System.out.print(givenTemp+" Celsius is " +(givenTemp*1.8+32)+" Fahrenheit.");
			System.out.printf("%.0f degrees Celsius is %.0f degrees Fahrenheit", givenTemp, givenTemp*1.8+32);
		}
	}

}
