package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class SavingsAccountTest {

	@Test
	public void testSavingsWithdrawMethod() {
		BankAccount customBankAccount = new SavingsAccount("customAccount", new BigDecimal("200"));
		assertEquals("Balance was 200, withdrew 10.", new BigDecimal("190"), customBankAccount.withdraw(new BigDecimal("10")));
	}
	
	@Test
	public void testSavingsWithdrawTooMuchMethod() {
		BankAccount customBankAccount = new SavingsAccount("customAccount", new BigDecimal("10"));
		assertEquals("Balance was 10, withdrew 20, cannot withraw more than balance", new BigDecimal ("10"), customBankAccount.withdraw(new BigDecimal ("20")));
	}
	
	@Test
	public void testLowBalanceWithdrawMethod() {
		BankAccount customBankAccount = new SavingsAccount("customAccount", new BigDecimal("10"));
		assertEquals("Balance was 10, withdrew 200, balance cannot go below -100.", new BigDecimal("10"), customBankAccount.withdraw(new BigDecimal("200")));

	}
	
	@Test
	public void testSavingsWithdrawFeeMethod() {
		BankAccount customBankAccount = new SavingsAccount("customAccount", new BigDecimal("100"));
		assertEquals("Balance was 100, withdrew 20, incurring fee of 2 ", new BigDecimal("78"), customBankAccount.withdraw(new BigDecimal("20")));
	}
	
	@Test
	public void testAddInterestMethod() {
		BankAccount customBankAccount = new SavingsAccount("customAccount", new BigDecimal("100"));
		assertEquals("Balance was 100, interest rate is 2%", new BigDecimal ("102.00"), customBankAccount.addInterest());
	}
	

}
