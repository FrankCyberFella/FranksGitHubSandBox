package com.techelevator;

public class KataStringCalculator {

	public int add(String numbers) {

		//String numbersNoDelimiters = [delimeters]numbers;
		int sum = 0;
		String[] numsWithCommas = numbers.split("[,\n]");
		for (String numerals : (numsWithCommas)) {
			sum = sum + Integer.parseInt(numerals);
		}

		if(numbers.length() == 1) {
			sum = Integer.parseInt(numbers);
		}
		return sum;

	}
}