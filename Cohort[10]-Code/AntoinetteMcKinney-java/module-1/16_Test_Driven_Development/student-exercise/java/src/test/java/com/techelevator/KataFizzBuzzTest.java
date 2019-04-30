package com.techelevator;

import org.junit.*;

public class KataFizzBuzzTest {

	@Test
	public void FizzBuzzAnyNumber() {
		Assert.assertEquals("This is not the answer", "1", new KataFizzBuzz().fizzBuzz(1));// method is fizzBuzz
	}

	@Test
	public void FizzBuzzMultipleOf3() {
		Assert.assertEquals("This is not the answer", "Fizz", new KataFizzBuzz().fizzBuzz(9));// method is fizzBuzz

	}

	@Test
	public void FizzBuzzMultipleOf5() {
		Assert.assertEquals("This is not the answer", "Buzz", new KataFizzBuzz().fizzBuzz(10));
	}

	@Test
	public void FizzBuzzMultiple3And5() {
		Assert.assertEquals("This is not the answer", "FizzBuzz?", new KataFizzBuzz().fizzBuzz(15));

	}
}
