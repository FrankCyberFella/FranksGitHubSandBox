package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {

	@Test 
	public void Does_Empty_String_Return_0() {
		KataStringCalculator tester = new KataStringCalculator("");

		assertEquals("Does not return 0", 0, tester.add(""));
	}
	
	@Test 
	public void Adding_Two_Strings( ) {
		KataStringCalculator tester = new KataStringCalculator("");
		assertEquals("Does not return sum", 14, tester.add("13,1"));
	}
	
	@Test 
	public void Adding_Multiple_Strings( ) {
		KataStringCalculator tester = new KataStringCalculator("");
		assertEquals("Does not return sum", 20, tester.add("13,1,2,4"));
	}
	
	@Test 
	public void Adding_Multiple_Strings_With_New_Lines( ) {
		KataStringCalculator tester = new KataStringCalculator("");
		assertEquals("Does not return sum", 14, tester.add("13\n1"));
		assertEquals("Does not return sum", 20, tester.add("13,2\n1\n4"));
	}
	
//	@Test 
//	public void Adding_Multiple_Strings_Supporting_Multiple_Delimeters( ) {
//		KataStringCalculator tester = new KataStringCalculator("");
//		assertEquals("Does not return sum", 3, tester.add("//!\n1;2"));
//	}
}
