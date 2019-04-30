package com.techelevator;

import java.util.Arrays;
import java.util.Scanner; 

public class Fibonacci {
	
	public static void fibo() {
		int holder = 0;
		int previous = 0;
		int num = 1;
		for(int i = 0; i < 25; i++) {
				holder = num;
				num = num + previous;
				previous = holder;
				System.out.println(num);
			}
		}
	

	public static void main(String[] args) {
	Scanner keyBoard = new Scanner(System.in);
	
	int startingFiboNum = 1;
	int targetFiboNum;
	int fiboNumCounter = 0;
	
	String fiboLine;
	
	fibo();
	
	System.out.println("Please enter the Fibonacci number:");
	
	fiboLine = keyBoard.nextLine();
	targetFiboNum = Integer.parseInt(fiboLine);
	
	int[] firstFiboSequenceArr = new int[47];
	
	for(int i = 0; i < 47; i++) {
		if(i == 0) {
			firstFiboSequenceArr[i] = i;
			fiboNumCounter ++;
		} else {
			if(startingFiboNum <= targetFiboNum) {
				firstFiboSequenceArr[i] = startingFiboNum;
				startingFiboNum = startingFiboNum + firstFiboSequenceArr[i - 1];
				fiboNumCounter ++;
				}
			} 
		} 
		  int[] finalFiboSequenceArr = new int[fiboNumCounter];
		  for(int i = 0; i < fiboNumCounter; i++) {
			  finalFiboSequenceArr[i] = firstFiboSequenceArr[i];
		 } 
		  
		 System.out.println(Arrays.toString(finalFiboSequenceArr));
	} 
}

/* String fullString = "Joe;Mark;Josh;Craig";
String[] separateNames = fullString.split(";");
// separateNames will contain ["Joe", "Mark", "Josh", "Craig"]
String togetherNames = String.join(",", separateNames);
// togetherNames will equal "Joe,Mark,Josh,Craig" */