package com.techelevator;

import java.util.Scanner;

public class LinearConvert { 
	
	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);//Create a scanner object to read users keyBoard.
		double length = 0;//Declare variables
		String measurement = "";//Declare variables
		
//		double feet = 0;//Declare variables
//		
//		double meter = 0;//Declare variables
		
//		String meter1 = "";//Declare String
//		
//		String opposite = "";//Declare String
	
		System.out.println("Please enter length"); //Prompt user to enter length
		//opposite = keyBoard.nextLine();//saves what the user types in userInp
		length = keyBoard.nextDouble();//Converts user input from a string to a double, then assigns the value to the length variable
		
		System.out.println("Is the measurement in [m]eter or [f]eet?");
		measurement = keyBoard.nextLine();//saves the user input 'm' or 'f' to determine if measurement is feet or meters

		if(measurement.contentEquals("m")) {//if measurement is [m]eters convert to [f]eet
			System.out.println(length + "m is " + (length * 3.2808399) + "f");
		}//You can put else {System.out.println(length + "f is " + ((feet - 32) / 1.8) + "C");} instead of another if...statement
		
		if(measurement.contentEquals("f")) {//if measurement is [f]eet convert to [m]eters
			System.out.println(length + "f is " + (length * 0.3048) + "m");
		}
		//When using a scanner it must be closed 
		keyBoard.close();
	}

}
