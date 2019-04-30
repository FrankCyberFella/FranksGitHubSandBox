package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double givenLength=0;
		String givenUnit="";
		String userString="";
		System.out.print("Please enter the length: ");
		userString=keyboard.nextLine();
		givenLength=Double.parseDouble(userString);
		System.out.print("Is the measurement in (m)eter or (f)eet?: ");
		userString=keyboard.nextLine();
		if(userString.equals("F")||userString.contentEquals("f")) {
			//System.out.print(givenLength+" feet is " +(givenLength*.3048)+" meters.");
			System.out.printf("%.2f feet is %.2f meters.", givenLength, givenLength*.3048);
			
		}
		if(userString.equals("M")||userString.contentEquals("m")) {
			//System.out.print(givenLength+" meters is " +(givenLength*3.2808399)+" feet.");
			System.out.printf("%.2f meters is %.2f feet.", givenLength, givenLength*3.2808399);
		}
	}

}
