package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {
	@Test 
	public void Calculator_Zero_Numbers()  {
		Assert.assertEquals("That is not the expected result.", 0, new KataStringCalculator().add(""));
	}
	
	@Test 
	public void Calculator_One_Number()  {
		Assert.assertEquals("That is not the expected result.", 1, new KataStringCalculator().add("1"));
		Assert.assertEquals("That is not the expected result.", 11, new KataStringCalculator().add("11"));
	}
	
	@Test 
	public void Calculator_Tw0_Number()  {
		Assert.assertEquals("That is not the expected result.", 2, new KataStringCalculator().add("1,1"));
		Assert.assertEquals("That is not the expected result.", 60, new KataStringCalculator().add("30,30"));
		
	
}
	@Test 
	public void Calculator_NewLineInNumbers_Number()  {
		Assert.assertEquals("That is not the expected result.", 10, new KataStringCalculator().add("5\n1,4"));
		Assert.assertEquals("That is not the expected result.", 60, new KataStringCalculator().add("30\n1,29"));
		
	}

	/*
	 * 1. Created a For Loop to search the getChar[] array for all numbers. 2.
	 * Search char array for all numbers and put in getnums array.
	 * 
	 */
	//@Test
		/*public void test() {
			for(int i=0; i< numbers.length(); i++){
				int getNumsPosition = 0; 
			}
			*/
		
}


