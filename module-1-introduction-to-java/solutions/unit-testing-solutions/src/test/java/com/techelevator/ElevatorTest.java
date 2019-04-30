package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ElevatorTest {

	/*
	 * Note, there are no tests for moving other than the initial check to see if it
	 * stationary after its been instantiated.  Moving is not fully implemented in 
	 * the Elevator class since the car magically teleports from the current level to 
	 * the desired level without ever "moving".
	 */
	@Test
	public void elevatorInitializedCorrectly() {
		Elevator e = new Elevator(1, 54);
		Assert.assertEquals(1, e.getShaftNumber());
		Assert.assertEquals(54, e.getNumberOfLevels());
		Assert.assertEquals(1, e.getCurrentLevel());
		Assert.assertTrue(e.isDoorOpen());
		Assert.assertFalse(e.isMoving());
	}
	
	@Test
	public void doorOpensAndClosesCorrectly() {
		Elevator e = new Elevator(1, 54);
		Assert.assertTrue(e.isDoorOpen());
		Assert.assertFalse(e.isMoving());
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		e.OpenDoor();
		Assert.assertTrue(e.isDoorOpen());
	}

	@Test
	public void elevatorGoesUp() {
		Elevator e = new Elevator(1, 54);
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertTrue(e.GoUp(54));
		Assert.assertEquals(54, e.getCurrentLevel());
	}
	
	@Test
	public void attemptToGoUpToTheLevelCurrentlyOn() {
		Elevator e = new Elevator(1, 54);
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertTrue(e.GoUp(3));
		Assert.assertEquals(3, e.getCurrentLevel());
		Assert.assertFalse(e.GoUp(3));
		Assert.assertEquals(3, e.getCurrentLevel());
	}
	
	@Test
	public void attemptToGoUpWithDoorOpen() {
		Elevator e = new Elevator(1, 54);
		Assert.assertTrue(e.isDoorOpen());
		Assert.assertFalse(e.GoUp(54));
		Assert.assertEquals(1, e.getCurrentLevel());
	}
	
	@Test
	public void attemptToFlyElevatorThroughTheRoof() {
		Elevator e = new Elevator(1, 54);
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertFalse(e.GoUp(55));
		Assert.assertEquals(1, e.getCurrentLevel());
	}
	
	@Test
	public void elevatorGoesDown() {
		Elevator e = new Elevator(1, 54);
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertTrue(e.GoUp(54));
		Assert.assertEquals(54, e.getCurrentLevel());
		Assert.assertTrue(e.GoDown(3));
		Assert.assertEquals(3, e.getCurrentLevel());
	}

	@Test
	public void attemptToGoDownToTheLevelCurrentlyOn() {
		Elevator e = new Elevator(1, 54);
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertTrue(e.GoUp(54));
		Assert.assertEquals(54, e.getCurrentLevel());
		Assert.assertTrue(e.GoDown(3));
		Assert.assertEquals(3, e.getCurrentLevel());
		Assert.assertFalse(e.GoDown(3));
		Assert.assertEquals(3, e.getCurrentLevel());
	}
	
	@Test
	public void attemptToGoDownWithDoorOpen() {
		Elevator e = new Elevator(1, 54);
		// Have to move up ...
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertTrue(e.GoUp(54));
		Assert.assertEquals(54, e.getCurrentLevel());
		// ... before attempting to go down
		e.OpenDoor();
		Assert.assertTrue(e.isDoorOpen());
		Assert.assertFalse(e.GoDown(3));
		Assert.assertEquals(54, e.getCurrentLevel());
	}
	
	@Test
	public void attemptToFlyElevatorBelowFirstLevel() {
		Elevator e = new Elevator(1, 54);
		e.CloseDoor();
		Assert.assertFalse(e.isDoorOpen());
		Assert.assertFalse(e.GoDown(0));
		Assert.assertEquals(1, e.getCurrentLevel());
	}
	
}
