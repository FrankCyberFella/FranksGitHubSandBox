package com.techelevator.ssg;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.ssg.model.planets.PlanetCalculations;

public class PlanetCalculatorsTest {

	
	@Test
	public void testPlanetWeight() {
		PlanetCalculations test = new PlanetCalculations();
		assertEquals("Mars",test.getPlanetByName("Mars").getName());
		assertEquals(0.38,test.getPlanetByName("Mars").getGravityOverEarthGravity(),.001);
		
	}
}
