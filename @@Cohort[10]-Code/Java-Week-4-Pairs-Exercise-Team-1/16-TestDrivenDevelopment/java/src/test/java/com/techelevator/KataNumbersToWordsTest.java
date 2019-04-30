package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataNumbersToWordsTest {
	
	@Test
	public void Test_One_Digit_To_Words() {
		assertEquals("Digit did not convert to words", "seven", new KataNumbersToWords().conversion(7));
	}
	@Test
	public void Test_Two_Digit_Teens_To_Words() {
		assertEquals("Two digit teen number failed","fourteen", new KataNumbersToWords().conversion(14));
	}
	@Test
	public void Test_Multiples_of_Tens() {
		assertEquals("Two digit multiple of ten failed","eighty", new KataNumbersToWords().conversion(80));
	}
	
	@Test
	public void Test_Any_Two_Digit() {
		assertEquals("Any two digit to words failed","forty-two", new KataNumbersToWords().conversion(42));
	}
	
	@Test
	public void Test_Three_Digit() {
		assertEquals("Three digit multiple of one hundred failed", "three hundred", new KataNumbersToWords().conversion(300));
		assertEquals("Three digit failed", "two hundred and nine", new KataNumbersToWords().conversion(209));
		assertEquals("Three digit multiple of one hundred failed", "four hundred and ninety-eight", new KataNumbersToWords().conversion(498));
	}
	
	
}
