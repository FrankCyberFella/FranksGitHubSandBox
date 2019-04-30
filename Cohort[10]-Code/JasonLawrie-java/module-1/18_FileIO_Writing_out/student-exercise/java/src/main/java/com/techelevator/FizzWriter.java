package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {
		String writeString = "";
		File writeFile=new File("FizzBuzz.txt");
		try (PrintWriter writer = new PrintWriter(writeFile)){
			System.out.println("Starting to write Fizzes and Buzzes");
			for(int i=1;i<=300;i++) {
				if(i%3==0&&i%5==0||(i+"").contains("3")&&(i+"").contains("5")||i%3==0&&(i+"").contains("5")||i%5==0&&(i+"").contains("3")) {
					writeString="FizzBuzz";
				} else if(i%3==0||(i+"").contains("3")) {
					writeString="Fizz";
				} else if(i%5==0||(i+"").contains("5")){
					writeString="Buzz";
				} else {
					writeString=i+"";
				}
				writer.println(writeString);
			}
			System.out.println("Printed More Fizzes than Buzzes");
		} catch(FileNotFoundException e){
			System.out.println("Unable to write to file");
		}
		
	}

}
