package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KataFizzBuzz {

	public KataFizzBuzz() {
		
	}
	
	public String fizzBuzz(int num) {
		int max = 100;
		String result = "";
		Map<Integer, String> intAsString = new HashMap<Integer, String>();
		int[] intArray = new int[max];
		for(int i = 0; i < max; i++) {
			intArray[i] = (i+1);
		}
		for(int number : intArray) {
			String s;
			if(isFizz(number) && !isBuzz(number)) {
				s = "Fizz";
			} else 
				if(isBuzz(number) && !isFizz(number)) {
				s = "Buzz";
			} else 
				if(isBuzz(number) && isFizz(number)) {
				s = "FizzBuzz";
			} else {
				s = Integer.toString(number);
			}
			intAsString.put(number, s);
			}
		
		if(num > 0 && num < 101) {
			result = intAsString.get(num);
		}
		return result;
	}
	
	public boolean isFizz(int num) {
		if(num % 3 == 0 || String.valueOf(num).contains("3")) {
		return true;
		}
		return false;
	}
	
	public boolean isBuzz(int num) {
		if(num % 5 == 0 || String.valueOf(num).contains("5")) {
			return true;
			}
			return false;
	}
}
