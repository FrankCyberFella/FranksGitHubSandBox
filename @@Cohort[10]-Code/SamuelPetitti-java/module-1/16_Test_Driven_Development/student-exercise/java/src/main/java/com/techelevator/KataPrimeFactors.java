package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class KataPrimeFactors {
	
	public List<Integer> factorize(int number){
		 List<Integer> primeFactors = new ArrayList<Integer>();
		 int i = 2;
		 while(i <= number) {
			if(number % i == 0) {
				primeFactors.add(i);
				number = number/i;
			} else {
				i++;
			}
		} return primeFactors;
	}
}
