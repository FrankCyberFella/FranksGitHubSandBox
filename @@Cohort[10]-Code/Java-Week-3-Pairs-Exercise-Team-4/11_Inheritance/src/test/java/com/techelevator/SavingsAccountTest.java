package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class SavingsAccountTest {

	@Test
	public void test_Savings_Account_Constructor() {
		BankAccount tester = new SavingsAccount();
		BankAccount twoArgsTester = new SavingsAccount("1234",new BigDecimal("50000"));
	
		assertEquals("unknown",tester.getAccountNumber());
		assertEquals("1234",twoArgsTester.getAccountNumber());
		
	}
	
	@Test
	public void test_Get_Interest_Rate() {
		SavingsAccount tester = new SavingsAccount();
		
		assertEquals("Interest rate should be 0.02%", new BigDecimal("0.02"), tester.getInterestRate());
	}
	
	@Test
	public void test_To_String_method() {
		BankAccount twoArgsTester = new SavingsAccount("1234",new BigDecimal("50000"));
		
		assertNotNull("Did not contain string", twoArgsTester.toString());
		
	}
	
	@Test
	public void test_Withdraw_method() {
		BankAccount twoArgsTester = new SavingsAccount("1234",new BigDecimal("1000.00"));
		BankAccount twoArgsTester2 = new SavingsAccount("12345",new BigDecimal("150.00"));
		
		assertEquals("Did not stop withdraw", new BigDecimal("1000.00"), twoArgsTester.withdraw(new BigDecimal("1050.00")));
		assertEquals("Did not stop withdraw", new BigDecimal("0.00"), twoArgsTester.withdraw(new BigDecimal("1000.00")));
		assertEquals("Did not stop withdraw", new BigDecimal("100.00"), twoArgsTester2.withdraw(new BigDecimal("50.00")));
		assertEquals("Did not stop withdraw", new BigDecimal("48.00"), twoArgsTester2.withdraw(new BigDecimal("50.00")));
	}
	
	@Test
	public void test_Add_Interest_Method() {
		SavingsAccount twoArgsTester = new SavingsAccount("1234",new BigDecimal("1000.00"));
		SavingsAccount twoArgsTester2 = new SavingsAccount("12345", new BigDecimal("0.00"));
		
		assertEquals("Did not add interest", new BigDecimal("1020.0000"), twoArgsTester.addInterest());
		assertEquals("Did not add interest", new BigDecimal("0.0000") , twoArgsTester2.addInterest());
	}

}
