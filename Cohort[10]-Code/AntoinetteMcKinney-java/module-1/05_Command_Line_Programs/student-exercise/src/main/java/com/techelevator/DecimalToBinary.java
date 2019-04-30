package com.techelevator;
 
import java.util.Scanner;//Completed in tutoring 


public class DecimalToBinary {

		public static void main(String[] args ) {//Processing the String Array
			String aLine = "";
			
			Scanner keyBoard = new Scanner(System.in);
			System.out.print("Please enter a series of decimal values (seperated by spaces): ");
			
			String decimals = keyBoard.nextLine();
			String[] decimalsArray = decimals.split(" ");
			
			for(int i = 0; i < decimalsArray.length; i++) {
				int decimal = Integer.parseInt(decimalsArray[i]);
			String binaryOutput =toBinary(decimal);
			System.out.println(decimal + " in binary is " + binaryOutput);
				}
			
			}
			public static String toBinary(int binaryInput) {//Processing the Binary Array
				if (binaryInput == 0) {
					return "0";
				}
				String binaryOutput = "";
				while (binaryInput > 0) {
					int remainder = binaryInput % 2;
					binaryOutput = remainder + binaryOutput;
					binaryInput = binaryInput / 2;
				}
				return binaryOutput;
		
		}

	}


