package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {
	
	public static void main(String[] args) {
	
 Scanner keyBoard = new Scanner (System.in);
 
 		String inputNumbers = "";
 		int decimalNumbers = 0;
 		
 		
 		System.out.println("Please enter a series of decimal values seperated by spaces: ");
 		inputNumbers = keyBoard.nextLine();
 		
 		String[] inputNumbersSplit = inputNumbers.split(" ");
 		//int[] binaryString = new int[inputNumbersSplit.length];
 		//decimalNumbers = Integer.parseInt(inputNumbers);
 		
 		for (int i = 0; i < inputNumbersSplit.length; i++) {
 			int decimalValue = Integer.parseInt(inputNumbersSplit[i]);
 			System.out.println(inputNumbersSplit[i] + " in binary is " + Integer.toBinaryString(decimalValue));
 		}
// 		for (int i = 0; i < inputNumbersSplit.length; i++) {
// 		System.out.println(inputNumbers + " in binary is " + Integer.toBinaryString(decimalNumbers));
// 
// 		}
}
}
//works for 1 value
