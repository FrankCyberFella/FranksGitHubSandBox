package com.techelevator;

public class KataStringCalculator {
	
	private String result;
	public static int addString(String result) {
		result = result.replaceAll("\n", ",");
		String [] result2 = result.split(",");
		int holder = 0;
		if (result.equals("")){
			return 0;
		}
		for(String number : result2) {
			holder += Integer.parseInt(number);
			
		}
			return holder;
	}
	
}
