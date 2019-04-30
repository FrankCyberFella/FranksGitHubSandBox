package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main (String[] args) throws IOException {
		
		System.out.println("Write starting...");
		
		FizzBuzz fizzBuzzFinder = new FizzBuzz(0);
		
		File newFizzBuzz = new File("fizzBuzz.txt");
		
		try (PrintWriter writer = new PrintWriter(newFizzBuzz)) {
			
			for (int i = 1; i < 301; i++) {
				
				writer.println(i + " " + fizzBuzzFinder.fizzBuzz(i));
			}
		} 
		
		System.out.println("Write Ending...");
	}
	
	
	}

	
	



