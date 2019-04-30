package com.techelevator.calculator;

public class Calculator {
int currentValue = 0;

public int add(int addend) {
	currentValue = currentValue + addend;
	return currentValue;
}
public int multiply(int multiplier) {
	currentValue = currentValue*multiplier;
	return currentValue;
}
public int subtract(int subtrahend) {
	currentValue = currentValue - subtrahend;
	return currentValue;
}
public int power(int exponent) {

	for (int i = 0; i < exponent - 1; i++) {
		currentValue = currentValue*currentValue;
	}
	return currentValue;
	
}
public void reset() {
	currentValue = 0;
}







public int getCurrentValue() {
	return currentValue;
}



	//
	// Write code here
	//
	
}
