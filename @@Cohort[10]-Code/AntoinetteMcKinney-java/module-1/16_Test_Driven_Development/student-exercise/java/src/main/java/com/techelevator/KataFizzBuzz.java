package com.techelevator;

public class KataFizzBuzz {

	public String fizzBuzz(int nums) {
		if ((nums % 3 == 0) && (nums % 5 == 0)) {
			return "FizzBuzz?";
		} else if (nums % 3 == 0) {
			return "Fizz";
		} else if (nums % 5 == 0) {
			return "Buzz";

		} else if (nums >= 1 && nums <= 100) {
			return Integer.toString(nums);// the toString method converts string to ints since they are differen data
											// types

		} else {
			return "";
		}

	}
}
