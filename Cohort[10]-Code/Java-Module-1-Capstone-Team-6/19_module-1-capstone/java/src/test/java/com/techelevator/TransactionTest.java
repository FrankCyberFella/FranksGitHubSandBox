package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {

	Transaction transactionTest = new Transaction(10.00);	
	@Test
	public void get_Current_Money_Test() {
	
		Assert.assertEquals("That is not the expected result", 10.00 , transactionTest.getCurrentMoney(), 0.001);
	}
	
	@Test
	public void subtract_Current_Money_Test() {
		transactionTest.subtractCurrentMoney(5.65);
		Assert.assertEquals("That is not the expected result", 4.35 , transactionTest.getCurrentMoney(), 0.001);
	}
	
	@Test
	
	public void add_Current_Money_Test() {
		transactionTest.addCurrentMoney(3.25);
		Assert.assertEquals("That is not the expected result", 13.25, transactionTest.getCurrentMoney(), 0.001);
	}
	
	@Test
	
	public void reset_Change_Test() {
		transactionTest.resetChange();
		Assert.assertEquals("That is not the expected result", 0.00, transactionTest.getQuarters(), 0.001);
		Assert.assertEquals("That is not the expected result", 0.00, transactionTest.getDimes(), 0.001);
		Assert.assertEquals("That is not the expected result", 0.00, transactionTest.getNickels(), 0.001);
		
	}
	
	
	
	
}


