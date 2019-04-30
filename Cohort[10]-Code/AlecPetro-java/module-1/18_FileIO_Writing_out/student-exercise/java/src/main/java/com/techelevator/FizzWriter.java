package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

		String fileName = "FizzBuzz.txt";
		File newFile = new File(fileName);

		System.out.println("File " + fileName + " created; Application starting..." + "\n");
		int number = 1;
		String.valueOf(number);
		try (PrintWriter writer = new PrintWriter(newFile)){
			
		while(number < 301) {
			if(number % 5 == 0 && number % 3 == 0 || String.valueOf(number).contains(String.valueOf(5)) && String.valueOf(number).contains(String.valueOf(3))) {
				System.out.println("FizzBuzz");
				writer.println("FizzBuzz");
				}
				else if(number % 5 == 0 || String.valueOf(number).contains(String.valueOf(5))) {
					System.out.println("Buzz");
					writer.println("Buzz");
				}
				else if(number % 3 == 0 || String.valueOf(number).contains(String.valueOf(3))) {
					System.out.println("Fizz");
					writer.println("Fizz");
				}
				else {
					System.out.println(number);
					writer.println(number);
				}
			number++;
			
		} 

	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		System.out.println("");
		System.out.println("Application has finished running");
	}
	
}
