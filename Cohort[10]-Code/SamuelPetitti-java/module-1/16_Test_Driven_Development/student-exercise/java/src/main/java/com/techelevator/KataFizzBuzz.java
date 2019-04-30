package com.techelevator;

public class KataFizzBuzz {
	
	public String fizzBuzz(int number) {
		if(number == 0) {
			return "";
		}
		String fizzBuzz = "";
		int fizz = 0;
		int buzz = 0;
		String[] numToSplitStr = Integer.toString(number).split("");
		if(number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		}
		for(int i = 0; i <numToSplitStr.length; i++) {
			if(numToSplitStr[i].equals("3")) {
				fizz ++;
			} else{
				if(numToSplitStr[i].equals("5")) {
					buzz ++;
				}
			} 
		}
		if(fizz > 0) {
			fizzBuzz += "Fizz";
		} 
		if(buzz > 0) {
			fizzBuzz += "Buzz";
			} 
		if(fizzBuzz.length() > 0) {
			return fizzBuzz;
		}
		
	
		if(number % 3 == 0) {
			return "Fizz";
		} else {
			if(number % 5 == 0) {
				return "Buzz";
			}else {
				if(number > 0 && number <= 100) {
					return Integer.toString(number);
				}
			}
		}
		
		return "";
	}
}

	
//	String[] numToSplitStr = Integer.toString(number).split("");
//	if(number == 0) {
//		return "";
//	} else {
//		if(number == 35 || number == 53) {
//			return "FizzBuzz";
//		}
//	}
//	if(number % 3 == 0 && number % 5 == 0) {
//		return "FizzBuzz";
//	} else {
//		if(number % 3 == 0) {
//			return "Fizz";
//		} else {
//			if(number % 5 == 0) {
//				return "Buzz";
//			}
//		}
//	}
//	int fizzBuzzCounter = 0;
//		for(int i = 0; i< numToSplitStr.length; i++) {
//				if(numToSplitStr[i].equals("3")) {
//					return "Fizz";
//				} else {
//					if(numToSplitStr[i].equals("5")) {
//						return "Buzz";
//				}
//			} 
//			 
//			if(fizzBuzzCounter == 2) {
//					return "Buzz";
//				} else {
//					if(fizzBuzzCounter == 1) {
//						return "Fizz";
//					}
//				}
//			} 
//		if(number > 0 && number <= 100) {
//					return Integer.toString(number);
//			}
//		
//	 return "";
//}
	