package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	@Test
	public void testFizzBuzz_notDivisible_by_3_or_5() {
		assertEquals("input 1 and expecetd 1","1",KataFizzBuzz.fizzBuzz(1));
		assertEquals("input 2 and expecetd 2","2",KataFizzBuzz.fizzBuzz(2));	
		assertEquals("input 4 and expecetd 4","4",KataFizzBuzz.fizzBuzz(4));	
}

	@Test
	public void testFizzBuzz_Fizz() {
		assertEquals("input number and expected Fizz", "Fizz",KataFizzBuzz.fizzBuzz(3));
		assertEquals("input number and expected Fizz", "Fizz",KataFizzBuzz.fizzBuzz(9));
	}
	
	@Test
	public void tesFizzBuzz_Buzz() {
		assertEquals("input number and expected Buzz", "Buzz", KataFizzBuzz.fizzBuzz(5));
		assertEquals("input number and expected Buzz", "Buzz", KataFizzBuzz.fizzBuzz(20));
	}
	@Test
	public void testFizzBuzz_FizzBuzz() {
		assertEquals("input number and expected FizzBuzz", "FizzBuzz", KataFizzBuzz.fizzBuzz(15));
		assertEquals("input number and expected FizzBuzz", "FizzBuzz", KataFizzBuzz.fizzBuzz(60));
	}
	@Test
	public void testFizzBuzz_Not_In_Range() {
		assertEquals("input number should not be in range","", KataFizzBuzz.fizzBuzz(-10));
		assertEquals("input number should not be in range","", KataFizzBuzz.fizzBuzz(150));
	}
	@Test
	public void testFizzBuzz_Zero() {
		assertEquals("Expected 0","0",KataFizzBuzz.fizzBuzz(0));
	}
	
	@Test
	public void containsThree() {
		assertEquals("Expected Fizz when given 31" , "Fizz", KataFizzBuzz.fizzBuzz(13));
		assertEquals("Expected Fizz when given 34" , "Fizz", KataFizzBuzz.fizzBuzz(34));
	}
	
	@Test
	public void containsFive() {
		assertEquals("Expected Buzz when given 53" , "FizzBuzz", KataFizzBuzz.fizzBuzz(53));
		assertEquals("Expected Buzz when given 51" , "Buzz", KataFizzBuzz.fizzBuzz(56));
	}
	
}
