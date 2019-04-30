package com.techelevator;

public class KataFizzBuzz {
	String fizzBuzz(int number) {
		String numString = Integer.toString(number);
		//String [] numArray = numString.split("");
		//-------------------------------------------------------------------------------------------
		//Check if out of range
		//-------------------------------------------------------------------------------------------
		if (number < 1 || number > 100) {
		return "";
		}
		//-------------------------------------------------------------------------------------------
		//Check if contains 3 or 5 digit
		//-------------------------------------------------------------------------------------------
//		if (numArray[0].equals("3")) {
//			return "Fizz";
//		}
//		else if (numArray[0].equals("5")) {
//			return "Buzz";
//		}
		//-------------------------------------------------------------------------------------------
		//Check if divisible
		//-------------------------------------------------------------------------------------------
		
		else if (number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		}
		else if (number % 3 == 0) {
			return "Fizz";
		}
		else if (number % 5 == 0) {
			return "Buzz";
		}
		//-------------------------------------------------------------------------------------------
		//else return the number
		//-------------------------------------------------------------------------------------------
		else return Integer.toString(number);
	}
}
