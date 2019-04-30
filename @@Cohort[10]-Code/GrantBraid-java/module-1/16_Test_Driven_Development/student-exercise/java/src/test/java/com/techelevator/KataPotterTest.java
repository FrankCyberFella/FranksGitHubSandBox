package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataPotterTest {
	

	@Test
	public void purchaseOneBook() {
		assertEquals("expected $8 for purchasing only one book",8.0, KataPotter.getCost(new int[] {0,1,0,0,0}));
	}

}
