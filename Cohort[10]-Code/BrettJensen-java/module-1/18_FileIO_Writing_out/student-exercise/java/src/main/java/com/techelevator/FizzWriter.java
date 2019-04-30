package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		String fileName = "fizzBuzz.txt";
		File file = new File(fileName);
			
			file.createNewFile();
			System.out.println();
			System.out.println("name: "+file.getName());
			System.out.println("absolutePath: "+file.getAbsolutePath());
			System.out.println("size : "+file.length());
		
			try(PrintWriter writer = new PrintWriter(file)) {
				System.out.println("Printing to new file...");
				for(int i = 1; i < 301; i++) {			
					String s = "";
					if(isFizz(i) && !isBuzz(i)) {
						s = "Fizz";
					} else 
						if(isBuzz(i) && !isFizz(i)) {
							s = "Buzz";
						} else 
							if(isBuzz(i) && isFizz(i)) {
								s = "FizzBuzz";
							} else {
								s = Integer.toString(i);
							}
					writer.println(i + " = " + s);
				}
				System.out.println("Finished printing to file");
				
			}
			System.out.println("size : "+file.length());
		}
	
	public static boolean isFizz(int num) {
		if(num % 3 == 0 || String.valueOf(num).contains("3")) {
		return true;
		}
		return false;
	}
	
	public  static boolean isBuzz(int num) {
		if(num % 5 == 0 || String.valueOf(num).contains("5")) {
			return true;
			}
			return false;
	}
}
