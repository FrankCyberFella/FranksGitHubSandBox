package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeDispenserTest {

	/*
	 *  When testing the actual method you must create a 'new' instance of the Class 
	 *  so you can call the method that you expect to test. [i.e. new ChangeDispenser()]
	 */
	
	@Test
	public void changeDispenserTest() {
		double cowTails = 1.59;
		double payment = 4.00;
		assertEquals(0.00, new ChangeDispenser().changeDispenser(payment, cowTails), 0.00);
		

		//fail("Not yet implemented");
	}

}
