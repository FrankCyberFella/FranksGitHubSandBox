package com.techelevator;

public class KataFizzBuzz { 
	
	public String fizzBuzz(int number) {
		
		String result = "";
		String numString = Integer.toString(number);
		for(int i=0; i<numString.length(); i++) {
			if (numString.substring(i,i+1).equals("3")) {
				result = "Fizz" + result;
			}
			if (numString.substring(i,i+1).equals("5")) {
				result = result + "Buzz";
			}
		}
		if(number%3==0) {
			if(!result.equals("Fizz") && !result.equals("FizzBuzz")) {
			result = "Fizz" + result;
			}
		}
		if(number%5==0) {
			if(!result.equals("Buzz") && !result.equals("FizzBuzz"))
			result = result + "Buzz";
		}
		
		if (number%3!=0 && number%5!=0){
			if(!result.equals("Fizz") && !result.equals("Buzz") && !result.equals("FizzBuzz")) {
			result = Integer.toString(number);
			}
			}
		
		if(number<1 || number >100) {
			result = "";
		}

		return result;
	}
}
