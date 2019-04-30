package com.techelevator;

public class Employee {

	//DECLARING VARIABLES OR DATA MEMBERS
		private int employeeId; //These are what the object knows
		private String firstName;
		private String lastName;
		// private string fullName fullName is a derived attribute that returns lastName, firstName.
		private String department;
		private double annualSalary; 
		
		//CONSTRUCTORS // method to create an instance of a class, thats why its capatalized
		public Employee(int employeeId, String firstName, String lastName, double salary) {
		this.employeeId = employeeId; // The constructor is setting values in the class. Pulling from the class to set class variables. 
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = salary; 
		}
		
		
		/*GETTERS & SETTERS 
		*Getters & Setters are public.
		*They allow the values for the private 
		*variabless to be set to a given value and retrive that value when used
		*/
		
		public String getFullName() { //The employee's last name.
			return lastName +", " + firstName;
		}
		
		public String getLastName() { //The employee's last name.
			return lastName;
		}


		public void setLastName(String lastName) { //The employee's last name
			this.lastName = lastName;
		}


		public String getDepartment() { //	The employee's department
			return department;
		}


		public void setDepartment(String department) { //	The employee's department.
			this.department = department;
		}


		public int getEmployeeId() { //The employee id.
			return employeeId;
		}


		public String getFirstName() { //The employee's first name.
			return firstName;
		}


		public double getAnnualSalary() { //The employee's annual salary.
			return annualSalary;
		}


		//METHODSS
		public void raiseSalary(double percent){// Method
		 annualSalary = (annualSalary * (percent/100)) + annualSalary;//raiseSalary(double percent) increases the current annual salary by the percentage provided
		 //annualSalary times percent divided by 1000
		}
		
}

