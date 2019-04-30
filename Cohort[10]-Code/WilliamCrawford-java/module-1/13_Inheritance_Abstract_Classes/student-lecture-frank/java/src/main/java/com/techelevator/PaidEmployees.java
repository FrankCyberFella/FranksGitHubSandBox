package com.techelevator;

public interface PaidEmployees {
	// If one implements this interface they MUST provide these methods
	//final, static is assumed by an interface
	
	public double calculateWeeklyPay(int numHoursWorked);
	
	double calculateIncomeTax(double pay);
	
}
