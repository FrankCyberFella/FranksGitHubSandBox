package com.techelevator;

public class KataFizzBuzz {
	
	public String convert(int number) {
		
		if(number > 0 && number < 101) {
		if(number % 5 == 0 && number % 3 == 0 || String.valueOf(number).contains(String.valueOf(5))
				&& String.valueOf(number).contains(String.valueOf(3))) {
			return "FizzBuzz";
		}
		if(number % 5 == 0 || String.valueOf(number).contains(String.valueOf(5))) {
			return "Buzz";
		}
		if(number % 3 == 0 || String.valueOf(number).contains(String.valueOf(3))) {
			return "Fizz";
		}
		else {
			return Integer.toString(number);
		}
		}
		return "";
		
	
	}
}
