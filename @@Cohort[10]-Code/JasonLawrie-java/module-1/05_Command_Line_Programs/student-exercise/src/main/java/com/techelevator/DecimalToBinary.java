package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		String userInput="";
		String binaryNumber="";
		
		int userInt=0;
		int saveInt=0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a series of decimal value (separated by spaces): ");
		userInput=keyboard.nextLine();
		String[] userInputSplit= userInput.split(" ");
		
		
		for(int i=0; i<userInputSplit.length;i++) {
			userInt=Integer.parseInt(userInputSplit[i]);
			saveInt=userInt;
			while(userInt>=1){
			
				binaryNumber=(userInt%2)+binaryNumber;
				userInt/=2;
			} 
			System.out.print(saveInt+" in binary is: "+binaryNumber);
			System.out.println();
			binaryNumber="";
		}
		
		
		
	}

}
