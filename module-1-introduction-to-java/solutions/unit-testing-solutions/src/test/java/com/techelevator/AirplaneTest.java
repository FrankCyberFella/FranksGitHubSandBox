package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AirplaneTest {
	
	@Test
	public void availableFirstClassSeatsInitializedCorrectly() {
		Airplane a = new Airplane("ABC123", 10, 30);
		Assert.assertEquals(10, a.getTotalFirstClassSeats());
		Assert.assertEquals(10, a.getAvailableFirstClassSeats());
		Assert.assertEquals(0,  a.getBookedFirstClassSeats());
	}
	
	@Test
	public void coachSeatsInitializedCorrectly() {
		Airplane a = new Airplane("ABC123", 10,30);
		Assert.assertEquals(30, a.getTotalCoachSeats());
		Assert.assertEquals(30, a.getAvailableCoachSeats());
		Assert.assertEquals(0, a.getBookedCoachSeats());
	}
	
	@Test
	public void successfullyBookFirstClassSeats() {
		Airplane a = new Airplane("ABC123", 10,30);
		Assert.assertTrue(a.Reserve(true, 10));
		Assert.assertEquals(10, a.getTotalFirstClassSeats());
		Assert.assertEquals(0, a.getAvailableFirstClassSeats());
		Assert.assertEquals(10, a.getBookedFirstClassSeats());
	}
	
	@Test
	public void attemptToOverbookFirstClassSeats() {
		Airplane a = new Airplane("ABC123", 10,30);
		Assert.assertFalse(a.Reserve(true, 11));
		Assert.assertEquals(10, a.getTotalFirstClassSeats());
		Assert.assertEquals(10, a.getAvailableFirstClassSeats());
		Assert.assertEquals(0, a.getBookedFirstClassSeats());
	}

	@Test
	public void successfullyBookCoachSeats() {
		Airplane a = new Airplane("ABC123", 10,30);
		Assert.assertTrue(a.Reserve(false, 30));
		Assert.assertEquals(30, a.getTotalCoachSeats());
		Assert.assertEquals(0, a.getAvailableCoachSeats());
		Assert.assertEquals(30, a.getBookedCoachSeats());
	}
	
	@Test
	public void attemptToOverbookCoachSeats() {
		Airplane a = new Airplane("ABC123", 10,30);
		Assert.assertFalse(a.Reserve(false, 31));
		Assert.assertEquals(30, a.getTotalCoachSeats());
		Assert.assertEquals(30, a.getAvailableCoachSeats());
		Assert.assertEquals(0, a.getBookedCoachSeats());
	}

	@Test
	public void setGetPlaneNumber() {
		Airplane a = new Airplane("ABC123", 10, 30);
		Assert.assertEquals("ABC123", a.getPlaneNumber());
	}

	@Test
	public void singleLetterPlaneNumber() {
		Airplane a = new Airplane("Z", 10, 30);
		Assert.assertEquals("Z", a.getPlaneNumber());
	}

	@Test
	public void planeNumberTooLong() {
		Airplane a = new Airplane("ThisIsWayTooLong", 10, 30);
		Assert.assertEquals("ThisIs", a.getPlaneNumber());
	}

	@Test
	public void planeNumberNullOnConstruct() {
		Airplane a = new Airplane(null, 10, 30);
		Assert.assertEquals("UKNOWN", a.getPlaneNumber());
	}

	@Test
	public void planeNumberEmptyOnConstruct() {
		Airplane a = new Airplane("", 10, 30);
		Assert.assertEquals("UKNOWN", a.getPlaneNumber());
	}

}
