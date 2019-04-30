package com.techelevator;

public interface PaidEmployees {

	//if one implements this interface, they MUST provide these methods
	
	static final double taxRate = .10;
	
	public double calculateWeeklyPay(int numHoursWorked);
	
	double calculateIncomeTax(double pay);
	
}
