package com.techelevator;

public class KataPrimeFactors {

	public int[] factorize(int n) {
		
		int[]result = new int[500];
		for(int i=0; i<n; i++) {
			for(int j=2; j<n; j++) {
				if(n%j==0) {
					result[i] = j;
					n = n/j;
					break;
				}
			}
		}
	 	return result;
	}
}
