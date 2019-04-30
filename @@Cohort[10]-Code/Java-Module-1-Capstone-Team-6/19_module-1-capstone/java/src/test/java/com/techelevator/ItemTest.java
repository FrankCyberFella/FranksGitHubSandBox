package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
	Item itemTest = new Item("Baby Ruth", "1.50", "Candy", 3);
	@Test
	public void add_Sale_Test() {
		itemTest.addSale();
		itemTest.addSale();
		Assert.assertEquals("That is not the expected result", 2 ,  itemTest.getSales());
	}
	
	@Test
	public void get_Item_Name_Test() {
		Assert.assertEquals("That is not the expected", "Baby Ruth", itemTest.getName());
	}
	
	
	@Test
	public void get_Item_Price_Test() {
		Assert.assertEquals("That is not the expected", "1.50", itemTest.getPrice());
	}
	
	@Test
	public void  get_Item_Type_Test() {
		Assert.assertEquals("That is not the expected", "Candy", itemTest.getType());
	}
	
	@Test
	public void  get_Item_Amount_Test() {
		Assert.assertEquals("That is not the expected", 3, itemTest.getAmount());
	}
	
	@Test
	public void  get_Item_Message_Test() {
		Assert.assertEquals("That is not the expected", "Munch Munch, Yum!", itemTest.message());
	}
	
	@Test
	public void  get_Item_Message_Test2() {
		itemTest.setType("Chip");
		Assert.assertEquals("That is not the expected", "Crunch Crunch, Yum!", itemTest.message());
	}
	
	@Test
	public void  get_Item_ToString_Test() {
	
		Assert.assertEquals("That is not the expected", "Baby Ruth $1.50 qty. 3", itemTest.toString());
	}

}





