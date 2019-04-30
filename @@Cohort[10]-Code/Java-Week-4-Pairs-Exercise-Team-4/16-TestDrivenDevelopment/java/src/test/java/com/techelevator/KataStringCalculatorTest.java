package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {
	
	KataStringCalculator input = new KataStringCalculator();
	
	@Test
	public void simpleInputTest() {
		
		Assert.assertEquals("Unexpected result.", 0, input.add("0"));
		Assert.assertEquals("Unexpected result.", 1, input.add("1"));
		Assert.assertEquals("Unexpected result.", 3, input.add("1,2"));
		
	}
	
	@Test
	public void simpleThreeNumberAdd() {
		Assert.assertEquals("Unexpected sum.", 18, input.add("3,6,9"));
		
	}
	
	@Test
	public void newLineCharacterTest() {
		Assert.assertEquals("Unexpected character.", 10, input.add("4\n5,1"));
	}
}
