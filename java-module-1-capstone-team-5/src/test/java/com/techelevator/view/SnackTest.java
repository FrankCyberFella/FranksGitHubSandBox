package com.techelevator.view;

import com.techelevator.*;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.*;

public class SnackTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void snackConstructorTest() {
		// Creating the object
		Snack snack = new Snack("A4", "Potato Crisps", 2.50, "Chip");
		
		assertEquals("Wrong slot","A4", snack.getSlot());
		assertEquals("Wrong food item", "Potato Crisps", snack.getName());
		assertEquals("Wrong price", 2.50, snack.getCost(), .01);
		assertEquals("Wrong item type", "Chip", snack.getType());
	}
}
