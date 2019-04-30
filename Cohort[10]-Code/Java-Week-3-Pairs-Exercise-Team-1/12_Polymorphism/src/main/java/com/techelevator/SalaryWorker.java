package com.techelevator;

public class SalaryWorker extends Worker {
	
	private double annualSalary;
	
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		super(firstName, lastName);
		this.annualSalary = annualSalary;
	}
	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		
		double pay = annualSalary/52;
		return pay;
	}
	/**
	 * @return the annualSalary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}
	

}
