package com.techelevator;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.Assert;

public class VendingMachineCLITest {

	/*
	 * Testing the purchase process flow of customer feeding money into machine in
	 * whole dollar amounts of ($1, $2, $5, $10) Also testing see if parsing from
	 * String to Int will work
	 */

	@Test
	public void feedMoneyTest1() {

		String moneyEntered = "1";
		assertEquals(1, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTestSign1() {

		String moneyEntered = "$1";// Test Failed as Wanted. Customers insert 1 not $1
		assertEquals(1, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTest2() {

		String moneyEntered = "2";
		assertEquals(2, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTestSign2() {// Test Failed as Wanted. Customers insert 2 not $2

		String moneyEntered = "$2";
		assertEquals(2, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTest5() {

		String moneyEntered = "5";
		assertEquals(5, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTestSign5() {// Test Failed as Wanted. Customers insert 5 not $5

		String moneyEntered = "$5";
		assertEquals(5, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTest10() {

		String moneyEntered = "10";
		assertEquals(10, Integer.parseInt(moneyEntered));
	}

	@Test
	public void feedMoneyTestSign10() {// Test Failed as Wanted. Customers insert 10 not $10

	String moneyEntered = "$10";
	assertEquals(10, Integer.parseInt(moneyEntered));
}
//	Testing Machine Loading Inventory 

	

	}
