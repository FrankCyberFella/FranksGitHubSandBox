package com.techelevator;

import java.util.TreeMap;

public class testFloorkey {
	

	public static void main(String[] args)  {
 
		TreeMap<Integer, String> romanNumeralMap = new TreeMap<Integer, String>();
	    
	    romanNumeralMap.put(1000,"M");
	    romanNumeralMap.put( 500,"D");
	    romanNumeralMap.put( 100,"C");
	    romanNumeralMap.put(  50,"L");
	    romanNumeralMap.put(  10,"X");
	    romanNumeralMap.put(   5,"V");
	    romanNumeralMap.put(   1,"I");
    
	    showFloor(romanNumeralMap,    0);
	    showFloor(romanNumeralMap,    1);
	    showFloor(romanNumeralMap,    5);
	    showFloor(romanNumeralMap,    6);
	    showFloor(romanNumeralMap,    10);
	    showFloor(romanNumeralMap,    11);
	    showFloor(romanNumeralMap,    14);
	    showFloor(romanNumeralMap,  400);
	    showFloor(romanNumeralMap,    51);
	    showFloor(romanNumeralMap,    49);
	    showFloor(romanNumeralMap,  3000);
	    showFloor(romanNumeralMap,  2019);
	    showFloor(romanNumeralMap,    21);
	    showFloor(romanNumeralMap,    66);
       
        
//      Set<Integer> keys = romanNumeralMap.keySet();
//		for(Integer anInt : keys) {
     
//			while (decimalValue >= romanNumeralMap.floorKey(decimalValue)) {
//					decimalValue -= romanNumeralMap.floorKey(decimalValue);
//					result += romanNumeralMap.get(romanNumeralMap.floorKey(decimalValue));
//			}
////				}
        	
        

	}
	  static public void showFloor(TreeMap<Integer, String> myMap, int num) {
	        System.out.printf("floorKey of %d is %d\n", num, myMap.floorKey(num));
	        	
	        }

}
