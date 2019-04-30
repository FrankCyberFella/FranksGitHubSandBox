package com.techelevator;

public class KataStringCalculator {
	
	public KataStringCalculator() {
		
	}
	
	public int add(String numbers) {
		int retInt=0;	
		
		//First test to see if any operations are required at all
		if(numbers != "") {
			
			//allow the user to change the delimiter, using the characters "//" as the request
			if(numbers.startsWith("//")) {
				
				//Collect the delimiter request from the string as the substring before the new line
				String[] numArray = numbers.split("\n");
				
				
				String splitter = "\\"+numArray[0].substring(2,numArray[0].length());
				
				String[] subArray = numbers.substring(numArray[0].length()+1,numbers.length()).split(splitter);

				for(String nums:subArray) {

					if(!nums.equals("")) {
						retInt+=Integer.parseInt(nums);
					}
					
				}
			}
			else {
				String[] numArray = numbers.split(",|\n");
				
				for(int i = 0; i<numArray.length; i++) {
					retInt+=Integer.parseInt(numArray[i]);
				}
			}
			
		}	
		return retInt;
	}
	
}
