package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	
	@Test
	public void Convert_Single_Digit_To_String() {
		assertEquals("Did not equal number as string", "4", new KataFizzBuzz().convert(4));
		assertEquals("Did not equal Buzz as string", "Buzz", new KataFizzBuzz().convert(5));
		assertEquals("Did not equal Fizz as string", "Fizz", new KataFizzBuzz().convert(3));
		assertEquals("Did not equal FizzBuzz as string", "FizzBuzz", new KataFizzBuzz().convert(15));
		assertEquals("Did not equal FizzBuzz as string", "FizzBuzz", new KataFizzBuzz().convert(90));
		assertEquals("Did not equal Fizz as string", "Fizz", new KataFizzBuzz().convert(31));
		assertEquals("Did not equal Buzz as string", "Buzz", new KataFizzBuzz().convert(51));
		assertEquals("Did not equal Fizz as string", "Fizz", new KataFizzBuzz().convert(99));
		assertEquals("Did not equal 98 as string", "98", new KataFizzBuzz().convert(98));
		assertEquals("Did not equal Buzz as string", "Buzz", new KataFizzBuzz().convert(95));
		assertEquals("Did not equal (blank) as string", "", new KataFizzBuzz().convert(101));
		assertEquals("Did not equal (blank) as string", "", new KataFizzBuzz().convert(0));
	}

}
