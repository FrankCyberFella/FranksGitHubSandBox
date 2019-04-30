package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void employeeConstructedCorrectly() {
		Employee e = new Employee(123, "Steve", "Wozniak", 1.00);
		Assert.assertEquals(123, e.getEmployeeId());
		Assert.assertEquals("Steve", e.getFirstName());
		Assert.assertEquals("Wozniak", e.getLastName());
		Assert.assertEquals(1.00, e.getAnnualSalary(), 0.001);
	}
	
	@Test
	public void employeeFullNameCorrect() {
		Employee e = new Employee(123, "Steve", "Wozniak", 1.00);
		Assert.assertEquals("Wozniak, Steve", e.getFullName());
	}
	
	@Test
	public void setGetDepartment() {
		Employee e = new Employee(123, "Steve", "Wozniak", 1.00);
		e.setDepartment("Department of Redundancy Department");
		Assert.assertEquals("Department of Redundancy Department", e.getDepartment());
	}
	
	@Test
	public void giveOldWozARaise() {
		Employee e = new Employee(123, "Steve", "Wozniak", 1.00);
		e.RaiseSalary(15);
		assertEquals(1.15, e.getAnnualSalary(), 0.001);
	}
	
	@Test
	public void attemptToGiveWozANegativeRaise() {
		Employee e = new Employee(123, "Steve", "Wozniak", 1.00);
		e.RaiseSalary(-15.0);
		Assert.assertEquals(1.00, e.getAnnualSalary(), 0.001);
	}
}
