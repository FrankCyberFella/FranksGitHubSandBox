package com.techelevator;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
public class CheckingAccountTests  {

	
	@Test // tested Default Constructors 
	public void testDefultConstructor () {
		SimpleChecking testChecking = new SimpleChecking(); 
		assertEquals("Failed to create defult account", "unknown", testChecking.getAccountNumber());
		assertEquals("Balance Failed for default account", "0.00", testChecking.getBalance().toString());
	}
		
	@Test // tested SimpleChecking Constructor
	public void ToArgumentConstructor () {
		SimpleChecking testChecking = new SimpleChecking(); //created a test checking account
		assertEquals("Failed to create Simplechecking account. ", "unknown", testChecking.getAccountNumber());
		assertEquals("unknown", "0.00", testChecking.getBalance().toString());
	}
	
	@Test // Testing Withdraw Method
	public void TestWithdraw () {
		SimpleChecking testChecking = new SimpleChecking(); 
		testChecking.deposit(new BigDecimal ("200"));
		testChecking.withdraw(new BigDecimal("100"));
		assertEquals(100.00, testChecking.getBalance().doubleValue(), 0.01);
//		assertEquals("Withdraw without penalty failed", 100.00, testChecking.getBalance().doubleValue());
		
		SimpleChecking testChecking1 = new SimpleChecking(); // withdraw with penalty 
		testChecking1.deposit(new BigDecimal ("100"));
		testChecking1.withdraw(new BigDecimal("150"));
		assertEquals(-60.00, testChecking1.getBalance().doubleValue(), 0.01);
//		assertEquals("Withdraw with penalty failed", -60.00, testChecking1.getBalance().doubleValue());
		
		SimpleChecking testChecking2 = new SimpleChecking(); // if withdraw fails 
		testChecking2.deposit(new BigDecimal ("-200"));
		testChecking2.withdraw(new BigDecimal("100"));
		assertEquals(-200.00, testChecking2.getBalance().doubleValue(), 0.01);
//		assertEquals("Withdraw succeeded. Needed to fail.", -200.00, testChecking2.getBalance().doubleValue());

		
	}
	
	
	
	// below we did with Craig
	
	@SuppressWarnings("deprecation")
	@Test
	public void basicDeposit() {
		SimpleChecking sc = new SimpleChecking();
		assertEquals(0.0, sc.getBalance().doubleValue(), 0.01);
		sc.deposit(new BigDecimal("100.00"));
		assertEquals(100.00, sc.getBalance().doubleValue(), 0.01);
	}
	
	@Test
	public void basicWithdraw() {
		SimpleChecking sc = new SimpleChecking();
		assertEquals(0.0, sc.getBalance().doubleValue(), 0.01);
		sc.deposit(new BigDecimal("100.00"));
		assertEquals(100.00, sc.getBalance().doubleValue(), 0.01);
		sc.withdraw(new BigDecimal("50.00"));
		assertEquals(50.00, sc.getBalance().doubleValue(), 0.01);

	}
	
	@Test
	public void overWithdraw() {
		SimpleChecking sc = new SimpleChecking();
		assertEquals(0.0, sc.getBalance().doubleValue(), 0.01);
		sc.deposit(new BigDecimal("100.00"));
		assertEquals(100.00, sc.getBalance().doubleValue(), 0.01);
		sc.withdraw(new BigDecimal("201.00"));
		assertEquals(100.00, sc.getBalance().doubleValue(), 0.01);
		
	}
}
