package com.GraphingCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionConverterTest {

	public FunctionConverterTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a function containing x for variable: ");
		String test = keyboard.nextLine();
		test = test.toLowerCase();
		boolean containsNotX = true;
		int count = 25;
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "y", "z" };

		while (containsNotX) { // nested while loop to determine if there is a variable besides x in provided
								// function
			count = 25;
			for (String letter : alphabet) {
				if (test.contains(letter)) {
					if (count != 25) {
						continue;
					}
					count--;
					containsNotX = true;
					System.out.println("You did not use only the variable x for function");
					System.out.print("Try Again: ");
					continue;
				}

			}

			if (count == 25) {
				break;
			}
			test = keyboard.nextLine();
			test = test.toLowerCase();
		}

		String holder = "";
		test = test.replaceAll(" ", "");
		List<String> testArray = new ArrayList<String>();
		List<String> testArray2 = new ArrayList<String>();
		// System.out.println(test);
		boolean containsPlus = true;
		boolean containsMinus = true;
		int indexOfPlus = -1;
		int indexOfMinus = -1;

		while (true) {
			indexOfPlus = test.indexOf("+");
			indexOfMinus = test.indexOf("-");

			if (indexOfPlus < 0 && indexOfMinus < 0) {
				break;
			}
			if (indexOfPlus == -1) {
				containsPlus = false;
			}
			if (indexOfMinus == -1) {
				containsMinus = false;
			}
			if (indexOfPlus >= 0 && !containsMinus) { // checking that we still have plus to pares if our indexOfMinus
														// is -1
				testArray.add(test.substring(0, indexOfPlus));
				testArray.add(test.substring(indexOfPlus, indexOfPlus + 1));
				test = test.substring(indexOfPlus + 1);
			}
			if (indexOfMinus >= 0 && !containsPlus) { // checking that we still have minus to parse if our indexOfPlus
														// is -1
				testArray.add(test.substring(0, indexOfMinus));
				testArray.add(test.substring(indexOfMinus, indexOfMinus + 1));
				test = test.substring(indexOfMinus + 1);
			}

			if (indexOfPlus < indexOfMinus && indexOfPlus >= 0) { // checking that we still have a plus to parse
				testArray.add(test.substring(0, indexOfPlus));
				testArray.add(test.substring(indexOfPlus, indexOfPlus + 1));
				test = test.substring(indexOfPlus + 1);
			} else if (indexOfMinus < indexOfPlus && indexOfMinus >= 0) { // checking that we still have a minus to
																			// parse and it comes b4 plus
				testArray.add(test.substring(0, indexOfMinus));
				testArray.add(test.substring(indexOfMinus, indexOfMinus + 1));
				test = test.substring(indexOfMinus + 1);
			}
		}
		testArray.add(test);

		for (String arraySpot : testArray) {
			if (arraySpot.contains("\\Dx")) { // need to figure out how to do the 2x into 2*x stuff
				arraySpot = arraySpot.replaceAll("\\Dx", "xx");
				System.out.println(arraySpot);

			}

			if (arraySpot.contains("^")) { // Convert the caret symbol into the proper Math.pow sequence
				arraySpot = arraySpot + "     "; // added this to ensure the string is not out of range when converting
				arraySpot = arraySpot.replaceAll("\\^", "Math.pow(" + (arraySpot.charAt(arraySpot.indexOf("^") - 1))
						+ "," + (arraySpot.charAt(arraySpot.indexOf("^") + 1)) + ")"); // adding in Math.pow
				arraySpot = arraySpot.substring(0, arraySpot.indexOf("M") - 1)
						+ arraySpot.substring(arraySpot.indexOf("M"), arraySpot.indexOf("w") + 6)
						+ arraySpot.substring(arraySpot.indexOf("w") + 7);// getting rid of the two characters that were
																			// used with the caret
				arraySpot = arraySpot.replaceAll(" ", ""); // getting rid of additional spaces added
			}
			testArray2.add(arraySpot);
		}

		String result2 = String.join("", testArray2);
		System.out.println("Here is your function as the proper string");
		System.out.println(result2);
	}
}

//Scanner keyboard = new Scanner(System.in);
//System.out.print("Enter a function containing x for variable: ");
//String test = keyboard.nextLine();

/*
 * String holder = ""; test = test.replaceAll(" ", ""); List<String> testArray =
 * new ArrayList<String>(); List<String> testArray2 = new ArrayList<String>();
 * //System.out.println(test); boolean containsPlus = true; boolean
 * containsMinus = true; int indexOfPlus = -1; int indexOfMinus = -1;
 * 
 * while (true) { indexOfPlus = test.indexOf("+"); indexOfMinus =
 * test.indexOf("-");
 * 
 * if (indexOfPlus < 0 && indexOfMinus < 0) { break; } if (indexOfPlus == -1) {
 * containsPlus = false; } if (indexOfMinus == -1) { containsMinus = false; } if
 * (indexOfPlus >= 0 && !containsMinus) { // checking that we still have plus to
 * pares if our indexOfMinus is -1 testArray.add(test.substring(0,indexOfPlus));
 * testArray.add(test.substring(indexOfPlus,indexOfPlus + 1)); test =
 * test.substring(indexOfPlus + 1); } if (indexOfMinus >= 0 && !containsPlus) {
 * // checking that we still have minus to parse if our indexOfPlus is -1
 * testArray.add(test.substring(0,indexOfMinus));
 * testArray.add(test.substring(indexOfMinus,indexOfMinus + 1)); test =
 * test.substring(indexOfMinus + 1); }
 * 
 * if (indexOfPlus < indexOfMinus && indexOfPlus >= 0) { // checking that we
 * still have a plus to parse testArray.add(test.substring(0,indexOfPlus));
 * testArray.add(test.substring(indexOfPlus,indexOfPlus + 1)); test =
 * test.substring(indexOfPlus + 1); } else if (indexOfMinus < indexOfPlus &&
 * indexOfMinus >= 0){ // checking that we still have a minus to parse and it
 * comes b4 plus testArray.add(test.substring(0,indexOfMinus));
 * testArray.add(test.substring(indexOfMinus,indexOfMinus + 1)); test =
 * test.substring(indexOfMinus + 1); } } testArray.add(test);
 * 
 * for (String arraySpot: testArray) { if (arraySpot.contains("x")) { // need to
 * figure out how to do the 2x into 2*x stuff int indexOf = 0;
 * 
 * }
 * 
 * if (arraySpot.contains("^")) { // Convert the caret symbol into the proper
 * Math.pow sequence arraySpot = arraySpot + "     "; // added this to ensure
 * the string is not out of range when converting arraySpot =
 * arraySpot.replaceAll("\\^","Math.pow(" +
 * (arraySpot.charAt(arraySpot.indexOf("^") - 1)) + "," +
 * (arraySpot.charAt(arraySpot.indexOf("^") + 1)) + ")"); // adding in Math.pow
 * arraySpot = arraySpot.substring(0,arraySpot.indexOf("M")-1) +
 * arraySpot.substring(arraySpot.indexOf("M"), arraySpot.indexOf("w") + 6) +
 * arraySpot.substring(arraySpot.indexOf("w") + 7);// getting rid of the two
 * characters that were used with the caret arraySpot =
 * arraySpot.replaceAll(" ",""); // getting rid of additional spaces added }
 * testArray2.add(arraySpot); } //System.out.println(testArray);
 * //System.out.println(testArray2); String result2 = String.join("",
 * testArray2);
 * 
 * 
 * return result2;
 */
