package com.techelevator;

import java.util.Map;
import java.util.TreeMap;

public class KataNumbersToWords {
	
	public KataNumbersToWords() {
		
	}

	public String conversion(int number) {
		String result = "";
		
		TreeMap<Integer,String> numNames = new TreeMap<Integer,String>();
		
	//	numNames.put(100, "one hundred")
		numNames.put(90,"ninety");
		numNames.put(80,"eighty");
		numNames.put(70,"seventy");
		numNames.put(60,"sixty");
		numNames.put(50,"fifty");
		numNames.put(40,"forty");
		numNames.put(30,"thirty");
		numNames.put(20,"twenty");
		numNames.put(19,"nineteen");
		numNames.put(18,"eighteen");
		numNames.put(17,"seventeen");
		numNames.put(16,"sixteen");
		numNames.put(15,"fifteen");
		numNames.put(14,"fourteen");
		numNames.put(13,"thirteen");
		numNames.put(12,"twelve");
		numNames.put(11,"eleven");
		numNames.put(10,"ten");
		numNames.put(9,"nine");
		numNames.put(8,"eight");
		numNames.put(7,"seven");
		numNames.put(6,"six");
		numNames.put(5,"five");
		numNames.put(4,"four");
		numNames.put(3,"three");
		numNames.put(2,"two");
		numNames.put(1,"one");
		numNames.put(0,"zero");
		
		while(number>0) {
			if(number > 99 && number <= 999) {
				result += numNames.get(number / 100);
				result+=" hundred";
				number-= number / 100 * 100;
				if(number != 0) {
					result+=" and ";
				}
			} else {
				if(numNames.containsKey(number)) {
					result+=numNames.get(number);
				} else {
					result+=numNames.get(numNames.floorKey(number));
					if(number>10&&number<100) {
						result+="-";
					}
				}
				number-=numNames.floorKey(number);
			}
			
		}
		
		System.out.println(result);
		

		return result;
}
}
