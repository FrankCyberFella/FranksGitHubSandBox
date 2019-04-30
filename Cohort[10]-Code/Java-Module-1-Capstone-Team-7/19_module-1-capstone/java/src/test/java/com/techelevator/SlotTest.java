package com.techelevator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.view.Menu;

public class SlotTest {
	
	Slot testSlot = new Slot("A2", "3.50", "Candy", "Cowtales" );
	
	@Test
	public void test_all_getters() {
	assertEquals("name is incorrect", "A2", testSlot.getName() );
	assertEquals("price is incorrect", new DollarAmount(350), testSlot.getPrice() );
	assertEquals("type is incorrect", "Candy", testSlot.getType() );
	assertEquals("Item name is incorrect", "Cowtales", testSlot.getItemName() );
	}
	
	@Test
	public void test_all_setters() {
		testSlot.setName("B3");
		testSlot.setPrice(new DollarAmount (560));
		testSlot.setType("Chips");
		testSlot.setItemName("Lays");
	assertEquals("name is incorrect", "B3", testSlot.getName() );
	assertEquals("price is incorrect", new DollarAmount(560), testSlot.getPrice() );
	assertEquals("type is incorrect", "Chips", testSlot.getType() );
	assertEquals("Item name is incorrect", "Lays", testSlot.getItemName() );
	}
	
	
	@Test
	public void test_toString_method() {
	assertEquals("String is wrong", "Slot name: Cowtales\nSlot price: $3.50\nSlot contains: 5 Candys\n", testSlot.toString() );
	}

	@Test
	public void test_consumeSound_method() {
	 testSlot.setType("Chip");
	assertEquals("sound is incorrect", "Crunch Crunch, Yum!", testSlot.consumeSound() );
	 testSlot.setType("Beverage");
	assertEquals("sound is incorrect", "Glug Glug, Yum!", testSlot.consumeSound() );
	 testSlot.setType("Gum");
	assertEquals("sound is incorrect", "Chew Chew, Yum!", testSlot.consumeSound() );
	 testSlot.setType("Candy");
	assertEquals("sound is incorrect", "Munch Munch, Yum!", testSlot.consumeSound() );
	}
	

	
	
}
