package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {
	
	
	public static String fizzBuzz(int number) {
	if(number == 0) {
		return "";
	}
	String fizzBuzz = "";
	int fizz = 0;
	int buzz = 0;
	String[] numToSplitStr = Integer.toString(number).split("");
	if(number % 3 == 0 && number % 5 == 0) {
		return "FizzBuzz";
	}
	for(int i = 0; i <numToSplitStr.length; i++) {
		if(numToSplitStr[i].equals("3")) {
			fizz ++;
		} else{
			if(numToSplitStr[i].equals("5")) {
				buzz ++;
			}
		} 
	}
	if(fizz > 0) {
		fizzBuzz += "Fizz";
	} 
	if(buzz > 0) {
		fizzBuzz += "Buzz";
		} 
	if(fizzBuzz.length() > 0) {
		return fizzBuzz;
	}
	

	if(number % 3 == 0) {
		return "Fizz";
	} else {
		if(number % 5 == 0) {
			return "Buzz";
		}else {
			if(number > 0 && number <= 300) {
				return Integer.toString(number);
			}
		}
	}
	
	return "";
}


	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a name for the new file >>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(fileName);
		
		
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(PrintWriter writer = new PrintWriter(newFile)) { //instead of scanner, we use the class PrintWriter
			for(int i = 1; i <= 300; i++) {
				writer.println(i + " " + fizzBuzz(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
