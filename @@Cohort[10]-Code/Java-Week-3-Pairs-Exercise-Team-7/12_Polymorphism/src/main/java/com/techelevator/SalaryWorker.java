package com.techelevator;

public class SalaryWorker extends Worker {
	
	private double annualSalary;
	
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		super(firstName, lastName);
		this.annualSalary = annualSalary;
	}
	

		/**
	 * @return the annualSalary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}


	@Override

	public double calculateWeeklyPay(int hoursWorked) {
		return this.annualSalary/52.0;
		
	}
	
	

	
}
