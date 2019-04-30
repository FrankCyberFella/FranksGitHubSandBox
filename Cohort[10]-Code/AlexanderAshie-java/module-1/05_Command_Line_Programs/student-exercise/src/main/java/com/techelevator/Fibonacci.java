package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the Fibonacci number: ");
		String tempString = input.nextLine();
		int fibNumber = Integer.parseInt(tempString);
		
		int[] fibArray = new int[fibNumber];
		fibArray[0] = 0;
		fibArray[1] = 1;
		
		for (int i = 2; i < fibArray.length; i++) {
			fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
		}
		
		for (int i = 0; fibArray[i] < fibNumber; i++) {
			System.out.print(fibArray[i] + ", ");
		}

	}

}
