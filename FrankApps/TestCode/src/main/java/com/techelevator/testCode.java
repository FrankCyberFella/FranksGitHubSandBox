package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import com.techelevator.ginzUtilities.*;

public class testCode {

	public static void main(String[] args) {
        
        /*
         *  This program will demonstrate several concepts presented in the Java cohort 		
        */
		
		Map<String, BigDecimal> aMap = new HashMap<String, BigDecimal>();
		
		aMap.put("Test", new BigDecimal(19.95));
		
		List<String> anArrayList = new ArrayList<String>();
		
		anArrayList.add("Clubs");
		anArrayList.add("Spades");
		anArrayList.add("Spades");
		anArrayList.add("Spades");
		anArrayList.add("Spades");
		
		Map<String, Integer> suitCount = new HashMap<String,Integer>();
		
		suitCount.put("Clubs",0);
		suitCount.put("Diamonds",0);
		suitCount.put("Hearts",0);
		suitCount.put("Spades",0);
		suitCount.put("Jokers",0);
	
	
		for (String aCard : anArrayList) {
			suitCount.put(aCard, suitCount.get(aCard)+1);
			}
		
		Set<String> suits = suitCount.keySet();
		
		for (String aSuit : suits ) {
			System.out.println("Num " + aSuit + ": " + suitCount.get(aSuit));
		}
		if (suitCount.containsValue(5)) {
			System.out.println("You have a Flush");
		}
		}
}
