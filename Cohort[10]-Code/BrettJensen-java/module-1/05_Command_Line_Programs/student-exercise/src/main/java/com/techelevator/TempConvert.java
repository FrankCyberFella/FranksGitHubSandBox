package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		double temperatureIn = 0;
		double temperatureOut = 0;
		String tempTypeIn = "";
		String tempTypeOut = "";
		
		System.out.println("Please enter a temperature: ");
		temperatureIn = Integer.parseInt(keyboard.nextLine());

		
		System.out.println("Is the temperature in (C)elcius, or (F)arenheit?: ");
		tempTypeIn = keyboard.nextLine();

		
		if(tempTypeIn.equals("c")) {
			temperatureOut = temperatureIn * 1.8 + 32;
			tempTypeOut = "F";
			tempTypeIn = "C";
		}
		if(tempTypeIn.equals("f")) {
			temperatureOut = (temperatureIn - 32) / 1.8;
			tempTypeOut = "C";
			tempTypeIn = "F";
		}
		
		System.out.println(temperatureIn + tempTypeIn + " is " + temperatureOut + tempTypeOut);
			
		
	}

}
