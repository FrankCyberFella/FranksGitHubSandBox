//package com.GraphingCalculator;
//
//public class StringToNumber {
//
//	public StringToNumber() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		toNumber(new String[] {"((x)*(x))","+","2/x","-","3"});
//		
//		//toNumber("x^2 + 3*x  -2");
//	}
//	
//	public static double toNumber(String number) { // we will want our other method to return the array list
//		////System.out.println(number);
//
//		FunctionCalculator equation = new FunctionCalculator();
//		equation.setFunction(number);// change this for testing purposes
//		int k = 0;
//		//for (String num : numberArray) { // need to transfer our array to a new value
//	//		num.replaceAll("x", "10");
//	//		k++;
//	//	}
//	
//		//number = equation.turnFunction();
//		//number = number.replaceAll("x","15-300"); // set this inside the for each loop when i have to
//	
//		String[] tester = numberArray;
//		double[] numHolder = new double[20];
//		//String[] tester = {"((10)*(10))","+","2/10","-","3"}; // this is the tester value we are using
//		double[] result = new double[tester.length];
//		int count = 0;
//		for (String test: tester) { // will have to change tester when i FINISH THIS CODE
//			
//			if (test.contains("+") || test.contains("-")) {
//				result[count] = 0;
//				count++;
//				continue;
//				
//			}
//			test = test.replaceAll("\\(",""); // replaceing all parenthesis
//			test = test.replaceAll("\\)","");
//			//System.out.println(test);
//		if (test.contains("*") || test.contains("/")) {
//			if (test.contains("*")) {
//				String[] split = test.split("\\*");
//				int i = 0;
//				for (String result2: split) { // 
//					////System.out.println(result2);
//					if (i == 0) {
//						result[count] += Double.parseDouble(result2);
//						i++;
//					} else {
//						result[count] *= Double.parseDouble(result2); //trying to parse the double at the correct point and 
//					}
//					
//																  //multiply the answers together
//					
//				}
//
//
//			}
//	
//			if (test.contains("/")) {
//				String[] split = test.split("\\/");
//				int i = 0;
//				for (String result2: split) { // 
//					////System.out.println(result2);
//					if (i == 0) {
//						result[count] += Double.parseDouble(result2);
//						i++;
//					} else {
//						result[count] /= Double.parseDouble(result2); //trying to parse the double at the correct point and 
//					}
//					
//																  //multiply the answers together
//					
//				}
//				//System.out.println(result[count]);
//			}
//		} else {
//			result[count] = Double.parseDouble(test);
//		}
//			
//
//			////System.out.println(test);
////			if (!test.contains("*") || !test.contains("/")) {
////				result[count] = Double.parseDouble(test);
////			}
//			//.out.println("Hello");
//			count++;
//		}
//		
//		//System.out.println("Here are your array of answers"); // you are getting some weird answers when 
//															  // printing your double array
////		for (Double arraySpot: result) {
////			
////			//System.out.println(arraySpot);
////		}
////		//System.out.println("Here is your array of strings");
////		for (String arraySpot: tester) {
////			//System.out.println(arraySpot);
////		}
//		int j = 0;
//		String[] finalArray = new String[tester.length];
//		for (String spot : tester) { // you will have to change tester in your final code
//			if (j % 2 == 0) {
//				finalArray[j] = result[j] + "";
//				
//			} else {
//				finalArray[j] = tester[j];
//			}
//			j++;
//		} // analyzed the two arrays and put them back together as completed code bits
//		// put these values into finalArray
//		
//		//System.out.println("Here is your final analyzed array");
//		
//		
//		for (String finalResult: finalArray) {
//			System.out.println(finalResult);
//		}
//		int counter = 0;
//		double finalValue = 0.0;
//		for (String arraySpot : finalArray) {
//			if (counter == 0) {
//				finalValue = Double.parseDouble(arraySpot);
//			}
//			if (arraySpot.equals("+") && counter % 2 == 1) {
//				finalValue += Double.parseDouble(finalArray[counter+1]);
//			}
//			if (arraySpot.equals("-") && counter % 2 == 1) {
//				finalValue -= Double.parseDouble(finalArray[counter+1]);
//			}
//			
//			counter++;
//		}
//		System.out.println(finalValue);
//		
//		
//		return finalValue;
//	}
//
//}
