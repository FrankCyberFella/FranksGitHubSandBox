package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws FileNotFoundException {

		String[] result = new String[300];
		
		for (int i = 1; i <= 300; i++) {
			result[i-1] = toFizzBuzz(i);
		}
		File newFile = new File("FizzBuzz.txt");
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			
		}
		try (PrintWriter writer = new PrintWriter(newFile)){
			for (String ans: result) {
				writer.println(ans);
			}
		}



}
	
	public static String toFizzBuzz(int num) {
		if (num < 0 || num > 300) {
			return "";
		}
		if (num == 0) {
			return "0";
		}

		
	if (num % 3 == 0 && num % 5 == 0) {
			return "FizzBuzz";
		}
	
	if (num % 3 == 0) {
		return "Fizz";
	}
	
	if (num % 5 == 0) {
		return "Buzz";
	}
	
	if ((num + "").contains("3") && (num + "").contains("5")) {
		return "FizzBuzz";
	}
	if ((num + "").contains("3") && !(num+"").contains("5")) {
		return "Fizz";
	}

	if ((num + "").contains("5") && !(num + "").contains("3")) {
		return "Buzz";
	}
	
	return num + "";
		
	}
	}

