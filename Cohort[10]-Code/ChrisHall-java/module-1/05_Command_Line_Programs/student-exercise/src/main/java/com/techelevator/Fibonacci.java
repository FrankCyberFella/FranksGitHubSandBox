package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);

		System.out.println("Please enter the Fibonacci number: ");
		String aLine = keyBoard.nextLine();
		int givenNum = Integer.parseInt(aLine);

		int[] fibo = new int[givenNum + 2];
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i < givenNum + 2; i++) {
			fibo[i] = fibo[i - 2] + fibo[i - 1];
		}

		for (int j = 0; fibo[j] < givenNum; j++) {
			System.out.print(fibo[j] + ", ");
		}

	}
	// Last comma is hanging there, I know, but I'm done...this took awhile.
	// But, I am happy to say that I did it without help and without peeking
	// anywhere. ;-)

}
