package com.techelevator.calculator;

public class Calculator {

	//
	// Write code here
	//
	private int currentValue;
	
	public int add(int addend) {
		currentValue+=addend;
		return currentValue;
	}
	public int multiply(int multiplier) {
		currentValue*=multiplier;
		return currentValue;
	}
	public int subtract(int subtrahend) {
		currentValue-=subtrahend;
		return currentValue;
	}
	public int power(int exponent) {
		int startingValue=currentValue;
		for(int i = 1;i<exponent;i++) {
			currentValue = startingValue*currentValue;
		}
		return currentValue;
	}
	public void reset() {
		currentValue=0;
	}
	/**
	 * @return the currentValue
	 */
	public int getCurrentValue() {
		return currentValue;
	}
	
}
