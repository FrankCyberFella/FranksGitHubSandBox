package com.techelevator;

import java.util.Scanner;

/*  This is a work in progress.  I wanted to first try and get a for loop to give the conversion to 
 * binary.  It does, but backwards.  I had planned to figure out how to then load the output 
 * from the for loop into an array and reorder, and then add the appropriate strings in the 
 * printed output.  But I appear to have run out of time.  This was my own creation.  Below this 
 * is another program written with help from the net.
 */

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);

		System.out.println("Please enter a decimal value: ");
		String aLine = keyBoard.nextLine();
		int decimal = Integer.parseInt(aLine);

		for (int i = decimal; i >= 1; i /= 2) {
			if (i % 2 == 0) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
		}

	}
}


/*   Note: After writing the above, below is another attempt that I made but with hints gathered from the internet, just to 
 * learn from the internet.  --I don't know why the formatting gets weird when I comment it out--
 * Anyway, this one creates the binary number in the reverse order too!  
 
 
	public static void main(String[] args) { int remainder; String binary = "";
  
 * Scanner keyBoard = new Scanner(System.in);
 * System.out.println("Please enter a decimal value: "); String aLine =
 * keyBoard.nextLine(); int decimal = Integer.parseInt(aLine); int workingDec =
 * decimal;
 * 
 * while (workingDec > 0) { remainder = workingDec % 2; binary = binary +
 * remainder; workingDec = workingDec / 2; } System.out.println(decimal +
 * " in binary is " + binary);
 * 
 * }
}
*/