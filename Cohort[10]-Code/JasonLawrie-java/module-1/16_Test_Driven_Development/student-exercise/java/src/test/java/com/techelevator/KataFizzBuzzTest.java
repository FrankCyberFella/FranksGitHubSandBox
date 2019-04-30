package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	@Test
	public void Test_Edge_Cases() {
		assertEquals("0 is not in range","",new KataFizzBuzz().fizzBuzz(0));
		assertEquals("101 is not in range","",new KataFizzBuzz().fizzBuzz(101));
	}
	
	@Test
	public void Test_Fizzes() {
		assertEquals("9 should be Fizz","Fizz",new KataFizzBuzz().fizzBuzz(9));
		assertEquals("93 should be Fizz","Fizz",new KataFizzBuzz().fizzBuzz(93));
	}
	
	@Test
	public void Test_Buzzes() {
		assertEquals("20 should be Buzz","Buzz",new KataFizzBuzz().fizzBuzz(20));
		assertEquals("35 should be Buzz","Buzz",new KataFizzBuzz().fizzBuzz(35));
	}
	
	@Test
	public void Test_FizzBuzzes() {
		assertEquals("15 should be FizzBuzz","FizzBuzz",new KataFizzBuzz().fizzBuzz(15));
		assertEquals("75 should be FizzBuzz","FizzBuzz",new KataFizzBuzz().fizzBuzz(75));
	}
}
