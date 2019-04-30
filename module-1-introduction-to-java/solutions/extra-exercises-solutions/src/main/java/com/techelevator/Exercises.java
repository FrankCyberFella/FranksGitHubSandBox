package com.techelevator;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Exercises {

    /*
    Given an integer array, return the array with all of the duplicate values removed.
    arrayDeduplication([8, 13, 13, 9, 11, 12]) → [8, 13, 9, 11, 12]
    arrayDeduplication([]) → []        
    arrayDeduplication([1, 1, 1]) → [1]
    */
    public int[] arrayDeduplication(int[] nums) {
    	//Make use of the fact that sets ignore duplicates.
    	//Must use LinkedHashSet in order to preserve order, so the result is unit testable.
    	Set<Integer> set = new LinkedHashSet();
    	for (int num : nums) {
    		set.add(num);
    	}
    	//Then convert the set into a int[]
    	int[] newArray = new int[set.size()];
    	int i = 0;
    	for (Integer value : set){
    		newArray[i++] = value;
    	}
    	return newArray;
    }
    
    /*
    CHALLENGE: Using array A and array B, return an array that is the intersection of both A and B.
    The intersection includes numbers that appear in both arrays.
        arrayIntersection([1, 3, 5], [1, 5, 7]) → [1, 5]
        arrayIntersection([1], [1, 5, 7]) → [1]
        arrayIntersection([1, 1, 1], [1, 5, 7]) → [1]
        arrayIntersection([], []) → []
    */
    public int[] arrayIntersection(int[] a, int[] b) {
    	//Need to use ArrayList to preserve order so result can be unit tested
    	List<Integer> list = new ArrayList<>();
    	a = arrayDeduplication(a);	//Remove duplicates in array "a" before proceeding
    	for (int num : a) {			//Now, loop through array "a"
    		for (int i = 0; i < b.length; i++) {
    			if (num == b[i]){	//See if num intersects with the element in array "b"
    				list.add(num);
    			}
    		}
    	}
    	int[] newArray = new int[list.size()];
    	for (int i = 0; i < list.size(); i++){
    		newArray[i] = list.get(i);
    	}
    	return newArray;
    }
    
    /*
    Given an integer array, return the array sorted lowest to highest.
    CHALLENGE: Write the Sort algorithm, don't use the .Sort() method provided to an array. 
    arraySort([8, 13, 9, 12]) → [8, 9, 12, 13]        
    */
    public int[] arraySort(int[] nums) {
    	//Bubble sort, easy to implement, but one of the slowest sorts around.
		for(int i = 0; i < nums.length; i++){
			for(int j = 1; j < nums.length - i; j++){
				if (nums[j - 1] > nums[j]){
					//swap elements
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
        return nums;
    }

    /*
    Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
    Return 0 if they both go over.
    blackjack(19, 21) → 21
    blackjack(21, 19) → 21
    blackjack(19, 22) → 19
    */
    public int blackjack(int a, int b) {
    	if ((a > 21) && (b > 21)) return 0;	//Both greater than 21, return 0;
    	if (a > 21) return b;				//a greater than 21, so must be b, because if b was also greater than 21, then first if would have caught. 
    	if (b > 21) return a;				//b greater than 21, so must be a, because if a was also greater than 21, then first if would have caught.
    	if (a > b) {						//Neither greater than 21, if a greater than b, 
    		return a;						//	then a is closer to 21 without going over
    	}
        return b;							//  then b is closer to 21 without going over
    }
    
    /*
    Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), 
    while the other is "far", differing from both other values by 2 or more.
    Note: Math.abs(num) computes the absolute value of a number.
    closeFar(1, 2, 10) → true
    closeFar(1, 2, 3) → false
    closeFar(4, 1, 3) → true
    */
    public boolean closeFar(int a, int b, int c) {
        if (Math.abs(b - c) < 2) {
        	return false;
        }
        return ((Math.abs(a - b) <= 1) && (Math.abs(a - c) >= 2) || (Math.abs(a - c) <= 1) && (Math.abs(a - b) >= 2));
    }

    /*
    CHALLENGE: Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
    Return the number of clumps in the given array.
    countClumps([1, 2, 2, 3, 4, 4]) → 2
    countClumps([1, 1, 2, 1, 1]) → 2
    countClumps([1, 1, 1, 1, 1]) → 1
    */
    public int countClumps(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
	        if (nums[i] == nums[i + 1]) {
	            count++;
	            for (int j = i + 1; j < nums.length; j++) {
	                if (nums[j] == nums[i]) {
	                	i++;
	                }
	                else {
	                	break;
	                }
	            }
	        }
        }
        return count;
    }

    /*
    CHALLENGE: Write the algorithm to find a sorted list of all the unique permutations of a string.  
    There should be no duplicates in the sorted list.
    If the string is null or empty, return an empty list;
    findPermutations(null) → {}
    findPermutations("") → {}
    findPermutations("A") → {"A"}
    findPermutations("ABC") → {"ABC","ACB","BAC","BCA","CAB","CBA"}
    */
    public List<String> findPermutations(String str)
    {            
        Set<String> permutations = new HashSet<String>();
        if ((str == null) || str.length() == 0) {
            return new ArrayList<String>(permutations);
        } 
        for (int i = 0; i < str.length(); i++) {
        	for (int j = 0; j < str.length(); j++) {
        		if (j < str.length() - 1) {
        	    	char[] chars = str.toCharArray();
        	    	char temp = chars[j];
        	    	chars[j] = chars[j + 1];
        	    	chars[j + 1] = temp;
        	    	str = String.valueOf(chars);
        		}
        		permutations.add(str);
        	}
        }
        List<String> sortedPermutations = new ArrayList<String>(permutations);
        Collections.sort(sortedPermutations);
        // For the daring, comment out the Collections.sort(sortedPermutations) line above, 
        // and uncomment the sortedPermutaions.sort((a, b) -> a.compareTo(b)) line below,
        // in order to experience the joy Java 8 lambdas. 
        // sortedPermutations.sort((a, b) -> a.compareTo(b));
        return sortedPermutations;
    }

    /*
    * Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, followed by 
    * the value plus 5, followed by the value minus 1. 
    * Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
    * has271([1, 2, 7, 1]) → true
    * has271([1, 2, 8, 1]) → false
    * has271([2, 7, 1]) → true     
    */
    public boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] - 5 && (Math.abs((nums[i + 2] + 1) - nums[i]) <= 2)) {
                return true;
            }
        }
        return false;
    }

    /*
    Given three ints, a b c, return true if two or more of them have the same rightmost digit. 
    The ints are non-negative. 
    Note: the % "mod" operator computes the remainder, e.g. 17 % 10 is 7.
    lastDigit(23, 19, 13) → true
    lastDigit(23, 19, 12) → false
    lastDigit(23, 19, 3) → true
    */
    public boolean lastDigit(int a, int b, int c) {
        return a % 10 == b % 10 || a % 10 == c % 10 || b % 10 == c % 10;
    }

    /*
    We want to make a row of bricks that is goal inches long. 
    We have a number of small bricks (1 inch each) and big bricks (5 inches each). 
    Return true if it is possible to make the goal by choosing from the given bricks. 
    This is a little harder than it looks and can be done without any loops.
    makeBricks(3, 1, 8) → true
    makeBricks(3, 1, 9) → false
    makeBricks(3, 2, 10) → true
    */
    public boolean makeBricks(int small, int big, int goal) {
    	return ((goal - big * 5 <= small) && (goal % 5 <= small));
    }

    /*
    CHALLENGE: Given a string, return the length of the largest "block" in the string. 
    A block is a run of adjacent chars that are the same.
    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0
    */
    public int maxBlock(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                	count++;
                }
                else {
                	break;
                }
            }
            if (count > max) {
            	max = count;
            }
        }
        return max;
    }

    /*
    CHALLENGE: Consider the leftmost and righmost appearances of some value in an array.
    We'll say that the "span" is the number of elements between the two inclusive. 
    A single value has a span of 1. 
    Returns the largest span found in the given array. (Efficiency is not a priority.)
    maxSpan([1, 2, 1, 1, 3]) → 4
    maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
    maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
    */
    public int maxSpan(int[] nums) {
        if (nums.length > 0) {
            int maxSpan = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] == nums[i]) {
                        int count = (j - i) + 1;
                        if (count > maxSpan) {
                        	maxSpan = count;
                        }
                        break;
                    }
                }
            }
            return maxSpan;
        } 
        else {
        	return 0;
        }

    }

    /*
    * Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
    * mixStart("mix snacks") → true
    * mixStart("pix snacks") → true
    * mixStart("piz snacks") → false        
    */
    public boolean mixStart(String str) {
    	return str.length() >= 3 && str.substring(1, 3).equals("ix");
    }

    /*
    Given an array of ints, return true if the number of 1's is greater than the number of 4's
    more14([1, 4, 1]) → true
    more14([1, 4, 1, 4]) → false
    more14([1, 1]) → true
    */
    public boolean more14(int[] nums) {
        int ones = 0;
        int fours = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
            	ones++;
            }
            if (nums[i] == 4) {
            	fours++;
            }
        }
        return ones > fours;
    }
    
    /*
    * Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in 
    * the array. Return true if the array does not contain any triples.        
    *
    * noTriples([1, 1, 2, 2, 1]) → true
    * noTriples([1, 1, 2, 2, 2, 1]) → false
    * noTriples([1, 1, 1, 2, 2, 2, 1]) → false
    */
    public boolean noTriples(int[] nums) {
    	for (int i=0; i < (nums.length - 2); i++) {
    		int first = nums[i];
    		if (nums[i + 1]==first && nums[i + 2]==first) {
    			return false;
    		}
    	}
    	return true;
    }

    /*
    * Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". 
    * Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". 
    * Ignore any group of fewer than 3 chars at the end.
    * oneTwo("abc") → "bca"
    * oneTwo("tca") → "cat"
    * oneTwo("tcagdo") → "catdog"
    */
    public String oneTwo(String str) {
    	String result = "";
   		for (int i = 0; i < str.length() - 2; i+=3) {
   			result += str.substring(i + 1, i + 3);
   			result += str.substring(i, i + 1);
    	}
        return result;
    }
    
    /*
    * Given two strings, word and a separator sep, return a big string made of count occurrences 
    * of the word, separated by the separator string.
    * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    * repeatSeparator("This", "And", 2) → "ThisAndThis"
    * repeatSeparator("This", "And", 1) → "This"
    */
    public String repeatSeparator(String word, String sep, int count) {
    	String result = "";
    	for (int i = 0; i < count - 1; i++) {
    		result += word + sep;
    	}
    	if (count > 0) {
    		result += word;
    	}
    	return result;
    }

    /*
    * Return true if the given string contains between 1 and 3 'e' chars.
    * ("Hello") → true
    * ("Heelle") → true
    * ("Heelele") → false
    */
    public boolean stringE(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
            	count++;
            }
        }
        return (count >= 1 && count <= 3);
    }
    
    /*
    * Given 2 strings, a and b, return the number of the positions where they contain the same length 
    * 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" 
    * substrings appear in the same place in both strings.        * 
    * stringMatch("xxcaazz", "xxbaaz") → 3
    * stringMatch("abc", "abc") → 2
    * stringMatch("abc", "axc") → 0  
    */
    public int stringMatch(String a, String b) {
    	int len = Math.min(a.length(), b.length());
    	int count = 0;
    	for (int i = 0; i < len - 1; i++){
    		String aSub = a.substring(i, i + 2);
    		String bSub = b.substring(i, i + 2);
    		if (aSub.equals(bSub)) {
    			count++;  
    		}
    	}
    	return count;
    }

    /*
    Return true if the array contains, somewhere, three increasing adjacent numbers like 
    .... 4, 5, 6, ... or 23, 24, 25.
    tripleUp([1, 4, 5, 6, 2]) → true
    tripleUp([1, 2, 3]) → true
    tripleUp([1, 2, 4]) → false
    */
    public boolean tripleUp(int[] nums) {
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i + 1] == nums[i] + 1 && nums[i + 2] == nums[i] + 2) {
            	return true;
            }
        }
        return false;
    }

    /*
    * Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and 
    * ending with 'p'. Return a string where for all such words, the middle letter is gone. 
    * "zipXzap" yields "zpXzp".
    * zipZap("zipXzap") → "zpXzp"
    * zipZap("zopzop") → "zpzp"
    * zipZap("zzzopzop") → "zzzpzp"
    */
    public String zipZap(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
            	str = str.substring(0,i + 1) + str.substring(i + 2);
            }
        }
        return str;
    }
}
