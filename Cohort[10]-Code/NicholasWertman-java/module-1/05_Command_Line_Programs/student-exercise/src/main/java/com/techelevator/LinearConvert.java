package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner (System.in);
		
			String meters = "m";
			String feet = "f";
			double numberGiven = 0;
			String metersOrFeet = "" ;

			
			String calculateConversion = "";
			
			System.out.println("Please enter a number: ");
			calculateConversion = keyBoard.nextLine();
			numberGiven = Integer.parseInt(calculateConversion);
			
			System.out.println("Is the measurement of " + numberGiven + " in, (f)eet or (m)eters?:");
			metersOrFeet = keyBoard.nextLine();
			
			
			
		if (metersOrFeet.equals("m")) { 
			System.out.println(numberGiven + meters + " is " + (numberGiven * 3.280399) + feet); 
	}

		else { System.out.println (numberGiven + feet + " is " + (numberGiven * 0.3408) + meters);
	
		}
	}
}
