package com.techelevator;
import static org.junit.Assert.*;
	import java.math.BigDecimal;

	import org.junit.Before;
	import org.junit.Test;
public class TestSavingsAccount {
	
	
	@Test // tested Default Constructors
	public void testDefultConstructor() {
		SavingsAccount testSaving = new SavingsAccount();
		assertEquals("Failed to create defult account", "unknown", testSaving.getAccountNumber());
		assertEquals("Balance Failed for default account", "0.00", testSaving.getBalance().toString());
	}

	@Test // tested savingsConstructor
	public void ToArgumentConstructor() {
		SavingsAccount testSaving = new SavingsAccount(); // created a test savings account constructor
		assertEquals("Failed to create Simplechecking account. ", "unknown", testSaving.getAccountNumber());
		assertEquals("unknown", "0.00", testSaving.getBalance().toString());
	}

	@Test // Testing get Interest  Method
	public void TestGetInterestRate() {
		SavingsAccount testSaving = new SavingsAccount(); // created a test savings account constructor
		assertEquals("Failed to get interest rate. ", "0.02", testSaving.getInterestRate().toString());
	}
	
	@Test // Testing get Interest  Method
	public void TestAddInterest() {
		SavingsAccount testSaving = new SavingsAccount(); // created a test savings account constructor
		testSaving.deposit(new BigDecimal ("100")); 
		BigDecimal interestAmount = testSaving.getBalance().multiply(testSaving.getInterestRate());
		assertEquals("Adding interest to savings failed. ", 102, testSaving.getBalance().add(interestAmount).intValueExact());

	}
	@Test // Testing Withdraw  Method
	public void TestWithdraw() {
		SavingsAccount testSaving = new SavingsAccount(); // created a test savings account constructor
		testSaving.deposit(new BigDecimal ("100")); 
		//testSaving.withdraw(new BigDecimal("10"));
		assertEquals("Withdraw with penelty failed. ", new BigDecimal("88.00"), testSaving.withdraw(new BigDecimal("10")));
	
		SavingsAccount testSavingOne = new SavingsAccount(); // created a test savings account constructor
		testSavingOne.deposit(new BigDecimal ("200")); 
		//testSaving1.withdraw(new BigDecimal("10"));
		assertEquals("Withdraw with no penalty failed", new BigDecimal("190.00"), testSavingOne.withdraw(new BigDecimal("10")));
	
		SavingsAccount testSavingTwo = new SavingsAccount(); // created a test savings account constructor
		testSavingTwo.deposit(new BigDecimal ("100")); 
		assertEquals("Withdraw failed when balance was less then withdraw amount", new BigDecimal("100.00"), testSavingTwo.withdraw(new BigDecimal("150")));
	
		
	}
}








