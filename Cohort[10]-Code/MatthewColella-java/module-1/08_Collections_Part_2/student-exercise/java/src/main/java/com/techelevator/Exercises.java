package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exercises {

	/*
	 * Map Exercises
	 */

	/*
	 * Given the name of an animal, return the name of a group of that animal (e.g.
	 * "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash Giraffe -> Tower Elephant -> Herd Lion -> Pride Crow -> Murder
	 * Pigeon -> Kit Flamingo -> Pat Deer -> Herd Dog -> Pack Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower" animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animals = new HashMap<String, String>();
		animals.put("rhino", "Crash");
		animals.put("giraffe", "Tower");
		animals.put("elephant", "Herd");
		animals.put("lion", "Pride");
		animals.put("crow", "Murder");
		animals.put("pigeon", "Kit");
		animals.put("flamingo", "Pat");
		animals.put("deer", "Herd");
		animals.put("dog", "Pack");
		animals.put("crocodile", "Float");

		if (animals.containsKey(animalName.toLowerCase())) {
			return animals.get(animalName.toLowerCase());
		}

		else
			return "unknown";

	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if
	 * the item is on sale. If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20 "GARAGE1070" -> 0.15 "LIVINGROOM" -> 0.10 "KITCHEN6073"
	 * -> 0.40 "BEDROOM3434" -> 0.60 "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001",
	 * and "KITCHEN4001" should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20 isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15 isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public Double isItOnSale(String itemNumber) {
		Map<String, Double> discounts = new HashMap<String, Double>();
		discounts.put("kitchen4001", 0.20);
		discounts.put("garage1070", 0.15);
		discounts.put("livingroom", 0.10);
		discounts.put("kitchen6073", 0.40);
		discounts.put("bedroom3434", 0.60);
		discounts.put("bath0073", 0.25);

		if (discounts.containsKey(itemNumber.toLowerCase())) {
			return discounts.get(itemNumber.toLowerCase());
		}

		else
			return 0.00;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0 money,
	 * transfer half of it to "Paul", but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100,
	 * ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul":
	 * 1099} robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000,
	 * "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		Integer peterMoney = peterPaul.get("Peter");
		Integer paulMoney = peterPaul.get("Paul");
		Integer half;
		if (peterMoney % 2 == 1) {
			half = (peterMoney / 2) + 1;
			paulMoney = paulMoney - 1;
		} else
			half = peterMoney / 2;

		if (peterMoney > 0) {
			if (paulMoney < 1000) {
				peterPaul.put("Paul", paulMoney + half);

				peterPaul.put("Peter", (half));
			}

		}

		return peterPaul;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has $50 or more, AND
	 * "Paul" has $100 or more, then create a new "PeterPaulPartnership" worth a
	 * combined contribution of a quarter of each partner's current worth.
	 *
	 * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750,
	 * "Paul": 7500, "PeterPaulPartnership": 3750} peterPaulPartnership({"Peter":
	 * 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		Integer peterMoney = peterPaul.get("Peter");
		Integer paulMoney = peterPaul.get("Paul");
		Integer quarterPeter = peterPaul.get("Peter") / 4;
		Integer quarterPaul = peterPaul.get("Paul") / 4;
		Integer comboFunds = 0;

		if (peterMoney >= 5000 && paulMoney >= 10000) {
			paulMoney = paulMoney - quarterPaul;
			peterMoney = peterMoney - quarterPeter;
			comboFunds = quarterPeter + quarterPaul;
			peterPaul.put("PeterPaulPartnership", comboFunds);
			peterPaul.put("Peter", peterMoney);
			peterPaul.put("Paul", paulMoney);
		}
		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for
	 * every different string in the array, there is a key of its first character
	 * with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d",
	 * "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> firstLast = new HashMap<String, String>();
		
		int i = 0;
	
				
		 for(i = 0; i < words.length; i++) {
				String first = words[i].substring(0,1);
				String last = words[i].substring(words[i].length()-1, words[i].length());
			 firstLast.put(first, last);
		 }
			
		return firstLast;
	
	}

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for each
	 * different string, with the value the number of times that string appears in
	 * the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2} wordCount([])
	 * → {} wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> numTimes = new HashMap<String, Integer>();
		
		
		int i = 0;
		int j = 0;		
		for (i = 0; i < words.length; i++) {
			int counter = 0;
			for (j = 0; j < words.length; j++) {
				if (words[i].equals(words[j])){
					counter ++;
				}
			}
			numTimes.put(words[i], counter);
		}
		
		return numTimes;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for
	 * each int, with the value the number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1,
	 * 63: 3, 77: 1, 99:2} integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33:
	 * 4, 106: 1, 107: 3} integerCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> numTimes = new HashMap<Integer, Integer>();
	
		int i = 0;
		int j = 0;		
		for (i = 0; i < ints.length; i++) {
			int counter = 0;
			for (j = 0; j < ints.length; j++) {
				if (ints[i] == (ints[j])){
					counter ++;
				}
			}
			numTimes.put(ints[i], counter);
		}
	
		return numTimes;
	}
	/*
	 * Given an array of strings, return a Map<String, Boolean> where each different
	 * string is a key and value is true only if that string appears 2 or more times
	 * in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> repeats = new HashMap<String, Boolean>();
		int i = 0;
		int j = 0;		
		for (i = 0; i < words.length; i++) {
			int counter = 0;
			for (j = 0; j < words.length; j++) {
				if (words[i] == (words[j])){
					counter ++;
				}
			}
			Boolean more = counter >= 2;
			repeats.put(words[i], more);
		}

		return repeats;
	}
		
	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map,
	 * Map<String, Integer> where keys in Map2, and their Integer values, are added
	 * to the Integer values of matching keys in Map1. Return the new map.
	 *
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11,
	 * "SKU4": 5}) → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		
//		Map<String, Integer> totalItems = new HashMap<String, Integer>();
//		Set<String> main = new HashSet<String>();
		Set<String> remote = remoteWarehouse.keySet();
		
		
		for(String same : remote) {
			if(mainWarehouse.containsKey(same)) {
				
				int added = mainWarehouse.get(same) + remoteWarehouse.get(same);
				mainWarehouse.put(same, added);
			}
			else mainWarehouse.put(same, remoteWarehouse.get(same));
		}
		return mainWarehouse;
		//if sku exists in 1, add the amount to that sku amount
		//if sku does not exist in 1, put both the sku and amount
		//loop through the keys by converting to a set
//		for(Map.Entry<String, Integer> sku : remoteWarehouse.entrySet()) {
//			if(mainWarehouse.containsKey(sku)){
//				Integer argh = mainWarehouse.get(sku); 
//				argh = argh + remoteWarehouse.get(sku); 
//			}
//			System.out.println(sku);
//			else mainWarehouse.put(sku);
		
		}
	

	/*
	 * Just when you thought it was safe to get back in the water ---
	 * last2Revisited!!!!
	 *
	 * Given an array of strings, for each string, the count of the number of times
	 * that a substring length 2 appears in the string and also as the last 2 chars
	 * of the string, so "hixxxhi" yields 1.
	 *
	 * We don't count the end substring, but the substring may overlap a prior
	 * position by one. For instance, "xxxx" has a count of 2, one pair at position
	 * 0, and the second at position 1. The third pair at position 2 is the end
	 * substring, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is string from the array, and its
	 * last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1,
	 * "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> lastTwoSame = new HashMap<String, Integer>();
		int i = 0;
		int j = 0;
		int counter = 0;
		//String lastTwo = words[i].substring(words[i].length() - 1, words[i].length());
		//loop thru string array
		//loop through the substrings of the strings
		//if lastTwo equals substring i to i+2, counter++
		//put the string and the counter in the lastTwoSame map
		for(i = 0; i < words.length; i++) {
			counter = 0;
			for(j = 0; j < words[i].length() - 2; j++) {
				String lastTwo = words[i].substring(words[i].length() - 2, words[i].length());
				 
				//System.out.println(lastTwo);
				if(words[i].substring(j, j + 2).equals(lastTwo)) {
					System.out.println(words[i].substring(j, j + 2));
					counter++;
				}
				
			}lastTwoSame.put(words[i], counter);
		}//System.out.println(lastTwoSame);
		return lastTwoSame;
	}
	

	/*
	 * Given a list of Strings, return a list that contains the distinct values. In
	 * other words, no value is to be included more than once in the returned list.
	 * (Hint: Think Set) distinctValues( ["red", "yellow", "green", "yellow",
	 * "blue", "green", "purple"] ) -> ["red", "yellow", "green", "blue", "purple"]
	 * distinctValues( ["jingle", "bells", "jingle", "bells", "jingle", "all",
	 * "the", "way"] ) -> ["jingle", "bells", "all", "the", "way"]
	 */
	public List<String> distinctValues(List<String> stringList) {
		Set<String> colorSet =  new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		for(String i : stringList) {
			colorSet.add(i);
		}
		for(String j : colorSet) {
			newList.add(j);
		}
		
		return newList;
	}

}
