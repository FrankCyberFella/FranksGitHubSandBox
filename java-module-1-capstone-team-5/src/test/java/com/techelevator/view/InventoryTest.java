package com.techelevator.view;

import com.techelevator.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;


import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void inventoryConstructorTest() {
		try {
			File inputFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/vendingmachine.csv");
			Scanner inputScanner = new Scanner(inputFile);
			Inventory inventory = new Inventory(inputScanner);
		} catch (FileNotFoundException e) {
			fail("File is not found, so cannot test");
		}
		
	}
	
	@Test
	public void settingTest() {
		try {
			File inputFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/vendingmachine.csv");
			Scanner inputScanner = new Scanner(inputFile);
			Inventory inventory = new Inventory(inputScanner);
			
			assertTrue("The size of the inventory map should be 16",inventory.getInventory().size() == 16);
			
//			for (Map.Entry<Snack, Integer> snackEntry : inventory.getInventory().entrySet()) {
//				assertTrue("", == inventory.get)
//			}
			
		} catch (FileNotFoundException e) {
			fail("File is not found, so cannot test");
		}
		
		
	}
	
	@Test
	public void subtractTest() {
		try {
			File inputFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/vendingmachine.csv");
			Scanner inputScanner = new Scanner(inputFile);
			Inventory inventory = new Inventory(inputScanner);
			
			inventory.subtract("A1");
			
			for (Map.Entry<Snack, Integer> snackEntry : inventory.getInventory().entrySet()) {
				if (snackEntry.getKey().getSlot().equals("A1")) {
					assertTrue("the number of the product should be now 4", 4 == snackEntry.getValue());
				}
			}
			
		
			
		} catch (FileNotFoundException e) {
			fail("File is not found, so cannot test");
		}
		
		
	}
	
	@Test
	public void slotExistTest() {
		try {
			File inputFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/vendingmachine.csv");
			Scanner inputScanner = new Scanner(inputFile);
			Inventory inventory = new Inventory(inputScanner);
			
			assertEquals(true, inventory.slotExist("A1"));
			assertEquals(true, inventory.slotExist("B1"));
			assertEquals(true, inventory.slotExist("C1"));
			assertEquals(true, inventory.slotExist("D1"));
			assertEquals(true, inventory.slotExist("A2"));
			assertEquals(false, inventory.slotExist("Z1"));
			
		
			
		} catch (FileNotFoundException e) {
			fail("File is not found, so cannot test");
		}
	}

	@Test
	public void isSoldOutTest() {
		try {
			File inputFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/vendingmachine.csv");
			Scanner inputScanner = new Scanner(inputFile);
			Inventory inventory = new Inventory(inputScanner);
			
			assertEquals(false, inventory.isSoldOut("A1"));
			inventory.subtract("A1");
			assertEquals(false, inventory.isSoldOut("A1"));
			inventory.subtract("A1");
			assertEquals(false, inventory.isSoldOut("A1"));
			inventory.subtract("A1");
			assertEquals(false, inventory.isSoldOut("A1"));
			inventory.subtract("A1");
			assertEquals(false, inventory.isSoldOut("A1"));
			inventory.subtract("A1");
			assertEquals(true, inventory.isSoldOut("A1"));
			
		
			
		} catch (FileNotFoundException e) {
			fail("File is not found, so cannot test");
		}
	}
}
