package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner keys = new Scanner(System.in);
		
		int num=0;
		int num2=1;
		int num3=0;
		int input;
		String line = "";
		
		System.out.println("Please enter the Fibonacci number: ");
		line = keys.nextLine();
		input = Integer.parseInt(line);
		
		while(num<input) {
			System.out.print(num+", ");
			num = num2;
			num2 = num3+num2;
			num3 = num;
		}
		
		
		

	}

}
