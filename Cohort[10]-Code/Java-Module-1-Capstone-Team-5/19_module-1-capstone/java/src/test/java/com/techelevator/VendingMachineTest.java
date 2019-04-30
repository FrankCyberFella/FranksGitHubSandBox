package com.techelevator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class VendingMachineTest {

//	@Test
//	public void Read_The_Menu() {
//		assertEquals(new ArrayList<String>(Arrays.asList("Potato Crisps", "Moonpie")));
//					VendingMachineCLI.menuReader("A1|Potato Crisps|3.05|Chip|B1|Moonpie|1.80|Candy");
//	}

	@Test
	public void testInventory() {
		Items doritos = new Chips("a1", "doritos", 1.50);
		assertEquals("Expected to receive inventory of 5", 5, doritos.getInventory());
		doritos.setInventory(); // method subtracts one from our inventory whenever purchased
		doritos.setInventory();
		assertEquals("Expected to recieve inventory of 3", 3,doritos.getInventory());
	}
	
	@Test
	public void testPrice() {
		Items doritos = new Chips("a1", "doritos", 1.50);
		Items mountainThunder = new Drink("d2", "Mountain Thunder", 1.75);
		assertEquals("Expected $1.50 for price of doritos","1.5",doritos.getPrice() + "");
		assertEquals("Expected %1.75 for price of Mountain Thunder", "1.75", mountainThunder.getPrice()+ "");
	}
	
	@Test
	public void changeReturned() throws IOException { // converter ans to string for testing
		VendingMachineCLI vM = new VendingMachineCLI();
		assertEquals("Expected an array of [40,1,1]","4011" ,vM.finishingTransaction());
		
	}
//	@Test
//	public void testpurchase() {
//		VendingMachineCLI vM = new VendingMachineCLI();
//		assertEquals("Expected a different arary",new String[] {"Potato Crisps", "Stackers", "Grain Waves", "Moonpie", "Cowtales", "Wonka Bar", "Crunchie", "Cola", "Dr. Salt", "Mountain Master", "Heavy", "U-Chews", "Little League Chew", "Chiclets", "Triplemint"}, vM.DisplayOptions());
//	}
	
}
