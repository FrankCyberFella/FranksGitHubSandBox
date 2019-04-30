package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	@Test
	public void Fizz_Buzz_Test_1() {
		Assert.assertEquals("That is not the expected result", "1", new KataFizzBuzz().fizzBuzz(1));
	}
	@Test
	public void Fizz_Buzz_Test_52() {
		Assert.assertEquals("That is not the expected result", "22", new KataFizzBuzz().fizzBuzz(22));
	}
	@Test
	public void Fizz_Buzz_Test_0() {
		Assert.assertEquals("That is not the expected result", "", new KataFizzBuzz().fizzBuzz(0));
	}
	@Test
	public void Fizz_Buzz_Test_101() {
		Assert.assertEquals("That is not the expected result", "", new KataFizzBuzz().fizzBuzz(101));
	}
	@Test
	public void Fizz_Buzz_Test_Divisible_By3() {
		Assert.assertEquals("That is not the expected result", "Fizz", new KataFizzBuzz().fizzBuzz(12));
		Assert.assertEquals("That is not the expected result", "Fizz", new KataFizzBuzz().fizzBuzz(33));
	}
	
	@Test
	public void Fizz_Buzz_Test_Has3_in_Num() {
		Assert.assertEquals("That is not the expected result", "Fizz", new KataFizzBuzz().fizzBuzz(13));
		Assert.assertEquals("That is not the expected result", "Fizz", new KataFizzBuzz().fizzBuzz(73));
	}
	@Test
	public void Fizz_Buzz_Test_Divisible_By5() {
		Assert.assertEquals("That is not the expected result", "Buzz", new KataFizzBuzz().fizzBuzz(25));
		Assert.assertEquals("That is not the expected result", "Buzz", new KataFizzBuzz().fizzBuzz(65));
	}
	@Test
	public void Fizz_Buzz_Test_Divisible_By3_and_5() {
		Assert.assertEquals("That is not the expected result", "FizzBuzz", new KataFizzBuzz().fizzBuzz(15));
		Assert.assertEquals("That is not the expected result", "FizzBuzz", new KataFizzBuzz().fizzBuzz(75));
	}
	@Test 
	public void Fizz_Buzz_Test_Has_5() {
		Assert.assertEquals("That is not the expected result", "Buzz", new KataFizzBuzz().fizzBuzz(55));
		Assert.assertEquals("That is not the expected result", "Buzz", new KataFizzBuzz().fizzBuzz(95));
	}
	
	
	@Test
	public void Fizz_Buzz_Test_has3_and5() {
		Assert.assertEquals("That is not the expected result", "FizzBuzz", new KataFizzBuzz().fizzBuzz(35));
		Assert.assertEquals("That is not the expected result", "FizzBuzz", new KataFizzBuzz().fizzBuzz(53));
	}
	
	
}

//Write a program that returns numbers as Strings, but only if the number is between 1 and 100. 
//But for multiples of three return "Fizz" instead of the number and for the multiples of five return "Buzz".
//For numbers which are multiples of both three and five return "FizzBuzz?".
//Write tests that call a single methodString fizzBuzz(int number).
//Given a positive integer input n, return the FizzBuzz output as a string.
