package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		double lengthInt = 0;
		double otherLengthInt = 0;
		
		Scanner keyBoard = new Scanner(System.in);
	
		System.out.print("Please enter the length: ");
		
			String length = keyBoard.nextLine();
		
		System.out.print("m or f? ");
		
			String mOrf = keyBoard.nextLine();
				if(mOrf.equals("f")) {
				
					lengthInt = Double.parseDouble(length);
		
					otherLengthInt = (lengthInt * 0.3048);
		
		
					System.out.println(length + "f is " + otherLengthInt + "m");
			}
				else if(mOrf.equals("m")){
					
					lengthInt = Double.parseDouble(length);
					
					otherLengthInt = lengthInt * 3.2808399;
		
		
					System.out.println(length + "m is " + otherLengthInt + "f");
			}
			
				else System.out.println("Error");
	}

}
