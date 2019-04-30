package com.techelevator;

public class Helloworld {

	public static void main(String[] args) {
		// function check whether a number 
		// is prime or not 
		char[] stuff = {'a','b','c','d','e'};
//		int n = 47; 
//	    printIfPrime(n); 
	    System.out.println("Before: " );  
//        for(int i=0; i < stuff.length-1; i++) {
//	    	System.out.print(stuff[i]);
	    }
//	    char[] newChars = reverseChars(chars);
//	    System.out.println("\nAfter: ");
//	    for (char ltr : newChars) System.out.print(ltr);
	
	char[] reverseChars(char[]letter) {
		char hold;
		
		int j = letter.length-1;
		for (int i=0; i < letter.length/2; i++)
		{
			hold = letter[i];
			letter[i] = letter[j];
			letter[j] = hold;
			j--;
		}
		 for (char ltr : letter) System.out.print(ltr);
		return letter;
	}
	
//		static boolean isPrime(int n) 
//		{ 
//		    // Corner case 
//		    if (n <= 1) 
//		        return false; 
//		  
//		    // Check from 2 to n-1 
//		    for (int i = 2; i < n; i++) 
//		        if (n % i == 0) 
//		            return false; 
//		  
//		    return true; 
//		} 
//		// Function to print primes 
//		static void printIfPrime(int n) 
//		{ 
//			System.out.println("Prime numbers from 2 thru " + n);
//		    for (int i = 2; i <= n; i++) { 
//		        if (isPrime(i)) 
//		           System.out.println(i + " ");; 
//		    } 
//		} 
	
	}

