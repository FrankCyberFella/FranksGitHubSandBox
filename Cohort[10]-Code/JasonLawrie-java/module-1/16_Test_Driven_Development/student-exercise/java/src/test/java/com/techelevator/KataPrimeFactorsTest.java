package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataPrimeFactorsTest {

	
	@Test
	public void Test_Single_Digit_Primes() {
		assertArrayEquals("Prime should only have itself",new int[] {7},new KataPrimeFactors().factorize(7));
	}
	
	@Test
	public void Test_Known_Two_Factor_Int() {
		assertArrayEquals("There should be two prime factors",new int[] {2,5},new KataPrimeFactors().factorize(10));
	}
	
	@Test
	public void  Test_Known_Repeat_Factor_Int() {
		assertArrayEquals("There should be three threes",new int[] {3,3,3},new KataPrimeFactors().factorize(27));
	}
	
	@Test
	public void Test_Lets_Go_Crazy() {
		assertArrayEquals("",new int[] {2,3,7,7,11},new KataPrimeFactors().factorize(2*3*7*7*11));
	}
}
