package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import java.math.BigDecimal;

import org.junit.*;
import org.junit.Test;

public class BankAccountTest {
	
	BankAccount bankAccountTest = new BankAccount("1234", new BigDecimal("500.00"));
	BankAccount destinationAccountTest = new BankAccount("5555", new BigDecimal("0.00"));

	@Test
    public void testDeposit() { //object-with-code.method-to-test(any-params-for-the-method)
        Assert.assertEquals("That is not the expected result.", new BigDecimal("1000.00"), bankAccountTest.deposit(new BigDecimal("500.00")));
        				//expected result		, method-to-test
    }
	
	@Test
	public void testWithdrawLessThanBalance() {
		Assert.assertEquals("That is not the expected result.", new BigDecimal("250.00"), bankAccountTest.withdraw(new BigDecimal("250.00")));
	}
	
	@Test
	public void testWithdrawMoreThanBalance() {
		Assert.assertEquals("That is not the expected result.", new BigDecimal("500.00"), bankAccountTest.withdraw(new BigDecimal("501.00")));
	}
	
	@Test
	public void testTransferLessThanBalance() {
		bankAccountTest.transfer(destinationAccountTest, new BigDecimal("250.00"));
		Assert.assertEquals("That is not the expected result.", new BigDecimal("250.00"), bankAccountTest.getBalance());
		Assert.assertEquals("That is not the expected result.", new BigDecimal("250.00"), destinationAccountTest.getBalance());		
	}
	
	@Test
	public void testTransferMoreThanBalance() {
		bankAccountTest.transfer(destinationAccountTest, new BigDecimal("501.00"));
		Assert.assertEquals("That is not the expected result.", new BigDecimal("500.00"), bankAccountTest.getBalance());
		Assert.assertEquals("That is not the expected result.", new BigDecimal("0.00"), destinationAccountTest.getBalance());
	}
	
	@Test
	public void testGetAccountNumber() {
		Assert.assertEquals("Nope.", "1234", bankAccountTest.getAccountNumber());
	}
	
	@Test
	public void testSetAccountNumber() {
		bankAccountTest.setAccountNumber("4321");
		Assert.assertEquals("Nope.", "4321", bankAccountTest.getAccountNumber());
	}
	
	@Test
	public void testGetBalance() {
		Assert.assertEquals("Nope.", new BigDecimal("500.00"), bankAccountTest.getBalance());
	}
	
//	@Test
//	public void testSetBalance() {
//		bankAccountTest.setBalance(new BigDecimal("1000"));
//		Assert.assertEquals("Nope.", "1000", bankAccountTest.getBalance());
//	}
}
