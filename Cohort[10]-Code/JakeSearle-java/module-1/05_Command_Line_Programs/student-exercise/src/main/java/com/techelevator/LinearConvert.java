// foot to meter:  m = f * 0.3048
// meter to foot: f = m * 3.2808399
// prompt User to enter a length and whether the measurement is in (m)eters or (f)eet. 
// Convert length to opposite measurement, and display old and new measurements.
package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		double feetLength = 0.0;
		double meterLength = 0.0;
		double thirdNum = 0.0;
		
		String lengthLine = "";
		String otherLine = "";
		String feetLine = "F"; 
		String metersLine = "M";
		
		System.out.println("Please enter your length");
		
		lengthLine = keyBoard.nextLine();
		thirdNum = Double.parseDouble(lengthLine); 
		
		System.out.println("Is your length in feet (F) or meters (M)?");
		
		otherLine = keyBoard.nextLine(); 
		
		if (otherLine.equals("F")) {
			System.out.println("Your length in meters is: " + thirdNum * 0.3048);
		}
		
			feetLength = Double.parseDouble(lengthLine);
			
		if (otherLine.equals("M")) {
			System.out.println("Your length in feet is: " + thirdNum * 3.2808399);
		}
		
			meterLength = Double.parseDouble(lengthLine);
		
 
	}  

}
