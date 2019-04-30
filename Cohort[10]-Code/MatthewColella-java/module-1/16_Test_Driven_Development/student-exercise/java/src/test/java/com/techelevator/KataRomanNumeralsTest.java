package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataRomanNumeralsTest {

	@Test
	public void ifNumberIsOutsideRange() {
		assertEquals("0 was passed in, expected empty string", "", new KataFizzBuzz().fizzBuzz(0));
		assertEquals("101 was passed in, expected empty string", "", new KataFizzBuzz().fizzBuzz(101));
	}
}
