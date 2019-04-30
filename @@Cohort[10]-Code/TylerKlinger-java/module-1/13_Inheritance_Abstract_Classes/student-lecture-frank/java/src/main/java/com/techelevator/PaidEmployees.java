package com.techelevator;

public interface PaidEmployees {
	static final double taxRate = .10;
	public double calculateWeeklyPay (int numHoursWorked);
	//One implements this interface, must provide these methods
	double calculateIncomeTax(double pay);
}
