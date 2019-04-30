package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	@Test 
	public void Does_Numbers_1_Thru_100_Return_Its_Value() {
		KataFizzBuzz tester = new KataFizzBuzz(1);
		assertEquals("Does not return number as String", "2", tester.fizzBuzz(2));
	}
	
	@Test 
	public void Testing_Multiples_Of_Three_And_Contains_Three() {
		KataFizzBuzz tester = new KataFizzBuzz(1);
		assertEquals("3 Does not return Fizz for multiple of 3", "Fizz", tester.fizzBuzz(3));
		assertEquals("37 Does not return Fizz for multiple of 3 & contains 3", "Fizz", tester.fizzBuzz(37));
		assertEquals("13 Does not return Fizz for multiple of 3 & contains 3", "Fizz", tester.fizzBuzz(13));

	}
	
	@Test 
	public void Testing_Multiples_Of_Five_And_Contains_Five() {
		KataFizzBuzz tester = new KataFizzBuzz(1);
		assertEquals("5 Does not return Buzz for multiple of 5 & contains 5", "Buzz", tester.fizzBuzz(5));
		assertEquals("10 Does not return Buzz for multiple of 5 & contains 5", "Buzz", tester.fizzBuzz(10));
		assertEquals("55 Does not return Buzz for multiple of 5 & contains 5", "Buzz", tester.fizzBuzz(55));
	}
	
	@Test 
	public void Testing_Multiples_Of_Five_And_Three() {
		KataFizzBuzz tester = new KataFizzBuzz(1);
		assertEquals("15 Does not return FizzBuzz? for multiple of 5 & multiple of 3", "FizzBuzz?", tester.fizzBuzz(15));
		assertEquals("30 Does not return FizzBuzz? for multiple of 5 & multiple of 3", "FizzBuzz?", tester.fizzBuzz(30));
		assertEquals("40 Does not return FizzBuzz? for multiple of 5 & multiple of 3", "FizzBuzz?", tester.fizzBuzz(60));
	}
	
	@Test 
	public void Testing_Numbers_Outside_Of_Range_1_To_100() {
		KataFizzBuzz tester = new KataFizzBuzz(1);
		assertEquals("0 Does not return empty String", "", tester.fizzBuzz(0));
		assertEquals("101 Does not return empty String", "", tester.fizzBuzz(101));
	}
	
	
}
