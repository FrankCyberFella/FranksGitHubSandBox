package com.techelevator;

import java.util.ArrayList;
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
		String groupName = "unknown";
		//here we create a map with the key as the animal name and the value as the group name
		//the map will be created with all lower case letters
		Map<String, String> typeAndGroup = new HashMap<String, String>();
		typeAndGroup.put("rhino","Crash");
		typeAndGroup.put("giraffe","Tower");
		typeAndGroup.put("elephant","Herd");
		typeAndGroup.put("lion","Pride");
		typeAndGroup.put("crow","Murder");
		typeAndGroup.put("pigeon","Kit");
		typeAndGroup.put("flamingo","Pat");
		typeAndGroup.put("deer","Herd");
		typeAndGroup.put("dog","Pack");
		typeAndGroup.put("crocodile","Float");

		
		//here we check the parameter animalName using map.get(animalName)
		//the parameters will all be converted to all lower case letters
		if(animalName.length()>0) {
			if(typeAndGroup.containsKey(animalName.toLowerCase())) {
				groupName=typeAndGroup.get(animalName.toLowerCase());
//				System.out.println(groupName);
			}
		}
	
		return groupName;
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "" -> 
	 * "" -> 
	 * ""	-> 
	 * "" -> 
	 * "" -> 
	 * "" -> 
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
		Double saleRate = 0.00;
		
		//Create the HashMap
		Map<String,Double>discountList=new HashMap<String,Double>();
		discountList.put("KITCHEN4001",0.20);
		discountList.put("GARAGE1070",0.15);
		discountList.put("LIVINGROOM",0.10);
		discountList.put("KITCHEN6073",0.40);
		discountList.put("BEDROOM3434",0.60);
		discountList.put("BATH0073",0.15);
		
		//check the parameter animalName using map.get(animalName)
		//the parameters will all be converted to all lower case letters
		if(itemNumber.length()>0) {
			if(discountList.containsKey(itemNumber.toUpperCase())) {
				saleRate=discountList.get(itemNumber.toUpperCase());
//				System.out.println(saleRate);
			}
		}
		
		return saleRate;
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
		

		//declare a variable for storage/transfer amount
		int robbedCash=0;

		//check the conditions: Peter has positive money and Paul has less than $10
		if(peterPaul.get("Peter")>0&&peterPaul.get("Paul")<1000) {
			//Print initial condition
			//System.out.println("Peter has "+peterPaul.get("Peter"));
			//System.out.println("Paul has "+peterPaul.get("Paul"));
			
			//do the transfer
			robbedCash=peterPaul.get("Peter")/2;
			
			peterPaul.put("Peter", peterPaul.get("Peter")-robbedCash);
			peterPaul.put("Paul", peterPaul.get("Paul")+robbedCash);
			
			//Print final condition
//			System.out.println("Peter has "+peterPaul.get("Peter"));
//			System.out.println("Paul has "+peterPaul.get("Paul"));
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
		int peterQuarter=0;
		int paulQuarter=0;
		int partnerFund=0;
		

		
		//check the conditions: Peter>5000 and Paul>10000
		if(peterPaul.get("Peter")>=5000&&peterPaul.get("Paul")>=10000) {
			peterQuarter=peterPaul.get("Peter")/4;
			paulQuarter=peterPaul.get("Paul")/4;
			partnerFund=peterQuarter+paulQuarter;
			peterPaul.put("Peter",peterPaul.get("Peter")-peterQuarter);
			peterPaul.put("Paul",peterPaul.get("Paul")-paulQuarter);
			peterPaul.put("PeterPaulPartnership",partnerFund);
			
		}
		

		
		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		//Initialize a Map of the appropriate type to return
		Map<String, String> letterEnds = new HashMap<String, String>();
		
		//it appears that it's OK to overwrite last letter values of words that have the same key
		for(String word:words) {
			letterEnds.put(word.substring(0,1), word.substring(word.length()-1,word.length()));
		}
		return letterEnds;
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
		
		//Initialize a Map of the appropriate type to return
		Map<String, Integer> stringCount = new HashMap<String, Integer>();
		
		//Let's just start putting everything in the map with and increment the value
		for(String word:words) {
			//we can't increment a null value, so let's see if it's there, increment if it is, initialize if it's not
			if(stringCount.containsKey(word)) {
				stringCount.put(word,stringCount.get(word)+1);
			} else {
				stringCount.put(word,1);
			}
		}
		

		
		return stringCount;
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
	
		//Initialize a Map of the appropriate type to return
		Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
		
		//We can mostly copy and paste from the previous problem
		for(int num:ints) {
			//we can't increment a null value, so let's see if it's there, increment if it is, initialize if it's not
			if(numCount.containsKey(num)) {
				numCount.put(num,numCount.get(num)+1);
			} else {
				numCount.put(num,1);
			}
		}
		
		return numCount;
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
		//Initialize a Map of the appropriate type to return
		Map<String, Boolean> dupStrings = new HashMap<String, Boolean>();
		
		//Let's copy and paste the entire problem from two problems ago:
		Map<String, Integer> stringCount = new HashMap<String, Integer>();
		
		//Let's just start putting everything in the map with and increment the value
		for(String word:words) {
			//we can't increment a null value, so let's see if it's there, increment if it is, initialize if it's not
			if(stringCount.containsKey(word)) {
				stringCount.put(word,stringCount.get(word)+1);
			} else {
				stringCount.put(word,1);
			}
		}
		
		//now go through stringCount and add to dupStrings
		Set<String> keys = stringCount.keySet();
		for(String key:keys){
			dupStrings.put(key, stringCount.get(key)>=2);
		}
		
		return dupStrings;
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
		//Initialize a Map of the appropriate type to return
		Map<String, Integer> addedMap = new HashMap<String, Integer>();
		
		//Just put everything in mainWarehouse into the new map
		Set<String> mainKeys = mainWarehouse.keySet();
		for(String key:mainKeys) {
			addedMap.put(key,mainWarehouse.get(key));
		}
		Set<String> remoteKeys = remoteWarehouse.keySet();
		for(String key:remoteKeys) {
			if(addedMap.containsKey(key)) {
				addedMap.put(key,addedMap.get(key)+remoteWarehouse.get(key));
			} else {
				addedMap.put(key,remoteWarehouse.get(key));
			}
		}
			
		
		
		
		return addedMap;
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
		//Initialize a Map of the appropriate type to return
		Map<String, Integer> last2Count = new HashMap<String, Integer>();
		int counter=0;
		//loop through the given array and solve the problem as done previously
		for(String word:words) {
			if(word.length()>2) {
				for(int i=0;i<word.length()-3;i++) {
					if(word.substring(i,i+2).equals(word.substring(word.length()-2,word.length()))) {
						counter++;
						
					}
				}

				last2Count.put(word,counter);
				counter=0;
			}
			
		}
		
		return last2Count;
	}

	/*
	 Given a list of Strings, return a list that contains the distinct values. In other words, no value is to be
	 included more than once in the returned list. (Hint: Think Set)
	 distinctValues( ["red", "yellow", "green", "yellow", "blue", "green", "purple"] ) -> ["red", "yellow", "green", "blue", "purple"]
	 distinctValues( ["jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"] ) -> ["jingle", "bells", "all", "the", "way"]
	 */
	public List<String> distinctValues(List<String> stringList) {
		List<String> soloWords = new ArrayList<String>();
		Map<String,Integer> tempFilter=new HashMap<String,Integer>();
		
		for(String word:stringList) {
			tempFilter.put(word, 0);
		}
		Set<String> pullKeys=tempFilter.keySet();
		for(String key:pullKeys) {
			soloWords.add(key);
		}
		
		return soloWords;
	}

}
