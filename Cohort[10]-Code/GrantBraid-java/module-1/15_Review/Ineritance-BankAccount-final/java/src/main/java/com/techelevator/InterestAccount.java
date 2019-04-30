package com.techelevator;

public interface InterestAccount {

	// An interface requires anyone who implements it to reate methods defined in the interface
	// The only data an interface can have is final static
	
	final static double intRate = 0.02; // Constant interest rate of 2%
	
	public DollarAmount addInterest();
	
}
