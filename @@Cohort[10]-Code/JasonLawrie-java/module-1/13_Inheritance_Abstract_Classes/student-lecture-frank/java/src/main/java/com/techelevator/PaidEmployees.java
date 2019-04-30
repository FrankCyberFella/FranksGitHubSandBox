package com.techelevator;

public interface PaidEmployees {
	
	//if a class implements this interface, it MUST provide these methods:
	public double calculateWeeklyPay(int hoursWorked);
	
	static final double taxRate=.1;
	
	double calculateIncomeTax(double pay);

	
}
