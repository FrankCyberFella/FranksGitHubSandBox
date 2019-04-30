package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.junit.*;

import org.junit.Test;

public class BankAccountTest {




	
	/*
	 * @Before public void BankAccount_HasRequiredMembers() { Class Bank =
	 * BankAccount.class;
	 * 
	 * Constructor<BankAccount> constructor = SafeReflection.getConstructor(Bank);
	 * assertTrue("You do not have the required constructor () ", constructor !=
	 * null);
	 * 
	 * Constructor<BankAccount> constructor1 = SafeReflection.getConstructor(Bank,
	 * String.class, BigDecimal.class);
	 * assertTrue("You do not have the required constructor (String, BigDecimal) ",
	 * constructor != null);
	 * 
	 * //Method method = SafeReflection.getMethod(Bank, "getAccountNumber");
	 * 
	 * }
	 */
	
	@Test
	public void testGetAccountNumber() {
		
		//BankAccount unknown = new BankAccount();
		//BankAccount joe = new BankAccount("1234", new BigDecimal("50000"));
		BankAccount tester = new BankAccount();
		BankAccount twoArgsTester = new BankAccount("1234",new BigDecimal("50000"));
	
		assertEquals("unknown",tester.getAccountNumber());
		assertEquals("1234",twoArgsTester.getAccountNumber());
	}
	
	@Test
	public void testSetAccountNumber() {
		
		//BankAccount unknown = new BankAccount();
		BankAccount tester = new BankAccount();
		BankAccount twoArgsTester = new BankAccount("1234",new BigDecimal("50000"));
		
		tester.setAccountNumber("143");
		
		assertEquals("143",tester.getAccountNumber());
		tester.setAccountNumber("1234");
		assertEquals("1234",tester.getAccountNumber());
	}


	@Test
	public void testGetBalance() {
		BankAccount tester = new BankAccount();
		BankAccount twoArgsTester = new BankAccount("1234",new BigDecimal("50000"));
		
		assertEquals("The balance obtained did not contain $0",new BigDecimal("0.00"),tester.getBalance());
		assertEquals("The balance obtained did not contain $50000",new BigDecimal("50000"),twoArgsTester.getBalance());
		
	}
	
	@Test
	public void testDeposit() {
		BankAccount twoArgsTester = new BankAccount("1234",new BigDecimal("0.00"));
		
		assertEquals("The balance when deposit does not equal $0 when depositing $0",new BigDecimal("0.00"),twoArgsTester.deposit(new BigDecimal("0")));
		assertEquals("The balnce when deposit again does not equal $15000",new BigDecimal("15000.00"),twoArgsTester.deposit(new BigDecimal("15000")));
		assertEquals("The balnce when deposit again does not equal $50000",new BigDecimal("50000.00"),twoArgsTester.deposit(new BigDecimal("35000")));

	}
	
	@Test
	public void testWithdraw() {
		//BankAccount tester = new BankAccount();
		BankAccount twoArgsTester = new BankAccount("1234",new BigDecimal("50000"));
		
		assertEquals("The balance when withdrawn does not equal $15000",new BigDecimal("15000"),twoArgsTester.withdraw(new BigDecimal("35000")));
		assertEquals("The balnce when withdrawn again does not equal $0",new BigDecimal("0"),twoArgsTester.withdraw(new BigDecimal("15000")));
		assertEquals("The balnce when withdrawn again does not equal $0 when withdrawing $0",new BigDecimal("0"),twoArgsTester.withdraw(new BigDecimal("0")));
		assertEquals("The balnce when withdrawn again does not equal $0",new BigDecimal("-10"),twoArgsTester.withdraw(new BigDecimal("10")));
	}
	
	@Test
	public void testTransfer() {
		BankAccount tester = new BankAccount("12345",new BigDecimal("70000"));
		BankAccount twoArgsTester = new BankAccount("1234",new BigDecimal("50000"));
		
		tester.transfer(twoArgsTester, new BigDecimal("20000"));
		assertEquals("Did not properly transfer",new BigDecimal("50000"),tester.getBalance());
		assertEquals("Did not properly transfer",new BigDecimal("70000"),twoArgsTester.getBalance());
		
		twoArgsTester.transfer(twoArgsTester, new BigDecimal("15000"));
		assertEquals("Did not properly transfer to itself",new BigDecimal("70000"),twoArgsTester.getBalance());
		
		twoArgsTester.transfer(tester, new BigDecimal("72000"));
		assertEquals("Did not properly transfer",new BigDecimal("122000"),tester.getBalance());
		assertEquals("Did not properly transfer",new BigDecimal("-2000"),twoArgsTester.getBalance());
		
	}
	
	
}
