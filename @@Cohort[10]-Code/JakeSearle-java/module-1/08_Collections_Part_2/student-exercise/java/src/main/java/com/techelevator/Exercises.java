package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exercises {

	/*
	 * Map Exercises
	 */

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		
		Map<String, String> animalFamily = new HashMap<String, String>();
		animalName = animalName.toLowerCase();
		animalFamily.put("rhino", "Crash");
		animalFamily.put("giraffe", "Tower"); 
		animalFamily.put("elephant", "Herd");
		animalFamily.put("lion", "Pride");
		animalFamily.put("crow", "Murder");
		animalFamily.put("pigeon", "Kit");
		animalFamily.put("flamingo", "Pat");
		animalFamily.put("deer", "Herd");
		animalFamily.put("dog", "Pack");
		animalFamily.put("crocodile", "Float");
		if (!animalFamily.containsKey(animalName)) {
			return "unknown";
		}
		
		
		return animalFamily.get(animalName); 
	}
	
	
	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public Double isItOnSale(String itemNumber) {
		Map<String, Double> salePrice = new HashMap<String, Double>();
		itemNumber = itemNumber.toLowerCase();
		salePrice.put("kitchen4001", 0.20);
		salePrice.put("garage1070", 0.15);
		salePrice.put("livingroom", 0.10);
		salePrice.put("kitchen6073", 0.40);
		salePrice.put("bedroom3434", 0.60);
		salePrice.put("bath0073", 0.15);
		if(!salePrice.containsKey(itemNumber)) {
			return 0.00;
		}
			return salePrice.get(itemNumber);
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int paulMoney = peterPaul.get("Paul");         //get Pauls money from the map
		int peterMoney = peterPaul.get("Peter");       // get Peters money from the map
		int halfPeter = peterMoney / 2;                // calculating half of Peter's money
		if ((peterMoney > 0) && (paulMoney < 1000)) {
			 peterMoney = peterMoney - halfPeter;
			 paulMoney = paulMoney + halfPeter;
			 peterPaul.put("Peter", peterMoney);
			 peterPaul.put("Paul", paulMoney);
		
		}
		return peterPaul;
	}

    /*
	 * Modify and return the given map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750, "Paul": 7500, "PeterPaulPartnership": 3750}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int paulDough = peterPaul.get("Paul");
		int peterDough = peterPaul.get("Peter");
		int paulFourth = paulDough / 4;
		int peterFourth = peterDough / 4;
		int ppPartnership = paulFourth + peterFourth;
		if ((peterDough >= 5000) && (paulDough >= 10000)) { 
			paulDough = paulDough - paulFourth;
			peterDough = peterDough - peterFourth;
			ppPartnership = paulFourth + peterFourth;
			peterPaul.put("Peter", peterDough);
			peterPaul.put("Paul", paulDough);
			peterPaul.put("PeterPaulPartnership", ppPartnership);
		}	
		
		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array,
	 * there is a key of its first character with the value of its last character. In cases where two or more words
	 * have the same first letter but different last letters, words toward the end of the array take precedence.
	 * 
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */ // for loop
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> letterMap = new HashMap<String, String>();
		for (int i = 0; i < words.length; i++) {
		char valOne = words[i].charAt(0);
		char valLast = words[i].charAt(words[i].length() - 1);
		String first = Character.toString(valOne);
		String last = Character.toString(valLast);
		letterMap.put(first, last);
		}
		return letterMap;
	}

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the
	 * number of times that string appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			String currentPos = words[i];
		if (!countMap.containsKey(currentPos)) {
			countMap.put(currentPos, 1);
		}
		else {
			int counter = countMap.get(currentPos);
			countMap.put(currentPos, counter + 1);
		}
		}
		
		return countMap;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * integerCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> mapNums = new HashMap<Integer, Integer>();
		for (int i = 0; i < ints.length; i++) {
			int atNow = ints[i];
		if (!mapNums.containsKey(atNow)) {
			mapNums.put(atNow, 1);
		}
		else {
			int keepScore = mapNums.get(atNow);
			mapNums.put(atNow, keepScore + 1);
		}
		}
		return mapNums; 
	}

	/*
	 * Given an array of strings, return a Map<String, Boolean> where each different string is a key and value
	 * is true only if that string appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> booMap = new HashMap<String, Boolean>();
		for (int i = 0; i < words.length; i++) {
			String curPosition = words[i];
		if (!booMap.containsKey(curPosition)) {
			booMap.put(curPosition, false);
		}
		else {
			booMap.put(curPosition, true);
		}
		}
			return booMap; 
		} 
		
	
	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map, Map<String, Integer> where keys in Map2,
	 * and their Integer values, are added to the Integer values of matching keys in Map1. Return the new map.
	 *
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {
		
		for(String remoteKey : remoteWarehouse.keySet()) {
			int remoteValue = remoteWarehouse.get(remoteKey);
			if (mainWarehouse.containsKey(remoteKey)) {         //main warehouse has product, we need to update count value 
				int mainValue = mainWarehouse.get(remoteKey);
				int newValue = mainValue + remoteValue;
				mainWarehouse.put(remoteKey, newValue); 
			} 
			else {                                              //main warehouse doesn't have product, we need to add to mw
				mainWarehouse.put(remoteKey, remoteValue);
			}
		}
		return mainWarehouse;
	}
 
	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of strings, for each string, the count of the number of times that a substring length 2 appears
	 * in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1.
	 *
	 * We don't count the end substring, but the substring may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end substring, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is string from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		return null;
	}

	/*
	 Given a list of Strings, return a list that contains the distinct values. In other words, no value is to be
	 included more than once in the returned list. (Hint: Think Set)
	 distinctValues( ["red", "yellow", "green", "yellow", "blue", "green", "purple"] ) -> ["red", "yellow", "green", "blue", "purple"]
	 distinctValues( ["jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"] ) -> ["jingle", "bells", "all", "the", "way"]
	 */
	public List<String> distinctValues(List<String> stringList) {
		return null;
	}

}
