package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	@Test
	public void Return_Number_As_String() {
		assertEquals("Did not return the correct string, expected 1", "1", new KataFizzBuzz().fizzBuzz(1));
		assertEquals("Did not return the correct string, expected 2", "2", new KataFizzBuzz().fizzBuzz(2));
		assertEquals("Did not return the correct string, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(3));
		assertEquals("Did not return the correct string, expected 4", "4", new KataFizzBuzz().fizzBuzz(4));
	}
	
	@Test
	public void Return_Empty_String_If_Number_Is_Out_Of_Bounds() {
		assertEquals("Did not return the correct string, expected \" \" ", "", new KataFizzBuzz().fizzBuzz(0));
		assertEquals("Did not return the correct string, expected \" \" ", "", new KataFizzBuzz().fizzBuzz(104));
		assertEquals("Did not return the correct string, expected \" \" ", "", new KataFizzBuzz().fizzBuzz(-5));
		assertEquals("Did not return the correct string, expected \" \" ", "", new KataFizzBuzz().fizzBuzz(125));
	}
	
	@Test
	public void Return_Fizz_Buzz_FizzBuzz() {
		assertEquals("Did not return the correct string, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(3));
		assertEquals("Did not return the correct string, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(5));
		assertEquals("Did not return the correct string, expected FizzBuzz", "FizzBuzz", new KataFizzBuzz().fizzBuzz(30));
		assertEquals("Did not return the correct string, expected \" \"", "", new KataFizzBuzz().fizzBuzz(125));
	}
	
	@Test
	public void Return_Fizz_Buzz_If_Has_3_Or_5_In_It() {
		assertEquals("Did not return the correct string, expected Fizz", "Fizz", new KataFizzBuzz().fizzBuzz(33));
		assertEquals("Did not return the correct string, expected Buzz", "Buzz", new KataFizzBuzz().fizzBuzz(52));
		assertEquals("Did not return the correct string, expected FizzBuzz", "FizzBuzz", new KataFizzBuzz().fizzBuzz(30));
		assertEquals("Did not return the correct string, expected \" \"", "", new KataFizzBuzz().fizzBuzz(125));
	}
}
