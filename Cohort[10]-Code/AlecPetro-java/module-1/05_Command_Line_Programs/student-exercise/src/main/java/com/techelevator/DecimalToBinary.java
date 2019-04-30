package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		String decimalValuesEntered = "";
		
		System.out.print("Please enter in a series of decimal values (seperated by spaces): ");
		decimalValuesEntered = keyBoard.nextLine();
		String[] newArgs = decimalValuesEntered.split(" ");
		int[] argsInt = new int[newArgs.length];

		
		for(int i = 0; i < newArgs.length; i++) {
			argsInt[i] = Integer.parseInt(newArgs[i]);
		System.out.println(" ");
		System.out.print(argsInt[i] + " in binary is " + Integer.toBinaryString(argsInt[i]));
		}
		
		
	}

}
/*
String[] newArgs = decimalValuesEntered.split(" ");
int[] argsInt = new int[newArgs.length];


for(int i = 0; i < newArgs.length; i++) {
	argsInt[i] = Integer.parseInt(newArgs[i]);
System.out.println("  ");
System.out.print(argsInt[i] + " in binary is " + Integer.toBinaryString(argsInt[i]));
}
*/