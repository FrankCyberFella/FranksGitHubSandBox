package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {

	@Test
	public void takingInZeroNumbers() {
		assertEquals("Did not properly add, expected: 0", 0, new KataStringCalculator().add(""));
	}

	@Test
	public void takingInOneNumber() {
		assertEquals("Did not properly add, expected: 1", 1, new KataStringCalculator().add("1"));
		assertEquals("Did not properly add, expected: 2", 2, new KataStringCalculator().add("2"));
		assertEquals("Did not properly add, expected: 3", 3, new KataStringCalculator().add("3"));
		assertEquals("Did not properly add, expected: 4", 4, new KataStringCalculator().add("4"));
	}

	@Test
	public void takingInTwoNumbers() {
		assertEquals("Did not properly add, expected: 3", 3, new KataStringCalculator().add("1,2"));
		assertEquals("Did not properly add, expected: 5", 5, new KataStringCalculator().add("2,3"));
		assertEquals("Did not properly add, expected: 7", 7, new KataStringCalculator().add("3,4"));
		assertEquals("Did not properly add, expected: 9", 9, new KataStringCalculator().add("4,5"));
	}

	@Test
	public void takingInMoreThanOneNumbers() {
		assertEquals("Did not properly add, expected: 6", 6, new KataStringCalculator().add("1,2,3"));
		assertEquals("Did not properly add, expected: 5", 5, new KataStringCalculator().add("2,3"));
		assertEquals("Did not properly add, expected: 5", 5, new KataStringCalculator().add("1,1,1,1,1"));
		assertEquals("Did not properly add, expected: 10", 10, new KataStringCalculator().add("4,5,0,0,1"));
	}
	
	@Test
	public void takingInNumbersSeparatedByNewLines() {
		assertEquals("Did not properly add, expected: 6", 6, new KataStringCalculator().add("1\n2,3"));
		assertEquals("Did not properly add, expected: 11", 11, new KataStringCalculator().add("2,3\n6"));
		assertEquals("Did not properly add, expected: 5", 5, new KataStringCalculator().add("1\n1,1\n1,1"));
		assertEquals("Did not properly add, expected: 10", 10, new KataStringCalculator().add("4\n5,0\n0,1"));
	}
}