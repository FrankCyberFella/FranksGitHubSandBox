package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		System.out.println("Creating file...");
		System.out.println();
		File fizzFile = new File("fizzBuzz.txt");
		
			fizzFile.createNewFile();
		
			System.out.println("Writing to file...");
			System.out.println();
		try (PrintWriter writer = new PrintWriter(fizzFile)) {
			for (int i = 1; i < 301; i++) {

				if (i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (i % 3 == 0) {
					writer.println("Fizz");
				} else if (i % 5 == 0) {
					writer.println("Buzz");
				} else
					writer.println(Integer.toString(i));
			}
		}
		System.out.println("Finished!");
	}
}

