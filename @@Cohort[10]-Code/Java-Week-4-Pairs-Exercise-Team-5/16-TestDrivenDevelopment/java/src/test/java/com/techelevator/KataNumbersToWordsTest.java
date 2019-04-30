package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataNumbersToWordsTest {
	
	@Test
	public void returns_one_digit_number_to_word() {
		assertEquals("Does not return zero", "zero", KataNumbersToWords.numberToWords(0));
		assertEquals("Does not return seven", "seven", KataNumbersToWords.numberToWords(7));
	}
	@Test
	public void returns_two_digit_number_to_word() {
		assertEquals("Does not return thirty-five", "thirty-five", KataNumbersToWords.numberToWords(35));
		assertEquals("Does not return nineteen", "seventy-three", KataNumbersToWords.numberToWords(73));
		assertEquals("Does not return twelve", "twelve", KataNumbersToWords.numberToWords(12));
	}
	@Test
	public void returns_three_digit_number_to_word() {
		assertEquals("Does not return three hundred and thirty-three", "three hundred and thirty-three", KataNumbersToWords.numberToWords(333));
		//assertEquals("Does not return nineteen", "seventy-three", KataNumbersToWords.numberToWords(73));
		//assertEquals("Does not return twelve", "twelve", KataNumbersToWords.numberToWords(12));
	
	}
}
