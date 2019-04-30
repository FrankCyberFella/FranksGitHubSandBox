package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException {

		File fizzBuzzFile = new File("fizzBuzzFile.txt");
		fizzBuzzFile.createNewFile();

		try (PrintWriter painter = new PrintWriter(fizzBuzzFile)) {
			System.out.println("Starting Program");
			for (int number = 1; number < 301; number++) {
				if ((number <= 0 || number >= 301)) {
					painter.println("Out of bounds");
				} else {
					if (number % 5 == 0 && number % 3 == 0) {
						painter.println("FizzBuzz");
					} else {
						if ((number % 3 == 0) || (Integer.toString(number).contains("3"))) {
							painter.println("Fizz");
						} else {
							if ((number % 5 == 0) || (Integer.toString(number).contains("5"))) {
								painter.println("Buzz");
							} else {

								if (number > 0 && number <= 300) {
									painter.println(number);
								}

							}
						}

					}
				}
			}
			System.out.println("Ending Program");
		}
	}
}
