package com.techelevator;

import org.junit.*; 
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	
	@Test
	public void Test_That_Returns_Empty_Quotes_When_Number_Is_Out_Of_Bounds() {
		KataFizzBuzz test = new KataFizzBuzz(1);
		assertEquals("Failed to return empty quotes when number out of bounds was given", "", test.fizzBuzz(101));
		assertEquals("Failed to return empty quotes when number out of bounds was given", "", test.fizzBuzz(0));
	}   
	
	@Test
	public void Test_That_Returns_Same_Number_When_Not_Fizz_Or_Buzz() {
		KataFizzBuzz test = new KataFizzBuzz(1);
		assertEquals("Failed to return same number when number does not equal or contain 3 or 5", String.valueOf(7), test.fizzBuzz(7));
		assertEquals("Failed to return same number when number does not equal or contain 3 or 5", String.valueOf(11), test.fizzBuzz(11));
	}
	
	@Test
	public void Test_That_Returns_Fizz_When_Three_And_Buzz_When_Five() {
		KataFizzBuzz test = new KataFizzBuzz(1);
		assertEquals("Failed to return Fizz when 3 was given", "Fizz", test.fizzBuzz(3));
		assertEquals("Failed to return Buzz when 5 was given", "Buzz", test.fizzBuzz(5)); 
	}  
	
	@Test
	public void Test_That_Returns_FizzBuzz_When_Num_Divisible_By_3_And_5() {
		KataFizzBuzz test = new KataFizzBuzz(1);
		assertEquals("Failed to return FizzBuzz when number divisible by 3 and 5 was given", "FizzBuzz", test.fizzBuzz(15));
		assertEquals("Failed to return FizzBuzz when number divisible by 3 and 5 was given", "FizzBuzz", test.fizzBuzz(30)); 
		assertEquals("Failed to return FizzBuzz when number divisible by 3 and 5 was given", "FizzBuzz", test.fizzBuzz(45)); 
	}

}
