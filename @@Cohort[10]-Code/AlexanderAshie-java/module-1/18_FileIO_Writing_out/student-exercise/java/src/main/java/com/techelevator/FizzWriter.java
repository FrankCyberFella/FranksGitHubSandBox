package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException {

		System.out.println("Starting write...");
		
		FizzBuzz fizzBuzzCalculator = new FizzBuzz(0);
		
		File fizzBuzzFile = new File("fizz_buzz.txt");
		
		try (PrintWriter writer = new PrintWriter(fizzBuzzFile)) {
			
			for (int i = 1; i < 301; i++) {
				
				writer.println(i + " " + fizzBuzzCalculator.fizzBuzz(i));
				
			}
			
		}
		
	
		System.out.println("Ending write...");
		
	}

}
