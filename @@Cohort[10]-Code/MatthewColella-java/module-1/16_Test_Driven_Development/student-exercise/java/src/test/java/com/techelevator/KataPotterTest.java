package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataPotterTest {

	@Test
	public void ifAddingCorrectly() {
		assertEquals(" 1 of Book 1, 1 of Book 2, 1 of Book 3, 1 of Book 4, 1 of Book 5, expected 40.00", "40.00",
				KataPotter.cartPrice(1, 1, 1, 1, 1));
		assertEquals(" 0 of Book 1, 1 of Book 2, 1 of Book 3, 0 of Book 4, 1 of Book 5, expected 28.00", "28.00",
				KataPotter.cartPrice(0, 1, 1, 0, 1));
	}
}
