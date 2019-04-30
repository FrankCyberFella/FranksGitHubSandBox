package com.techelevator;

public class KataFizzBuzz {

	private int number;

	public KataFizzBuzz() {
	this.number = number;
	}

	public String fizzBuzz(int number) {

		if ((number > 0 && number <= 100 && number % 5 == 0 && number % 3 == 0)) {
			return "FizzBuzz";
		}
		if ((number > 0 && number <= 100 && number % 3 == 0 && number % 5 != 0)
				|| Integer.toString(number).contains("3")) {
			return "Fizz";
		} else {
			if ((number > 0 && number <= 100 && number % 5 == 0 && number % 3 != 0)
					|| Integer.toString(number).contains("5")) {
				return "Buzz";
			} else {

				if (number > 0 && number <= 100 && number % 3 != 0 && number % 5 != 0) {
					return Integer.toString(number);
				}

				return "";
			}
		}
	}
}
