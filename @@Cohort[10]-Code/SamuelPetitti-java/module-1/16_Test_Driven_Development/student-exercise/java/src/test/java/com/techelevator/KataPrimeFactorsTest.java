package com.techelevator;

import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class KataPrimeFactorsTest {
	@Test
	public void kata_Prime_Factors_Test_2() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2) , new KataPrimeFactors().factorize(2));
	}
	@Test
	public void kata_Prime_Factors_Test_3() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(3) , new KataPrimeFactors().factorize(3));
	}
	@Test
	public void kata_Prime_Factors_Test_2_2() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2,2), new KataPrimeFactors().factorize(4));
	}
	@Test
	public void kata_Prime_Factors_Test_2_3() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2, 3) , new KataPrimeFactors().factorize(6));
	}
	@Test
	public void kata_Prime_Factors_Test_7() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(7), new KataPrimeFactors().factorize(7));
	}
	@Test
	public void kata_Prime_Factors_Test_7_2_2() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2,2,2) , new KataPrimeFactors().factorize(8));
	}
	@Test
	public void kata_Prime_Factors_Test_3_3() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(3,3) , new KataPrimeFactors().factorize(9));
	}
	@Test
	public void kata_Prime_Factors_Test_2_5() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2, 5) , new KataPrimeFactors().factorize(10));
	}
	@Test
	public void kata_Prime_Factors_Test_2_2_2_2_2_3() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2, 2, 2, 2, 2,3) , new KataPrimeFactors().factorize(96));
	}
	@Test
	public void kata_Prime_Factors_Test_2_7_23() {
	Assert.assertEquals("That is not the expected result", Arrays.asList(2, 7, 23) , new KataPrimeFactors().factorize(322));
	}
	
	
	
	

}

//Factorize a positive integer number into its prime factors.
//Use the TDD approach to write tests that call a single method factorize(). Given a positive integer input n, return its prime factors.
//1 is always omitted from the result set.
//Sample Output
//2 -> returns [2]
//3 -> returns [3]
//4 -> returns [2, 2]
//6 -> returns [2, 3]
//7 -> returns [7]
//8 -> returns [2, 2, 2]
//9 -> returns [3, 3]
//10 -> returns [2, 5]