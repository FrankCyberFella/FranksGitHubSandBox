package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner keys = new Scanner(System.in);
		
		String line = "";
		String result = "";
		
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		
		line = keys.nextLine();
		String[] values = line.split(" ");
		int[] input = new int[values.length];
		
		for (int i=0; i<values.length; i++) {
			
		input[i] = Integer.parseInt(values[i]);
		
		while (input[i] > 0) {
			if (input[i]%2==0) {
				result = "0" + result;
				input[i] /= 2;
			}
			if (input[i]%2==1) {
				result = "1" + result;
				input[i] /= 2;
			}
		}
		System.out.println(values[i] + " in binary is " + result);
		result = "";
		}
		}	
}
