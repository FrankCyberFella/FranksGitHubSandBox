package com.techelevator;

public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String department;
	private double annualSalary;

	private String fullName; // ??

	public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;

	}

//  methods / getters and setters
	public void raiseSalary(double percent) {
		annualSalary = annualSalary + (annualSalary * percent)/100;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the annualSalary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() { // need args? String lastName, String firstName
		fullName = lastName + ", " + firstName;

		return fullName;
	}

}
