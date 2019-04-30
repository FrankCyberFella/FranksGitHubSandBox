package com.techelevator;

public interface PaidEmployees {
	
	//If someone implements this interface, they must provide these methods
	
	static double taxRate = .10;
	
	public double calculateWeeklyPay(int numHoursWorked);
	
	public double calculateIncomeTax(double pay);
}

//SImply trying to require other classes to use these methods