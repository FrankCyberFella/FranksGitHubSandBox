package com.techelevator;

public class KataStringCalculator {

	public KataStringCalculator() {

	}

	int add(String numbers) {
		 if (numbers.length() >= 1) {
			String[] numArray = numbers.split(",|\n");
			int result = 0;
			for (String num : numArray) {
				result += Integer.parseInt(num);
			}
			return result;

		}

		return 0;
	}
}
