package com.techelevator;

public interface PaidEmployee {

	// One implements this interface they MUST provide these methods
	
	static final double TAX_RATE = .10;
	
	public double calculateWeeklyPay(int numHoursWorked);
	
	public double calculateIncomeTax(double pay);
	
}
