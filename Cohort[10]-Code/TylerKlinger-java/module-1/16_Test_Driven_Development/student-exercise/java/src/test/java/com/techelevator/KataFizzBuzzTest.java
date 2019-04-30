package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	
	@Test
	public void return_not_divisible_by_3_or_5() {
		assertEquals("String does not return 1, son", "1", KataFizzBuzz.fizzBuzz(1));
		assertEquals("String does not return 2, son", "2", KataFizzBuzz.fizzBuzz(2));
		assertEquals("String does not return 4, son", "4", KataFizzBuzz.fizzBuzz(4));
	}

	@Test
	public void returns_fizz() {
		assertEquals("String does not return fizz, sir", "fizz", KataFizzBuzz.fizzBuzz(9));
		assertEquals("String does not return fizz, sir", "fizz", KataFizzBuzz.fizzBuzz(33));
	}
	@Test
	public void returns_buzz() {
		assertEquals("String does not return buzz, homie", "buzz", KataFizzBuzz.fizzBuzz(10));
		assertEquals("String does not return buzz, homie", "buzz", KataFizzBuzz.fizzBuzz(50));
	}
	@Test
	public void returns_fizzbuzz() {
		assertEquals("String does not return fizzbuzz 1, jack", "fizzbuzz", KataFizzBuzz.fizzBuzz(90));
		assertEquals("String does not return fizzbuzz 2, jack", "fizzbuzz", KataFizzBuzz.fizzBuzz(60));
	}
	@Test
	public void passed_in_0() {
		assertEquals("String does not return 0, cuz", "0", KataFizzBuzz.fizzBuzz(0));
	}
	@Test
	public void passed_in_greater_than_0() {
		assertEquals("String does not return empty string, brother", "", KataFizzBuzz.fizzBuzz(101));
		assertEquals("String does not return empty string, brother", "", KataFizzBuzz.fizzBuzz(102));
	}
	
	@Test 
	public void contains_3() {
		assertEquals("String does not contain a 3, fool", "fizz", KataFizzBuzz.fizzBuzz(43));
		assertEquals("String does not contain a 3, fool", "fizz", KataFizzBuzz.fizzBuzz(13));
	}
	@Test 
	public void contains_5() {
		assertEquals("String does not contain a 5, boyee", "buzz", KataFizzBuzz.fizzBuzz(52));
		assertEquals("String does not contain a 5, boyee", "buzz", KataFizzBuzz.fizzBuzz(55));
	}
}
