package com.techelevator.ssg.model.planets;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

public class AlienWeight {
	
	private int weight;
	private String planet;
	
	public AlienWeight(int weight, String planet) {
		this.weight = weight;
		this.planet = planet;
	}
	
	
//	Mercury: 0.38
//	Venus: 0.91
//	Earth: 1.00
//	Mars: 0.38
//	Jupiter: 2.34
//	Saturn: 1.06
//	Uranus: 0.92
//	Neptune: 1.19
//	Pluto: 0.06

	public double calculateWeight() {
		switch(planet) {
		case "Mercury":
			return weight * .38;
		case "Venus":
			return weight * .91;
		case "Earth":
			return weight * 1;
		case "Mars":
			return weight * .38;
		case "Jupiter":
			return weight * 2.34;
		case "Saturn":
			return weight * 1.06;
		case "Uranus":
			return weight * .92;
		case "Neptune":
			return weight * 1.19;
		}
		return 0;
	}


}
