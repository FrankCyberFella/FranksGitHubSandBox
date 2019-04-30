package com.techelevator;

public interface InterestAccount {

	//An interface requires anyone who implements it to create methods defined in the interface
	
	//The only data an interface can have is a final static
	
	final static double intRate = 0.02; //Constant interest rate of 2%
	
	public DollarAmount addInterest(); 
	
	//Classes that implement this interface must have an addInterest method 
	//and have access to a constant data member called intRate which is set @ 0.02
}
