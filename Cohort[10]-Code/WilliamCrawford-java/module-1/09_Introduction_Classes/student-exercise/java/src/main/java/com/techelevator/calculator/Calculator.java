package com.techelevator.calculator;

public class Calculator {

	private int currentValue;

	/**
	 * @return the currentValue
	 */
	public int getCurrentValue() {
		return currentValue;
	}

	/**
	 * @param currentValue the currentValue to set
	 */
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public int add(int addend) {
		currentValue += addend;
		
		return currentValue;
		
	}
	public int multiply(int multiplier) {
		currentValue = multiplier * currentValue;
		return currentValue;
	}
	public int subtract(int subtrahend) {
		currentValue -= subtrahend;
		return currentValue;
	}
	
	public int power(int exponent) {
		//currentValue = (int) Math.pow(currentValue, exponent);
		int container = currentValue;
		for(int i = 1; i < exponent; i++) {
			currentValue = currentValue * container;
		}
		
		return currentValue;
		
	}
	public void reset() {
		currentValue = 0;
		
	}
	// Write code here
	//
	
}
