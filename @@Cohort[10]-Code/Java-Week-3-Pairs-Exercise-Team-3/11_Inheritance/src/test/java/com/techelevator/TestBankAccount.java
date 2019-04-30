package com.techelevator;

import static org.junit.Assert.*;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class TestBankAccount {

	@Test // tested Default Constructors
	public void testDefultConstructor() {
		BankAccount testBank = new BankAccount();
		assertEquals("Failed to create defult account", "unknown", testBank.getAccountNumber());
		assertEquals("Balance Failed for default account", "0.00", testBank.getBalance().toString());
	}
	
	@Test
	public void ToArgumentConstructor () {
		BankAccount testBank = new BankAccount(); //created a test checking account
		assertEquals("Failed to create Simplechecking account. ", "unknown", testBank.getAccountNumber());
		assertEquals("unknown", "0.00", testBank.getBalance().toString());
	}
	@Test
	public void TestDeposit() {
		BankAccount testBank = new BankAccount();
		assertEquals("Failed to depostit. ", new BigDecimal("30.00"), testBank.deposit(new BigDecimal("30.00")));
		
	}
	@Test
	public void TestWithdraw() {
		BankAccount testBank = new BankAccount();
		testBank.deposit(new BigDecimal("60.00"));
		assertEquals("Failed to withdraw. ", new BigDecimal("45.00"), testBank.withdraw(new BigDecimal("15.00")));
	}
	@Test
	public void TestTransfer() {
		BankAccount testChecking = new BankAccount();
		BankAccount testSaving = new BankAccount();
		testChecking.deposit(new BigDecimal("60.00"));
		testChecking.transfer(testSaving, new BigDecimal("10.00"));
		
		assertEquals("Failed to Transfer from Checking to Savings. Checking did not withdraw.", (new BigDecimal("50.00")), testChecking.getBalance());
		assertEquals("Failed to Transfer from Checking to Savings. Savings did not deposit", (new BigDecimal("10.00")), testSaving.getBalance());

	}
}

	


