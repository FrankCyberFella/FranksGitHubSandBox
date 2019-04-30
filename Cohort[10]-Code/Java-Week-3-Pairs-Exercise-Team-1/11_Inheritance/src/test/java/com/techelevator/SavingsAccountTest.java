package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class SavingsAccountTest {
	@Test
	public void SavingsAccount() {
		SavingsAccount exercises = new SavingsAccount();
		assertEquals(new String ("unknown"), exercises.getAccountNumber());
		assertEquals(new BigDecimal ("0.00"), exercises.getBalance());
	}
	@Test
	public void getInterestRate() {
		SavingsAccount exercises = new SavingsAccount();
		assertEquals(new BigDecimal ("0.02"), exercises.getInterestRate());
	}
	@Test
	public void Savings_Account_Default() {
		SavingsAccount exercises = new SavingsAccount();
		assertEquals(new String ("unknown"), exercises.getAccountNumber());
		assertEquals(new BigDecimal ("0.00"), exercises.getBalance());
	}
	
	@Test
	public void addInterest() {
		SavingsAccount exercises = new SavingsAccount();
		exercises.deposit(new BigDecimal ("1000.00"));
		assertEquals(1020.00, exercises.addInterest().doubleValue(),0.0);
	}

}
