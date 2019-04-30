package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner keys = new Scanner(System.in);
		
		int length;
		int conversion;
		String line = "";
		
		System.out.println("Please enter the length: ");
		line = keys.nextLine();
		length = Integer.parseInt(line);
		
		System.out.println("Is the measurement in (m)eters or (f)eet?");
		line = keys.nextLine();
		if(line.equalsIgnoreCase("m")) {
			conversion = (int)(length*3.2808399);
			System.out.println(length + "m is " + conversion + "f");
		}
		if(line.equalsIgnoreCase("f")) {
			conversion = (int)(length*.3048);
			System.out.println(length + "f is " + conversion + "m");
		}

	}

}
