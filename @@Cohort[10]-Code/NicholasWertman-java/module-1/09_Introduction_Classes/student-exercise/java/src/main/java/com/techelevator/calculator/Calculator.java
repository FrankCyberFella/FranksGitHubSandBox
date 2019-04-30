package com.techelevator.calculator;

public class Calculator {
	
	
	private int currentValue;

	/**
	 * @return the currentValue
	 */
	public int getCurrentValue() {
		return currentValue;
	}
	
	public int add(int addend) {
		return this.currentValue = this.currentValue + addend;
	}
	
	public int multiply(int multiplier) {
		return this.currentValue = this.currentValue * multiplier;
	}
	
	public int subtract(int subtrahend) {
		return this.currentValue = this.currentValue - subtrahend;
	}
	
	public int power(int exponent) {
		return this.currentValue = (int) Math.pow(this.currentValue, exponent) ;
	}
	
	public void reset() {
		this.currentValue = 0;
	}

	

	//
	// Write code here
	//
	
}
