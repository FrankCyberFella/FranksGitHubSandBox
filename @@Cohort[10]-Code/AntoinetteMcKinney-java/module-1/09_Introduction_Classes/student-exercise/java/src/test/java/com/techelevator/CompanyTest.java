package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.company.Company;

public class CompanyTest {

	private Company companyNew;

	@Before
	public void setUp() throws Exception {
		companyNew = new Company();
	}

	@Test
	public void companySizeSmallTest() {
		companyNew.setNumberOfEmployees(10);
		assertEquals("Number of Employees is less then 50", "small", companyNew.getCompanySize());// method

	}

	@Test
	public void companySizeMediumTest() {
		companyNew.setNumberOfEmployees(60);
		assertEquals("Number of Employess is between 50 to 250", "medium", companyNew.getCompanySize());// metho

	}

	@Test
	public void companySizeLargeTest() {
		companyNew.setNumberOfEmployees(300);
		assertEquals("Number of Employees is greater then 250", "large", companyNew.getCompanySize());

	}

	@Test
	public void getProfit() {
		companyNew.setExpense(5.0);
		companyNew.setRevenue(10.0);
		assertEquals(5.0, 5.0, 0); //expected double, actual double, and delta change 
		
	}

}
