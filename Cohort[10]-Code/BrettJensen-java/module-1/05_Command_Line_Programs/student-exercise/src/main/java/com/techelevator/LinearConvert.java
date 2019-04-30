package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

Scanner keyboard = new Scanner(System.in);
		
		double distanceIn = 0;
		double distanceOut = 0;
		String distanceTypeIn = "";
		String distanceTypeOut = "";
		
		System.out.println("Please enter a distance: ");
		distanceIn = Integer.parseInt(keyboard.nextLine());

		
		System.out.println("Is the distance in (M)eters, or (F)eet?: ");
		distanceTypeIn = keyboard.nextLine();

		
		if(distanceTypeIn.equals("m")) {
			distanceOut = distanceIn * 3.2808399;
			distanceTypeOut = "F";
			distanceTypeIn = "M";
		}
		if(distanceTypeIn.equals("f")) {
			distanceOut = distanceIn * 0.3048;
			distanceTypeOut = "M";
			distanceTypeIn = "F";
		}
		
		System.out.println(distanceIn + distanceTypeIn + " is " + distanceOut + distanceTypeOut);
		
	}

}
