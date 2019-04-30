package com.techelevator;

public interface PaidEmployees {
	
	// IF one implements this interface, they MUST provide these methods
	
	static final double taxRate = .10;
	
	public double calculateWeeklyPay(int numHoursWorked);
	
	public double calculateIncomeTax(double pay);
}
