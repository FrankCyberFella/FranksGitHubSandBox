package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CheckingAccountTest {
	
	@Test
	public void testCheckingWithdrawMethod() {
		BankAccount customBankAccount = new CheckingAccount("customAccount", new BigDecimal("100"));
		assertEquals("Balance was 100, withdrew 10.", new BigDecimal("90"), customBankAccount.withdraw(new BigDecimal("10")));
	}
	
	@Test
	public void testCheckingWithdrawOverdraftMethod() {

		BankAccount customBankAccount = new CheckingAccount("customAccount", new BigDecimal("0"));
		assertEquals("Balance was 0, withdrew 10, incurring overdraft fee of 10.", new BigDecimal ("-20"), customBankAccount.withdraw(new BigDecimal ("10")));
	}
	
	@Test
	public void testCheckingWithdrawMethodBalanceMinium() {
		BankAccount customBankAccount = new CheckingAccount("customAccount", new BigDecimal("10"));
		assertEquals("Balance was 10, withdrew 200, balance cannot go below -100.", new BigDecimal("10"), customBankAccount.withdraw(new BigDecimal("200")));
	}

}
