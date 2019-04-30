package com.techelevator;

public class KataFizzBuzz {
	
	private int intInput;
	
	public KataFizzBuzz(int intInput) {
		this.intInput = intInput;
	}

	public String fizzBuzz(int intInput) {
		
		if (intInput < 0 || intInput > 100) {
			return "";
		}
		
		if (intInput % 5 == 0 && intInput % 3 == 0) {
			return "FizzBuzz";
		}
		
		if (intInput % 3 == 0) {
			return "Fizz";
		}
		
		if (intInput % 5 == 0) {
			return "Buzz";
		}
		
		if (Integer.toString(intInput).length() == 1) {
			if (Integer.toString(intInput).contains("3")) {
				return "Fizz";
			}
			
			if (Integer.toString(intInput).contains("5")) {
				return "Buzz";
			}
		}
		
		if (Integer.toString(intInput).length() == 2) {
			if (Integer.toString(intInput).substring(0, 1).contains("3")) {
				return "Fizz";
			}
			
			if (Integer.toString(intInput).substring(0, 1).contains("5")) {
				return "Buzz";
			}
		}
		
		
		return Integer.toString(intInput);
	}
	
}
