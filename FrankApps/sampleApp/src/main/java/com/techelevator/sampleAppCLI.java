package com.techelevator;

import java.util.Scanner;

public class sampleAppCLI {
	/*
	 * This class will provide various command line interface (CLI) methods for use in the sampleApp
	 * used in the Intro to Java module
	 */
public String getName() {
	String name ="";
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Please enter a name (First Last):");
	name = keyboard.nextLine();
	return name;
}
public int getWholeNumber(String prompt) {
	int num = 0;
	if (prompt.equals("")){
		prompt = "Please enter a whole number: ";
	}
	Scanner keyboard = new Scanner(System.in);
	System.out.print(prompt + " ");
	num = keyboard.nextInt();
	keyboard.nextLine();
	return num;
}
public double getDecimalNumber(String prompt) {
	double num = 0;
	if (prompt.equals("")){
		prompt = "Please enter a number with decimal places: ";
	}
	Scanner keyboard = new Scanner(System.in);
	System.out.print(prompt + " ");
	num = keyboard.nextDouble();
	keyboard.nextLine();
	return num;
}
}
