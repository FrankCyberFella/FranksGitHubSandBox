package com.techelevator;

public class KataFizzBuzz {

	public String fizzBuzz(int n) {

		if (n > 0 && n < 101) {

			if (n % 3 == 0 && n % 5 == 0) {
				return "FizzBuzz";
			} else {
				if (n % 3 == 0) {
					return "Fizz";
				} else {
					if (n % 5 == 0) {
						return "Buzz";
					}
					
				}

				String strNumber = Integer.toString(n);
				return strNumber;

			}

		}
		return "";

	}
}

