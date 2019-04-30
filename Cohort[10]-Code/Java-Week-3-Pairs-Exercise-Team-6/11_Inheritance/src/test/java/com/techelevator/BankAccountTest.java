package com.techelevator;


import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class BankAccountTest {
	
	BankAccount blankBankAccount = new BankAccount();
	BankAccount customBankAccount = new BankAccount("customAccount", new BigDecimal("17534"));
	
	@Test
	public void testThatDefaultAccountBalanceIsZero() {
		assertEquals("Default account balance is not equal to 0", new BigDecimal("0"), blankBankAccount.getBalance());
	}
	
	@Test
	public void testThatDefaultAccountNumberIsUnknown() {
		assertEquals("Default account number is not set to \"unknown\"", "unknown", blankBankAccount.getAccountNumber());
	}
	
	@Test
	public void testTwoArgumentConstructor() {
		assertEquals("The account number is not the same as was given when instantiated", "customAccount", customBankAccount.getAccountNumber());
		assertEquals("The account balance is not the same as was given when instantiated", new BigDecimal("17534"), customBankAccount.getBalance());
	}

	@Test
	public void testDepositMethod() {
		BankAccount testBankAccount = new BankAccount("testNumber", new BigDecimal("100"));
		assertEquals(new BigDecimal("110"), testBankAccount.deposit(new BigDecimal("10")));
	}
	
	@Test
	public void testWithdrawMethod() {
		BankAccount testBankAccount = new BankAccount("testNumber", new BigDecimal("100"));
		assertEquals(new BigDecimal("90"), testBankAccount.withdraw(new BigDecimal("10")));
	}
	
	@Test
	public void testTransferMethod() {
		BankAccount testBankAccount = new BankAccount("testNumber", new BigDecimal("100"));
		BankAccount testBankAccount2 = new BankAccount("testNumber", new BigDecimal("100"));
		
		assertEquals(new BigDecimal("50"), testBankAccount.transfer(testBankAccount2, new BigDecimal("50")));
	}
	
	

}
