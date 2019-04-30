package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		String number;
		
Scanner keyBoard = new Scanner(System.in);

System.out.println("Enter a decimal number: ");
String binaryString = keyBoard.nextLine();

System.out.println("Result: "+Integer.parseInt(binaryString,2));
		
		
	}

	}

