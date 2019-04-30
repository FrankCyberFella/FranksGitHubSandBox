package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	
	@Test
	public void TestThatNumbersAreCorrectlyConvertedToStrings() {
	
		assertEquals("Did not return correct String value converted from int input", "1", new KataFizzBuzz(0).fizzBuzz(1));

	}
	
	@Test
	public void TestThatReturnsEmptyStringWhenGivenNumbersOutOfBoundsZeroTo100() {
	
		assertEquals("Did not return correct String value converted from int input", "", new KataFizzBuzz(0).fizzBuzz(-1));

	}
	
	@Test
	public void TestThatReturnsFizzWhenMultipleOfThree() {
	
		assertEquals("Did not return Fizz when input is a multiple of Three", "Fizz", new KataFizzBuzz(0).fizzBuzz(3));
		assertEquals("Did not return Fizz when input is a multiple of Three", "Fizz", new KataFizzBuzz(0).fizzBuzz(9));
	}
	
	@Test
	public void TestThatReturnsBuzzWhenMultipleOfFive() {
	
		assertEquals("Did not return Fizz when input is a multiple of Three", "Buzz", new KataFizzBuzz(0).fizzBuzz(5));
		assertEquals("Did not return Fizz when input is a multiple of Three", "Buzz", new KataFizzBuzz(0).fizzBuzz(20));
	}
	
	@Test
	public void TestThatReturnsFizzBuzzWhenMultipleOfThreeAndFive() {
	
		assertEquals("Did not return Fizz when input is a multiple of Three", "FizzBuzz", new KataFizzBuzz(0).fizzBuzz(15));
		assertEquals("Did not return Fizz when input is a multiple of Three", "FizzBuzz", new KataFizzBuzz(0).fizzBuzz(30));
	}
	
	@Test
	public void TestThatReturnsFizzOrBuzzWhenThreeOrFiveExist() {
	
		assertEquals("Did not return Fizz when input is a multiple of Three", "Fizz", new KataFizzBuzz(0).fizzBuzz(31));
		assertEquals("Did not return Fizz when input is a multiple of Three", "Buzz", new KataFizzBuzz(0).fizzBuzz(52));
	}

}
