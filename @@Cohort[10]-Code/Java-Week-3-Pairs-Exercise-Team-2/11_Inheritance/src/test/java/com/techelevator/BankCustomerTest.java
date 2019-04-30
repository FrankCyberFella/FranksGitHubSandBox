package com.techelevator;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;

public class BankCustomerTest {

	BankCustomer frank = new BankCustomer("Frank","Tech Elevator","911");
	
	@Test
	public void getName() {
		assertEquals("Name not as expected","Frank",frank.getName());
	}
	@Test
	public void setName() {
		frank.setName("Ginzo");
		assertEquals("Name not as expected","Ginzo",frank.getName());
	}
	@Test
	public void getAddress() {
		assertEquals("Address not as expected","Tech Elevator",frank.getAddress());
	}
	@Test
	public void setAddress() {
		frank.setAddress("Euclid Avenue #140");
		assertEquals("Address not as expected","Euclid Avenue #140",frank.getAddress());
	}
	@Test
	public void getPhoneNumber() {
		assertEquals("Phone number not as expected","911",frank.getPhoneNumber());
	}
	@Test
	public void setPhoneNumber() {
		frank.setPhoneNumber("411");
		assertEquals("Phone number not as expected","411",frank.getPhoneNumber());
	}
	@Test
	public void getAccounts() {
		//frank.addAccount(newAccount);
	}
}
