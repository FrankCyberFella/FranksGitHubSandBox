package com.techelevator;

public class KataFizzBuzz {
//
	public static String fizzBuzz(int num) {
		
//	if (num == 1) {
//		return "1";
//	}
//	
//	if (num == 2) {
//		return "2";
//	}
		if (num < 0 || num > 100) {
			return "";
		}
		if (num == 0) {
			return "0";
		}

		
	if (num % 3 == 0 && num % 5 == 0) {
			return "FizzBuzz";
		}
	
	if (num % 3 == 0) {
		return "Fizz";
	}
	
	if (num % 5 == 0) {
		return "Buzz";
	}
	
	if ((num + "").contains("3") && (num + "").contains("5")) {
		return "FizzBuzz";
	}
	if ((num + "").contains("3") && !(num+"").contains("5")) {
		return "Fizz";
	}

	if ((num + "").contains("5") && !(num + "").contains("3")) {
		return "Buzz";
	}
	
	return num + "";
	
	
}
}
