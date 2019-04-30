package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
	  
		AnimalGroupName AnimalGroupNameTest = new AnimalGroupName();

	@Test
		public void testGetHerd() {
			Assert.assertEquals("That is not the expected Result", "unknown", AnimalGroupNameTest.getHerd("walrus"));
			Assert.assertEquals("That is not the expected Result", "Crash", AnimalGroupNameTest.getHerd("Rhino"));
			Assert.assertEquals("That is not the expected Result", "Crash", AnimalGroupNameTest.getHerd("rhino"));
			Assert.assertEquals("That is not the expected Result", "unknown",AnimalGroupNameTest.getHerd("elephants"));
			Assert.assertEquals("That is not the expected Result", "unknown", AnimalGroupNameTest.getHerd(""));
		}

}
