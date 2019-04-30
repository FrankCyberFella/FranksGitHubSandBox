package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
//		Scanner keyBoard = new Scanner(System.in);
//		
//		int fibNumber = 0;
//		
//		String holdingValue = "";
//		
//		System.out.print("Please enter the Fibonacci number: ");
//		holdingValue = keyBoard.nextLine();
//		fibNumber = Integer.parseInt(holdingValue);
//		
//		int[] fibSequence = new int[fibNumber];
//		fibSequence[0] = 0;
//		fibSequence[1] = 1;
//		
//		for(int i = 2; i < fibNumber; i++) {
//			fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];	
//		}
//		for(int i = 0; i < fibNumber ; i++) {
//			System.out.print(fibSequence[i] + ", ");
//		}
		
		int fib = 25;
		int[] seq = new int[fib];
		seq[0] = 0;
		seq[1] = 1;
		int holding;
		System.out.println(seq[0]);
		System.out.println(seq[1]);
		for(int i = 2; i < fib ; i++) {
			seq[i] = seq[i-1] + seq[i-2];
		
			System.out.println(seq[i]);
		}
		
		
		
		
		
		
	}

}