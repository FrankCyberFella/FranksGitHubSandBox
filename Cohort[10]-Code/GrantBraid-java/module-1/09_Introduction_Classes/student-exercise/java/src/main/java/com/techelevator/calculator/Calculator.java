package com.techelevator.calculator;

public class Calculator {

	
	private int currentValue = 0;

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
		return currentValue += addend;
	}
	
	public int multiply(int multiplier) {
		return currentValue *= multiplier;
	}
	
	public int subtract(int subtrahend) {
		return currentValue -= subtrahend;
	}
	
	public int power(int exponent) {
		System.out.println(exponent);

		for (int i = 1; i < exponent ; i++) {
			currentValue *= currentValue;
		}

		return currentValue;
	}
	
	public void reset() {
		currentValue = 0;
	}
	//
	// Write code here
	//
	
}
