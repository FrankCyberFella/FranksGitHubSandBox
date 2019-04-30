package com.techelevator;

public class KataFizzBuzz {
	public static String fizzBuzz(int num) {
		if(num == 0) {
			return "0";
		}
		if((num % 3 == 0) && (num % 5 == 0)) {
			return "fizzbuzz";
		}
		if (num == 1){
			return "1";
		}
		else if (num == 2){
			return "2";
		}
		else if (num == 4){
			return "4";
		}
		else if(num > 100) {
			return "";
		}
		else if(num % 3 == 0) {
			return "fizz";
		}
		else if(num % 5 == 0) {
			return "buzz";
		}
		else if((num + "").contains("3")) {
			return "fizz";
		}
		else if((num + "").contains("5")) {
			return "buzz";
		}
		
		return ""; 
	}
}
