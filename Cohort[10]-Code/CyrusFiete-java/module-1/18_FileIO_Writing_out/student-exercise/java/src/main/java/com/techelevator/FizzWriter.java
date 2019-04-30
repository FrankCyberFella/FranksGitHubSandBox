package com.techelevator;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter; 

public class FizzWriter {
	
public static String fizzBuzz(int number) {
		
		String result = "";
		String numString = Integer.toString(number);
		for(int i=0; i<numString.length(); i++) {
			if (numString.substring(i,i+1).equals("3")) {
				if(!result.equals("Fizz") && !result.equals("FizzBuzz")) {
					result = "Fizz" + result;
					}
			}
			if (numString.substring(i,i+1).equals("5")) {
				if(!result.equals("Buzz") && !result.equals("FizzBuzz"))
					result = result + "Buzz";
			}
		}
		if(number%3==0) {
			if(!result.equals("Fizz") && !result.equals("FizzBuzz")) {
			result = "Fizz" + result;
			}
		}
		if(number%5==0) {
			if(!result.equals("Buzz") && !result.equals("FizzBuzz"))
			result = result + "Buzz";
		}
		
		if (number%3!=0 && number%5!=0){
			if(!result.equals("Fizz") && !result.equals("Buzz") && !result.equals("FizzBuzz")) {
			result = Integer.toString(number);
			}
			}
		
		if(number<1 || number >300) {
			result = "";
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		
		String[] result = new String[300];
		for(int i=1; i<=300; i++) {
			result[i-1] = fizzBuzz(i);
		}
		
		File fizzBuzz300 = new File("FizzBuzz.txt");
		fizzBuzz300.createNewFile();
		
		try(PrintWriter writer = new PrintWriter(fizzBuzz300)) {
			for(String answer : result) {
			writer.println(answer);
			}
			writer.println("Complete.");
		}
		System.out.println("File writing is complete.");
	}

}
