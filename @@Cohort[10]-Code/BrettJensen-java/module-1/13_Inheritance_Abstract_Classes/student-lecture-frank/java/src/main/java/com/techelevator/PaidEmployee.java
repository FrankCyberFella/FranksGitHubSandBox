package com.techelevator;

public interface PaidEmployee {

	// If one implements this interface they MUST provide these methods
	
	static final double taxRate = .10;
	
	public double calculateWeeklyPay(int numberOfHoursWorked);
	
	public double calculateIncomeTax(double pay);
	
}
