package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataPrimeFactorsTest {
	
	KataPrimeFactors num = new KataPrimeFactors();

	public void primeFactorsTest() {
		
		Assert.assertEquals("Unexpected result.", 2, num.factorize(2));
		Assert.assertEquals("Unexpected result.", 3, num.factorize(3));
		Assert.assertEquals("Unexpected result.", new int[] {2,2}, num.factorize(4));
		Assert.assertEquals("Unexpected result.", new int[] {2,3}, num.factorize(6));
		Assert.assertEquals("Unexpected result.", 7, num.factorize(7));
		Assert.assertEquals("Unexpected result.", new int[] {2,2,2}, num.factorize(8));
		Assert.assertEquals("Unexpected result.", new int[] {3,3}, num.factorize(9));
		Assert.assertEquals("Unexpected result.", new int[] {2,5}, num.factorize(10));
		
	}
}
