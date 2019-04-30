package com.techelevator;

public class KataFizzBuzz {
	
	public KataFizzBuzz() {}

	public String fizzBuzz(int num) {
		String retString = "";
		
		if(num>0&&num<=100) {
			if(num%3==0&&num%5==0) {
				retString+="FizzBuzz";
			} else if(num%3==0) {
				retString+="Fizz";
			} else if(num%5==0){
				retString+="Buzz";
			} else {
				retString+=num;
			}
			
		}
		return retString;
	}
	
}
