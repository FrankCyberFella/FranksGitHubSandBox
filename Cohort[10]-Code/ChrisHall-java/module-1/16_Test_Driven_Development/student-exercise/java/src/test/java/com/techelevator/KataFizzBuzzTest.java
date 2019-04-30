package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	KataFizzBuzz input = new KataFizzBuzz();
	
@Test
	public void SimpleTest() {
		Assert.assertEquals("Unexpected value", "1", input.fizzBuzz(1));
		Assert.assertEquals("Unexpected value", "2", input.fizzBuzz(2));
		Assert.assertEquals("Unexpected value", "Fizz", input.fizzBuzz(3));
		Assert.assertEquals("Unexpected value", "4", input.fizzBuzz(4));
		Assert.assertEquals("Unexpected value", "Buzz", input.fizzBuzz(5));
		Assert.assertEquals("Unexpected value", "Fizz", input.fizzBuzz(12));
		Assert.assertEquals("Unexpected value", "FizzBuzz", input.fizzBuzz(60));
		Assert.assertEquals("Unexpected value", "61", input.fizzBuzz(61));
		Assert.assertEquals("Value out of range", "", input.fizzBuzz(102));
	}
	
	/*
	 * @Test public void OrContains() { Assert.
	 * assertEquals("Does not contain and/or is not divisible by required values ",
	 * 22, input.fizzBuzz(22));
	 * 
	 * 
	 * }
	 */
}

//   Note:  could not get part 2 finished.  