package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CheckingAccountTest {

	@Test
	public void test_Checking_Account_Constructor() {
		BankAccount tester = new CheckingAccount();
		BankAccount twoArgsTester = new CheckingAccount("1234",new BigDecimal("50000"));
	
		assertEquals("unknown",tester.getAccountNumber());
		assertEquals("1234",twoArgsTester.getAccountNumber());
		
	}
	
	@Test
	public void test_To_String_method() {
		BankAccount twoArgsTester = new CheckingAccount("1234",new BigDecimal("50000"));
		
		assertNotNull("Did not contain string", twoArgsTester.toString());
		
	}
	
	@Test
	public void test_Withdraw_method() {
		BankAccount twoArgsTester = new CheckingAccount("1234",new BigDecimal("100.00"));
		BankAccount twoArgsTester2 = new CheckingAccount("12345",new BigDecimal("100.00"));
		
		assertEquals("Did not stop withdraw", new BigDecimal("100.00"), twoArgsTester.withdraw(new BigDecimal("200.00")));
		assertEquals("Did not stop withdraw", new BigDecimal("-60.00"), twoArgsTester.withdraw(new BigDecimal("150.00")));
		assertEquals("Did not stop withdraw", new BigDecimal("50.00"), twoArgsTester2.withdraw(new BigDecimal("50.00")));
		assertEquals("Did not stop withdraw", new BigDecimal("0.00"), twoArgsTester2.withdraw(new BigDecimal("50.00")));
	}
	
	

}
