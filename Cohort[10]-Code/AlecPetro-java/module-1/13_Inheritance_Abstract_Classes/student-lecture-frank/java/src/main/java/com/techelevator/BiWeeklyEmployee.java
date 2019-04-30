package com.techelevator;

public class BiWeeklyEmployee extends Worker {
	
	public BiWeeklyEmployee(String firstName, String lastName) {
		super(firstName, lastName);
		
	}

	@Override
	public double calculateWeeklyPay(int numHoursWorked) {
		return 0;
	}

	@Override
	public double calculateIncomeTax(double pay) {
		return 0;
	}

}
