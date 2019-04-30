package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Fibonacci values you want generated");
		int numberOfFibonaccis = sc.nextInt();

		System.out.print("0 1 ");

		int fibNum, previous=0, current=1, count=2;
		while(count < numberOfFibonaccis){
			fibNum = previous + current;
			System.out.print(fibNum + " ");
			previous = current;
			current = fibNum;
			count++;
		}
	}
	}
