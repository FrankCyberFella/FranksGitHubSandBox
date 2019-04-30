package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {
	

	public static void main(String[] args) throws IOException {


	File testFile = new File("fizzbuzz.txt");
	
	testFile.createNewFile();
	
	try(PrintWriter writer = new PrintWriter(testFile)) {
	 
		for(int number = 1; number <= 300; number++) {

		if (number <= 0 || number >= 301) {
			writer.println("Out of bounds");
		} else {
			if (number % 3 == 0 && number % 5 == 0) {
				writer.println("FizzBuzz");
			} else {

				if (number % 5 == 0 || Integer.toString(number).contains("5")) {
					writer.println("Buzz");
				} else {

					if (number % 3 == 0 || Integer.toString(number).contains("3")) {
						writer.println("Fizz");
					} else {

						if (number >= 1 && number <= 300) {
							writer.println(number);
						}
						}

					}
				}
			}
		}
	}
}
}


