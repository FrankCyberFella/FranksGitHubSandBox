package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {
	
	@Test
	public void TestThatReturnIsZeroWhenGivenEmptyString() {
		
		assertEquals("Failed to return 0 when given an empty string", 0, new KataStringCalculator("test").add(""));
		
	}
	
	@Test
	public void TestToGetCorrectNumberReturnForOneDigit() {
		
		assertEquals("Failed to correctly return given value when given one digit", 1, new KataStringCalculator("test").add("1"));
		assertEquals("Failed to correctly return given value when given one digit", 4, new KataStringCalculator("test").add("4"));
		assertEquals("Failed to correctly return given value when given one digit", 14, new KataStringCalculator("test").add("14"));
	}
	
	@Test
	public void TestToGetCorrectNumberReturnForTwoDigits() {
		
		assertEquals("Failed to correctly return given value when given two digits", 2, new KataStringCalculator("test").add("1,1"));
		assertEquals("Failed to correctly return given value when given two digits", 3, new KataStringCalculator("test").add("1,2"));
		assertEquals("Failed to correctly return given value when given two digits", 10, new KataStringCalculator("test").add("5,5"));
	}
	
	@Test
	public void TestToGetCorrectSumForUnknownAmountOfDigits() {
		
		assertEquals("Failed to correctly return given value when given three digits", 13, new KataStringCalculator("test").add("1,7,5"));
		assertEquals("Failed to correctly return given value when given four digits", 15, new KataStringCalculator("test").add("1,2,12"));
		assertEquals("Failed to correctly return given value when given nine digits", 42, new KataStringCalculator("test").add("5,5,9,1,6,7,4,3,2"));
	}
	
	@Test
	public void TestToHandleNewLineEscapeCharacterAsWellAsCommas() {
		
		assertEquals("Failed to correctly return given value when given three digits", 6, new KataStringCalculator("test").add("1\n2,3"));
		assertEquals("Failed to correctly return given value when given four digits", 14, new KataStringCalculator("test").add("3\n5\n2,4"));
		
	}
}
