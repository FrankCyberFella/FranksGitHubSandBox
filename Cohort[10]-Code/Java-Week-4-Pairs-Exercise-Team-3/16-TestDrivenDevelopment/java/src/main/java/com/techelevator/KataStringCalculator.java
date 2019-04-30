package com.techelevator;

public class KataStringCalculator {
	
	private String userString = "";

	public KataStringCalculator(String userString) {
		this.userString = userString;
	}
	
	public int add(String userString) {
		int convertedInt = 0;
		
		if (userString.equals("")) {
			
			return 0;
		}
		String[] unknownNumbers = userString.split("\n|,");
		
		for (int i = 0; i < unknownNumbers.length; i++) {
			
			convertedInt += Integer.parseInt(unknownNumbers[i]);
			
		}
		
		return convertedInt;
	}
}
