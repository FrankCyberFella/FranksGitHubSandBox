package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	   public static void main(String[] args) {
		   String aLine = "";
		   
	       Scanner keyBoard = new Scanner(System.in);
	       System.out.print("Please enter a series of decimal values (separated by spaces): ");
	       
	       String decimals = keyBoard.nextLine();
	       String[] decimalsArray = decimals.split(" ");
	       
	       for(int i = 0; i < decimalsArray.length; i++) {
	    	   int decimal = Integer.parseInt(decimalsArray[i]);
	    	   String binaryOuput = toBinary(decimal);
		       System.out.println(decimal + " in binary is " + binaryOuput);
	       }

	   }
	   public static String toBinary(int binaryInput) {
	       if (binaryInput == 0) {
	           return "0";
	       }
	       String binaryOuput = "";
	       while (binaryInput > 0) {
	           int remainder = binaryInput % 2;
	           binaryOuput = remainder + binaryOuput;
	           binaryInput = binaryInput / 2;
	       }
	       return binaryOuput;
	   }
	}