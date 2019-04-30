package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		double tempInt = 0;
		double otherTempInt = 0;
		
		Scanner keyBoard = new Scanner(System.in);
	
		System.out.print("Please enter the temperature: ");
		
			String Temp = keyBoard.nextLine();
		
		System.out.print("F or C? ");
		
			String fOrC = keyBoard.nextLine();
				if(fOrC.equals("F")) {
				
					tempInt = Double.parseDouble(Temp);
		
					otherTempInt = (tempInt- 32) / 1.8;
		
					int printedTemp = (int)otherTempInt;
		
					System.out.println(Temp + "F is " + printedTemp + "C");
			}
				else if(fOrC.equals("C")){
					
					tempInt = Double.parseDouble(Temp);
					
					otherTempInt = tempInt * 1.8 + 32;
		
					int printedTemp = (int)otherTempInt;
		
					System.out.println(Temp + "C is " + printedTemp + "F");
			}
			
				else System.out.println("Error");
	}

}
