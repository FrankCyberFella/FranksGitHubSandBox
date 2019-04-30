package com.techelevator.calculator;

public class Calculator {

private int currentValue;
	//
	// Write code here
	//

/**
 * @return the currentValue
 */
public int getCurrentValue() {
	return currentValue;
}

public int add(int addend) {
	currentValue = currentValue + addend;
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
	int constantValue = currentValue;
	for (int i = 1; i < exponent; i++) {
		currentValue = currentValue * constantValue;
		
	} return currentValue;

}
public void reset() {
	currentValue = 0; 
}
}
