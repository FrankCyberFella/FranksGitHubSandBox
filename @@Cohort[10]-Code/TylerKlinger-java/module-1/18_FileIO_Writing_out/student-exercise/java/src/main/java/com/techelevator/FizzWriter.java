package com.techelevator;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FizzWriter {

	
	public static void main(String[] args) throws IOException {
		
		//initialize a Scanner -- no file to scan or input needed
		
		// run a loop on all numbers 1-300 using fizzWriter();
		//write out output to a new file and increment variable int in FizzBuzz + toString(int)
			//initialize a PrintWriter
		System.out.println("FizzWriter Initializing");
		String result = "";
		for(int i = 1; i <= 300; i++) {
			result += fizzWriter(i) + " ";
		}
		File newFile = new File("FizzBuzz.txt");
		
		newFile.createNewFile();
		try (PrintWriter writer = new PrintWriter(newFile)) {
			writer.println(result);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("FizzWriter Complete");
	}//end of main string args
	
	public static String fizzWriter(int number) {
		//result.valueOf(number);
		//return result
		
		String numberAsString = new Integer(number).toString();
		
		if(number >= 1 && number <= 300) {
			if(number % 3 == 0 && number % 5 == 0) {
				return "FizzBuzz";
			}
			else {
				if(number % 3 == 0) {
					return "Fizz";
			}
				if(number % 5 == 0) {
					return "Buzz";
				}
				else {
					if(numberAsString.contains("3")) {
						return "Fizz";
					}
					if(numberAsString.contains("5")) {
						return "Buzz";
					}
					return numberAsString;
				}
			}
		}
		return "";
	}
	
	

	}


