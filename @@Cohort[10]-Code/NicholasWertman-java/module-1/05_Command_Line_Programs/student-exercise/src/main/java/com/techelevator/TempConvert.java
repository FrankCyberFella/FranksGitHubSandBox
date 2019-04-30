package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner (System.in);
		
			int tempGiven = 0;
			//double convertToCelsius = ((tempGiven - 32)/ 1.8);
			//double convertToFahren = ((tempGiven * 1.8) + 32);
			String whatTempIsIn = "";
			
			String filler = "";
			
			System.out.println("Please enter the temperature: ");
			filler = keyBoard.nextLine();
			tempGiven = Integer.parseInt(filler);
			
			System.out.println("Is the temperature " + tempGiven + " in (C)elsius or (F)ahrenheit");
			whatTempIsIn = keyBoard.nextLine();
			
			if (whatTempIsIn.equals("C")) { 
				System.out.print(tempGiven + "C is " + ((tempGiven * 1.8) + 32) + "F");
			}
			else {
				System.out.print(tempGiven + "F is " + ((tempGiven - 32)/ 1.8) + "C");
			}
	}

}
