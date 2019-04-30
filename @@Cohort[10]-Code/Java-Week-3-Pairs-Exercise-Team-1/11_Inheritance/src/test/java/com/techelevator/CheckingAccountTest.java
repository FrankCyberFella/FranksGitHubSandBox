package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CheckingAccountTest {
	
	@Test
	public void withdraw() {
	CheckingAccount exercises2 = new CheckingAccount("12345", new BigDecimal ("100.00"));
	exercises2.withdraw(new BigDecimal ("110.00"));
	assertEquals(new BigDecimal ("-20.00"), exercises2.getBalance());
	
	CheckingAccount exercises3 = new CheckingAccount("123456", new BigDecimal ("100.00"));
	exercises3.withdraw(new BigDecimal ("250.00"));
	assertEquals(new BigDecimal ("100.00"), exercises3.getBalance());
	}
	@Test
	public void CheckingAccount() {
	CheckingAccount exercises = new CheckingAccount();
	assertEquals(new String ("unknown"), exercises.getAccountNumber());
	assertEquals(new BigDecimal ("0.00"), exercises.getBalance());
	
	
	}
}
