package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner keys = new Scanner(System.in);
		
		int temperature;
		int conversion;
		String line = "";
		
		System.out.println("Please enter the temperature: ");
		line = keys.nextLine();
		temperature = Integer.parseInt(line);
		
		System.out.println("Is the temperature in (C)elsius or (F)ahrenheit?");
		line = keys.nextLine();
		if(line.equalsIgnoreCase("C")) {
			conversion = (int)((temperature*1.8)+32);
			System.out.println(temperature + "C is " + conversion + "F");
		}
		if(line.equalsIgnoreCase("F")) {
			conversion = (int)((temperature-32)/1.8);
			System.out.println(temperature + "F is " + conversion + "C");
		}
		

	}

}
