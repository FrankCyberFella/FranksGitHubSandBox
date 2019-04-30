package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		
		int decNumber = 0;
		int binNum = 0;
		
		String decLine = "";
		String binLine = ""; 
		
		System.out.println("Please enter your number:"); 
		
		decLine = keyBoard.nextLine();
		
		decNumber = Integer.parseInt(decLine);
		
		System.out.println("Your number in binary is:"); 
		
		System.out.println();  

	}   

}
