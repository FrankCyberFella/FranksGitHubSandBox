package com.techelevator.calculator;

public class Calculator {
	private int currentValue = 0;
	
	public int add(int addend) {
		return currentValue = currentValue + addend;
	}
	
	public int multiply(int multiplier) {
		return currentValue = currentValue * multiplier;
	}
	
	public int subtract(int subtrahend) {
		return currentValue = currentValue - subtrahend;
	}
	
	public int power(int exponent) {
		return currentValue = (int) Math.pow(currentValue, exponent);
	}
	public void reset() {
		this.currentValue = 0;
	}

	public int getCurrentValue() {
		return currentValue;
	}
}
