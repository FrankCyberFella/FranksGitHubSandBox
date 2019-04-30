package com.techelevator.calculator;

public class Calculator {

	//
	// Write code here
	//
	
	private int currentValue;
	
	public int add(int addend) {
		currentValue += addend;
		return currentValue;
	}
	public int multiply(int multiplier) {
		currentValue *= multiplier;
		return currentValue;
	}

public int subtract(int subtrahend) {
	currentValue -= subtrahend;
	return currentValue;
}
public int power(int exponent) {
	for (int i = 1; i < exponent; i++ ) {
		currentValue = currentValue * currentValue;
		
	}
	return currentValue;
}
public void reset() {
	
	currentValue = 0;
	
}
public int getCurrentValue() {
	return currentValue;
}
public void setCurrentValue(int currentValue) {
	this.currentValue = currentValue;
}
}
