package com.techelevator.view;

import static org.junit.Assert.*;
import com.techelevator.view.*;
import com.techelevator.*;
import org.junit.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class VendingMachineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void vendingMachineConstructorTest() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		assertTrue(0 == machine.getCurrentBalance());
	}
	
	@Test
	public void feedMoneyTest() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		machine.feedMoney();

		assertTrue(0 == machine.getCurrentBalance());
	}

}
