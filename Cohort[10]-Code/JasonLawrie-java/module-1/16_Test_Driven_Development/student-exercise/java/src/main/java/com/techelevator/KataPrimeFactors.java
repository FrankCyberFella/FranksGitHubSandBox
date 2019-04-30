package com.techelevator;


public class KataPrimeFactors {

	private int[] factorArray = new int[]{0};
	
	public KataPrimeFactors() {
		
	}
	
	public int[] factorize(int n) {
		
		
		int[] storageArray = new int[factorArray.length+1];
		
		//initialize a new array that's longer than the existing array
		for(int i=0;i<factorArray.length;i++) {
			storageArray[i]=factorArray[i];
		}
		
		//for the first element we have to put the first prime factor in index zero
		if(factorArray[0]==0) {
			//loop through all integers less than n to see if any of them are divisible into n
			//Start with 2 or else we'll get an infinite number of factors of 1
			for(int i=2;i<n;i++) {
				//check for divisibility
				if(n%i==0) {
					factorArray[0]=i;
					n/=i;
					//end the loop every time we find a factor because we're using an array and can only add one at a time
					break;
				}
				if(i+1==n) {
					factorArray[0]=n;
					return factorArray;
				}
			}
			if(n>factorArray[factorArray.length-1]+2) {
				factorize(n);
			}
			
		//for all elements after the first we need to put the prime factor in the next open index
		} else {
			for(int i=2;i<n;i++) {
				if(n%i==0) {
					
					storageArray[storageArray.length-1]=i;
					factorArray=storageArray;
					n/=i;
					break;
				}
				if(i+1==n) {
					storageArray[storageArray.length-1]=n;
					factorArray=storageArray;
					return factorArray;
				}
			}
			if(n>=factorArray[factorArray.length-1]) {
				factorize(n);
			}
		}
		
		
		
		return factorArray;
	}
	
}
