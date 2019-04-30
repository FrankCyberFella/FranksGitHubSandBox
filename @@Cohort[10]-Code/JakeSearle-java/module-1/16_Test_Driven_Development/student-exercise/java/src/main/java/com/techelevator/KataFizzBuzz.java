package com.techelevator;

public class KataFizzBuzz {
	private int numbers;
	
	public KataFizzBuzz(int numbers){
		this.numbers = numbers;
	 
	}
	
	
	public String fizzBuzz(int number) {
		if (number <= 0 || number > 100) {
			return "";
		}
		
		if (number % 3 != 0 && number % 5 != 0) {
			return String.valueOf(number);
			
		} 
			
		 
		if (number % 3 == 0 && number % 5 != 0) {
			
			return "Fizz";
		}
		
		if (number % 5 == 0 && number % 3 != 0) {
			
			return "Buzz"; 
		}
		
		if (number % 5 == 0 && number % 3 == 0) {
			
			return "FizzBuzz";
		}
		
		return null;
	}
	
}
	
