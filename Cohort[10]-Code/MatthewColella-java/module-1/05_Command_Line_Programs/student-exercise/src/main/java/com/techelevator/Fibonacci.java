package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		String num = "";
		int fn1 = 0;
		int fn2 = 1;
		int length = 5;
		int fib = 0;
		int[] seq = new int[length];
		
		
		Scanner keyBoard = new Scanner(System.in);
		
		System.out.print("Please enter a Fibonacci number: ");
		
		num = keyBoard.nextLine();
		
		int realNum = Integer.parseInt(num);
		
		
		System.out.print(fn1 + " ");
		for(int i = 0; i < 25; i++) {
			
			System.out.print(fn2 + " ");
				fib = fn1 + fn2;
					fn1 = fn2;
					fn2 = fib;
					
					
			}
		}

	}


