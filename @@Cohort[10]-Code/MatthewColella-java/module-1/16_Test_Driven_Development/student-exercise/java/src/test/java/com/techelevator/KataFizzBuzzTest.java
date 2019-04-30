package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	@Test
	public void ifNumberIsOutsideRange() {
		assertEquals("0 was passed in, expected empty string", "", new KataFizzBuzz().fizzBuzz(0));
		assertEquals("101 was passed in, expected empty string", "", new KataFizzBuzz().fizzBuzz(101));
	}

	@Test
	public void ifNumberDivisibleBy3Only() {
		assertEquals("6 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(6));
		assertEquals("9 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(9));
		assertEquals("48 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(48));
		assertEquals("99 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(99));
	}
	
	@Test
	public void ifNumberDivisibleBy5Only() {
		assertEquals("10 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(10));
		assertEquals("20 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(20));
		assertEquals("65 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(65));
		assertEquals("95 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(95));
	}
	
	@Test
	public void ifNumberDivisibleBy3And5() {
		assertEquals("15 was passed in, expected FizzBuzz", "FizzBuzz", new KataFizzBuzz().fizzBuzz(15));
		assertEquals("45 was passed in, expected FizzBuzz", "FizzBuzz", new KataFizzBuzz().fizzBuzz(45));
		assertEquals("60 was passed in, expected FizzBuzz", "FizzBuzz", new KataFizzBuzz().fizzBuzz(60));
		assertEquals("90 was passed in, expected FizzBuzz", "FizzBuzz", new KataFizzBuzz().fizzBuzz(90));
	}
	
	@Test
	public void ifNumberStartsWith3() {
		assertEquals("3 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(3));
		assertEquals("35 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(35));
		assertEquals("32 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(32));
		assertEquals("38 was passed in, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(38));
	}
	
	@Test
	public void ifNumberStartsWith5() {
		assertEquals("5 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(5));
		assertEquals("55 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(55));
		assertEquals("52 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(52));
		assertEquals("58 was passed in, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(58));
	}
	
}