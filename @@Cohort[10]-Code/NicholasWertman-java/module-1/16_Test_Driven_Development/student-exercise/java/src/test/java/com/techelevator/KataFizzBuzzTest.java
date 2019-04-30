package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	@Test
	public void This_Test_Should_Return_Empty_String() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return an empty string", "", tester.fizzBuzz(0));
		assertEquals("This test did not return an empty string", "", tester.fizzBuzz(101));
	}

	@Test
	public void This_Test_Should_Return_Fizz() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return Fizz", "Fizz", tester.fizzBuzz(3));
	}

	@Test
	public void This_Test_Should_Return_Buzz() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return an Buzz", "Buzz", tester.fizzBuzz(5));
	}

	@Test
	public void This_Test_Should_Return_FizzBuzz() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return an FizzBuzz", "FizzBuzz", tester.fizzBuzz(15));
	}
	
	@Test
	public void This_Test_Should_Return_Integer_As_String() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return integer in string", "7", tester.fizzBuzz(7));
	}
	
	@Test
	public void This_Test_Should_Return_Fizz_Contains_3() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return integer in string", "Fizz", tester.fizzBuzz(73));
	
}
	
	@Test
	public void This_Test_Should_Return_Buzz_Contains_5() {
		KataFizzBuzz tester = new KataFizzBuzz();
		assertEquals("This test did not return integer in string", "Buzz", tester.fizzBuzz(52));
		
	}
	
	
}
