package com.techelevator;

public interface PaidEmployees {
	
	public static final double taxRate = .10;
	
	// If one implements this interface they MUST provide these methods
	public double calculateWeeklyPay(int numHoursWorked);
	
	double calculateIncomeTax(double pay);
	
}
