package com.techelevator;


import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import java.math.BigDecimal;

import org.junit.*;
import org.junit.Test;


public class CheckingAccountTest {
	
	CheckingAccount checkingAccountTest = new CheckingAccount("1234", new BigDecimal("500.00"));
	
	@Test
	public void testWithdrawLessThanBalance() {
		Assert.assertEquals("That is not the expected result.", new BigDecimal("250.00"), checkingAccountTest.withdraw(new BigDecimal("250.00")));
	}
	
	@Test
	public void testWithdrawMoreThanBalanceAndOverdrat() {
		Assert.assertEquals("That is not the expected result.", new BigDecimal("490.00"), checkingAccountTest.withdraw(new BigDecimal("599.99")));
	}	
	
	@Test
	public void testWithdrawMoreThanBalanceAndNoOverdraft() {
		Assert.assertEquals("That is not the expected result.", new BigDecimal("500.00"), checkingAccountTest.withdraw(new BigDecimal("600.99")));
	}	
	
}
