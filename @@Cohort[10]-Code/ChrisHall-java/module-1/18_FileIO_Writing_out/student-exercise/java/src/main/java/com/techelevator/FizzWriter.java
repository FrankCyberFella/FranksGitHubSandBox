package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static String fizzBuzz(int n) {

		if (n > 0 && n < 301) {

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

	public static void main(String[] args) throws IOException {
		
		System.out.println("Fizz Buzz 300 has been started. ");
		File fb300 = new File("FizzBuzz.txt");
		fb300.createNewFile();

		String[] fizzArray = new String[300];
		for (int i = 1; i <= 300; i++) {
			fizzArray[i - 1] = fizzBuzz(i);
		}

		try (PrintWriter writer = new PrintWriter(fb300)) {

			for (String each : fizzArray) {

				writer.println(each);
				
			}
			System.out.println("Fizz Buzz 300 has been run. ");
		}
	}
}
// put starting and ending messages to know that program ran
