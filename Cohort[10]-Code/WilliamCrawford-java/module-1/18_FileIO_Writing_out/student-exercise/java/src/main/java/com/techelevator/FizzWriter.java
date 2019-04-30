package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException{
		
		File newFile = new File("FizzBuzz.txt");
		newFile.createNewFile();
		String[]result = new String[300];
		
		for(int i = 1; i <= 300; i++) {
			result [i-1] = toFizzBuzz(i);
		}
		
		try(PrintWriter writer = new PrintWriter(newFile)) {
			for(String ans : result ) {
				writer.println(ans);	
			}
		}
				
	}
	
			
	
	
	
	
	
	public static String toFizzBuzz(int num) {
				if(num < 1 && num > 100) {
					return "";
				}
				if (num % 3 ==0 && num % 5 == 0) {
					return "FizzBuzz";
				}
				if (num % 3 == 0) {
					return "Fizz";
				}
				if (num % 5 == 0) {
					return "Buzz";
				}
				return Integer.toString(num);
				
			}
}
