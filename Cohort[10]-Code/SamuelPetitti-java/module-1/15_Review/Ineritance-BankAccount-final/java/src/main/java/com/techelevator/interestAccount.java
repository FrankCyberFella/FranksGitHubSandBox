package com.techelevator;

public interface interestAccount {
	
	//An interface requires anyone who implements it to create methods in the interface
	
	final static double intRate = .02; //Constant interest rate of 2%
	
	public DollarAmount addInterest();

}
