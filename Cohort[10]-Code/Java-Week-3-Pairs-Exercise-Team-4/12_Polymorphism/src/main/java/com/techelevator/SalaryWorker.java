package com.techelevator;

public class SalaryWorker extends Worker {

	private double annualSalary;

	/**
	 * @return the hourlyRate
	 */
	public double getannualSalary() {
		return annualSalary;
	}
	
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		super(firstName,lastName);
		this.annualSalary = annualSalary;
		
	}
	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay;
		
		pay = annualSalary / 52;
		
		return pay;
		
	}
	
}
