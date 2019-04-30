package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		String decimalValue = "";
		String binary = "";
		int decimal = 0;

		
		System.out.print("Please enter decimal values: ");
		decimalValue = keyBoard.nextLine();
		String[] multipleValues = decimalValue.split(" ");
		
		for(int i = 0; i < multipleValues.length ; i++) {
			binary = "";

			decimal = Integer.parseInt(multipleValues[i]);
			
			for(int j = 0; decimal >= 0 ; j++) {
				if (j == 0 && decimal == 0) {
					binary = "0";
				}
				if (decimal == 0) {
					break;
				}
				if (decimal % 2 == 1) {
					binary = "1" + binary;
				} else {
					binary = "0" + binary;
				}
				decimal /= 2;
			}
			System.out.print(multipleValues[i] + " in binary is " + binary + "\n");
		}


	}
	

}
