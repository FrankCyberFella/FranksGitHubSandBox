package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SmartPhoneTest {
	
	@Test
	public void smartPhoneInitializedCorrectly() {
		SmartPhone sp = new SmartPhone("216-555-1212", "SquirrelNet");
		Assert.assertEquals("216-555-1212", sp.getPhoneNumber());
		Assert.assertEquals("SquirrelNet", sp.getCarrier());
		Assert.assertEquals(100, sp.getBatteryCharge());
		Assert.assertFalse(sp.isOnCall());
	}

}
