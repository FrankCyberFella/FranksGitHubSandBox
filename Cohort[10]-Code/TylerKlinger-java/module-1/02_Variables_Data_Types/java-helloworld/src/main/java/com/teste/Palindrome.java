package com.teste;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("Hello");
		Scanner keyboard = new Scanner(System.in);
		String answer = keyboard.nextLine();
		boolean isPalindrome = true;
		
		for (int i = 0; i < answer.length() / 2; i++) {
			if (answer.charAt(i) != answer.charAt(answer.length()-1-i)) {
				isPalindrome = false;
				
			}
			
		}
		System.out.println(isPalindrome);
	}
	
}
