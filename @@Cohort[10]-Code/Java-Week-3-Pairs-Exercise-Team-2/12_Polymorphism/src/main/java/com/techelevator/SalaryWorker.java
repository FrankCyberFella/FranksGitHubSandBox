package com.techelevator;

public class SalaryWorker extends Worker {
	
	//data members
	private double annualSalary;
	
	//ctor
	public SalaryWorker() {
		super();
		annualSalary=0;
	}
	
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		super(firstName,lastName);
		this.annualSalary=annualSalary;
	}
	//getters and setters
	/**
	 * @return the annualSalary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	//methods
	public double calculateWeeklyPay(int hoursWorked){
		return this.annualSalary/52;
	}

	

}
