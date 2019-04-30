package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Exercises {

	/*
	 * Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 * Given an array of Strings, return an ArrayList containing the same Strings in
	 * the same order array2List( {"Apple", "Orange", "Banana"} ) -> ["Apple",
	 * "Orange", "Banana"] array2List( {"Red", "Orange", "Yellow"} ) -> ["Red",
	 * "Orange", "Yellow"] array2List( {"Left", "Right", "Forward", "Back"} ) ->
	 * ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		List<String> result = new ArrayList<String>();
		for (String listVal : stringArray) {
			result.add(listVal);
		}
		return result;
	}

	/*
	 * Given a list of Strings, return an array containing the same Strings in the
	 * same order list2Array( ["Apple", "Orange", "Banana"] ) -> {"Apple", "Orange",
	 * "Banana"} list2Array( ["Red", "Orange", "Yellow"] ) -> {"Red", "Orange",
	 * "Yellow"} list2Array( ["Left", "Right", "Forward", "Back"] ) -> {"Left",
	 * "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {
		String[] stringArray = new String[stringList.size()];
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = stringList.get(i);
		}
		return stringArray;
	}

	/*
	 * Given an array of Strings, return an ArrayList containing the same Strings in
	 * the same order except for any words that contain exactly 4 characters.
	 * no4LetterWords( {"Train", "Boat", "Car"} ) -> ["Train", "Car"]
	 * no4LetterWords( {"Red", "White", "Blue"} ) -> ["Red", "White"]
	 * no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} ) -> ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		List<String> result = new ArrayList<String>();
		for (String listVal : stringArray) {
			if (listVal.length() != 4) {
				result.add(listVal);
			}

		}
		return result;

	}

	/*
	 * Given a List of Strings, return a new list in reverse order of the original.
	 * One obvious solution is to simply loop through the original list in reverse
	 * order, but see if you can come up with an alternative solution. (Hint: Think
	 * LIFO (i.e. stack)) reverseList( ["purple", "green", "blue", "yellow", "green"
	 * ]) -> ["green", "yellow", "blue", "green", "purple" ] reverseList( ["jingle",
	 * "bells", "jingle", "bells", "jingle", "all", "the", "way"} ) -> ["way",
	 * "the", "all", "jingle", "bells", "jingle", "bells", "jingle"]
	 */
	public List<String> reverseList(List<String> stringList) {
		Stack<String> stacks = new Stack<String>();
		List<String> result = new ArrayList<String>();
		for (String index : stringList) {
			stacks.push(index);
		}
		System.out.println(stacks);
		while (stacks.size() > 0) {
			String popped = stacks.pop();
			result.add(popped);
		}

		return result;
	}

	/*
	 * Given an array of ints, divide each int by 2, and return an ArrayList of
	 * Doubles. arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100,
	 * 48.5] arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22,
	 * 4508.5, 3] arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5,
	 * 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		List<Double> doubles = new ArrayList<Double>();
		for (int i : intArray) {
			double NewDouble = (double) i / 2;
			doubles.add(NewDouble);
		}
		return doubles;
	}

	/*
	 * Given a List of Integers, return the largest value. findLargest( [11, 200,
	 * 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333 findLargest( [987, 1234, 9381,
	 * 731, 43718, 8932] ) -> 43718 findLargest( [34070, 1380, 81238, 7782, 234,
	 * 64362, 627] ) -> 64362
	 */
	public Integer findLargest(List<Integer> integerList) {

		int newHigh = 0;
		for (int i : integerList) {
			if (i >= newHigh) {
				newHigh = i;
			}
		}
		return newHigh;
	}

	/*
	 * Given an array of Integers, return a List of Integers containing just the odd
	 * values. oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83] oddOnly(
	 * {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643] oddOnly( {734,
	 * 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i : integerArray) {
			if (i % 2 == 1) {
				result.add(i);
			}
		}
		return result;
	}

	/*
	 * Given a List of Integers, and an int value, return true if the int value
	 * appears two or more times in the list. foundIntTwice( [5, 7, 9, 5, 11], 5 )
	 * -> true foundIntTwice( [6, 8, 10, 11, 13], 8 -> false foundIntTwice( [9, 23,
	 * 44, 2, 88, 44], 44) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {

		int count = 0;
		for (int i : integerList) {
			if (i == intToFind) {
				count++;
			}
		}
		if (count >= 2) {
			return true;
		}
		return false;
	}

	/*
	 * Given an array of Integers, return a List that contains the same Integers (as
	 * Strings). Except any multiple of 3 should be replaced by the String "Fizz",
	 * any multiple of 5 should be replaced by the String "Buzz", and any multiple
	 * of both 3 and 5 should be replaced by the String "FizzBuzz" INTERVIEW
	 * QUESTION **
	 * 
	 * fizzBuzzList( {1, 2, 3} ) -> [1, 2, "Fizz"] fizzBuzzList( {4, 5, 6} ) -> [4,
	 * "Buzz", 6] fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} ) -> [7, 8,
	 * "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
	 * 
	 * HINT: To convert an integer x to a string you can call x.toString() in your
	 * code (e.g. if x = 1 then x.ToString() equals "1")
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		List<String> fizzBuzz = new ArrayList<String>();
		String iString = "";
		for (int i : integerArray) {
			if (i % 3 == 0 && i % 5 == 0) {
				fizzBuzz.add("FizzBuzz");
			} else if (i % 3 == 0) {
				fizzBuzz.add("Fizz");
			} else if (i % 5 == 0) {
				fizzBuzz.add("Buzz");
			} else {
				Integer iObject = (Integer) i;
				iString = iObject.toString();
				fizzBuzz.add(iString);
			}
		}
		return fizzBuzz;
	}

	/*
	 * Given two lists of Integers, interleave them beginning with the first element
	 * in the first list followed by the first element of the second. Continue
	 * interleaving the elements until all elements have been interwoven. Return the
	 * new list. If the lists are of unequal lengths, simply attach the remaining
	 * elements of the longer list to the new list before returning it.
	 * interleaveLists( [1, 2, 3], [4, 5, 6] ) -> [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		List<Integer> listThree = new ArrayList<Integer>();
//		int smallerLength;
////		int i = 0;
//		
//		// initializes smaller length
//		if (listOne.size() > listTwo.size()) {
//			smallerLength = listTwo.size();
//		}
//		else smallerLength = listOne.size();
//		//initializes smaller length
//		
//		
//		for (i = 0; i < smallerLength; i++) {
//		listThree.add(listOne.get(i));
//		listThree.add(listTwo.get(i));
//	}
//		
//		if (listOne.size() > listTwo.size()) {
//			for (; i < listOne.size(); i++) {
//				listThree.add(listOne.get(i));
//			}
//		}
//		else if (listOne.size() < listTwo.size()) {
//			for (; i < listTwo.size(); i++) {
//				listThree.add(listTwo.get(i));
//			}
//		} return listThree;
//	}
		if (listOne.size() > listTwo.size()) {

			for (int i = 0; i < listTwo.size(); i++) {
				listThree.add(listOne.get(i));
				listThree.add(listTwo.get(i));
			}
			for (int i = listTwo.size(); i < listOne.size(); i++) {
				listThree.add(listOne.get(i));
			}
			return listThree;
		} else if (listTwo.size() > listOne.size()) {

			for (int i = 0; i < listOne.size(); i++) {
				listThree.add(listOne.get(i));
				listThree.add(listTwo.get(i));
			}
			for (int i = listOne.size(); i < listTwo.size(); i++) {
				listThree.add(listTwo.get(i));
			}
			return listThree;
		} else
			for (int i = 0; i < listTwo.size(); i++) {
				listThree.add(listOne.get(i));
				listThree.add(listTwo.get(i));
			}
		return listThree;
	}

	/*
	 * Given a list of Integers representing seat numbers, group them into ranges
	 * 1-10, 11-20, and 21-30. (Any seat number less than 1, or greater than 30 is
	 * invalid, and can be ignored.) Preserve the order in which the seat number
	 * entered their associated group. Return a list of the grouped Integers 1-10,
	 * 11-20, and 21-30. (Hint: Think multiple queues) boardingGate( [1, 13, 43, 22,
	 * 8, 11, 30, 2, 4, 14, 21] ) -> [1, 8, 2, 4, 13, 11, 14, 22, 30, 21]
	 * boardingGate( [29, 19, 9, 21, 11, 1, 0, 25, 15, 5, 31] ) -> [9, 1, 5, 19, 11,
	 * 15, 29, 21, 25] boardingGate( [0, -1, 44, 31, 17, 7, 27, 16, 26, 6] ) -> [7,
	 * 6, 17, 16, 27, 26]
	 */
	public List<Integer> boardingGate(List<Integer> seatNumberList) {
		Queue<Integer> smallNums = new LinkedList<Integer>();
		Queue<Integer> medNums = new LinkedList<Integer>();
		Queue<Integer> bigNums = new LinkedList<Integer>();
		List<Integer> finalList = new ArrayList<Integer>();
	
		for (int i : seatNumberList) {
			if (i <= 10 && i > 0) {
				smallNums.offer(i);
			}

		}
		for (int i : seatNumberList) {
			if (i <= 20 && i > 10) {
				medNums.offer(i);
			}

		}
		for (int i : seatNumberList) {
			if (i <= 30 && i > 20) {
				bigNums.offer(i);
			}

		}
		while (smallNums.size() > 0) {
			int polled = smallNums.poll();
			finalList.add(polled);
		}
		while (medNums.size() > 0) {
			int polled = medNums.poll();
			finalList.add(polled);
		}
		while (bigNums.size() > 0) {
			int polled = bigNums.poll();
			finalList.add(polled);
		}
		
		return finalList;
	}
}
