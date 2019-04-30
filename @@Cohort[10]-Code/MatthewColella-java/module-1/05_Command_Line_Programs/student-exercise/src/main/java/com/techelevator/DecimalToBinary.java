package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		String decString = "";
		
	Scanner keyBoard = new Scanner(System.in);
	
	System.out.print("Enter a series of decimal numbers separated by spaces: ");
	
	 decString = keyBoard.nextLine();
	 
	 String[] decNums = decString.split(" ");
	 
	 for(int i = 0; i < decNums.length; i++) {
		 int decInt = Integer.parseInt(decNums[i]);
		 String binNum = Integer.toBinaryString(decInt);
		 System.out.println(binNum);
	 	}

	}

}
