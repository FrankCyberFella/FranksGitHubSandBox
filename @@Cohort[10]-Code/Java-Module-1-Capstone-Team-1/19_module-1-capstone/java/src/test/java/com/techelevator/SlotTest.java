package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SlotTest {

	@Test
	public void TestRemoveItem() {
		Slot slotObj = new Slot("K9", new Item("Candy Crush", "Candy", .75));
		int getQuantity = slotObj.getItemQuantity();
		for(int i = 0 ; i < getQuantity; i++) {
			Assert.assertTrue(slotObj.removeItem());
		}
		Assert.assertFalse(slotObj.removeItem());
	}
	
}
