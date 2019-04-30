package com.techelevator;

public class KataFizzBuzz {
	private int numbers;
	
//Constructor
	public KataFizzBuzz(int numbers) {
		this.numbers = numbers;
	}
	
//Method
	public String fizzBuzz(int number) {
		
		if(number <= 0 || number >= 101) {
			return "";
		}
		else {
		if(number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz?";
		}
		else {
			
		if(number % 5 == 0 || Integer.toString(number).contains("5")) {
			return "Buzz";
		}
		else {
			
			if(number % 3 == 0 || Integer.toString(number).contains("3")) {
			return "Fizz";
		}
		else {
			
		if(number >= 1 && number <= 100) {
			return String.valueOf(number);
		}
		
		return "";
		}
		}
		}	
		}
		}
}
