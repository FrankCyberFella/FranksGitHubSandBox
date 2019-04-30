package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	KataFizzBuzz numToString = new KataFizzBuzz();
	
	@Test
	public void intToStringTest() {
		Assert.assertEquals("Unexpected result.", "", numToString.fizzBuzz(0));
		Assert.assertEquals("Unexpected result.", "1", numToString.fizzBuzz(1));
		Assert.assertEquals("Unexpected result.", "2", numToString.fizzBuzz(2));
		Assert.assertEquals("Unexpected result.", "Fizz", numToString.fizzBuzz(3));
		Assert.assertEquals("Unexpected result.", "4", numToString.fizzBuzz(4));
		Assert.assertEquals("Unexpected result.", "Buzz", numToString.fizzBuzz(5));
		Assert.assertEquals("Unexpected result.", "FizzBuzz", numToString.fizzBuzz(15));
		Assert.assertEquals("Unexpected result.", "", numToString.fizzBuzz(101));
		Assert.assertEquals("Unexpected result.", "", numToString.fizzBuzz(0));
		Assert.assertEquals("Unexpected result.", "Fizz", numToString.fizzBuzz(31));
		Assert.assertEquals("Unexpected result.", "Buzz", numToString.fizzBuzz(52));
		Assert.assertEquals("Unexpected result.", "FizzBuzz", numToString.fizzBuzz(57));
	}
	
}
