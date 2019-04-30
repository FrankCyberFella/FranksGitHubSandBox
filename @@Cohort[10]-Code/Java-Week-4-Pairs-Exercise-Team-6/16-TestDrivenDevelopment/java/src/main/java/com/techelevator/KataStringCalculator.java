package com.techelevator;

public class KataStringCalculator {

	public int add(String numbers) {
		if(numbers.equals("")) {
			return 0; 
		}
		//int unNum = Integer.parseInt(numbers);
		 int sum = 0;
		String[] splitNums = numbers.split("[,\n]");// split at the space. 
		for(int i=0; i< splitNums.length; i++){
			int splitNum = Integer.parseInt(splitNums[i]);
			sum += splitNum;
		}	
     return sum; 	
	}
}