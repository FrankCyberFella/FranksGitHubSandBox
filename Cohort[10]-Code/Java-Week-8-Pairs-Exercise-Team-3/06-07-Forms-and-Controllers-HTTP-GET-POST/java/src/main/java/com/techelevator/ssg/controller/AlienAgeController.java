package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.ssg.model.planets.Planet;
import com.techelevator.ssg.model.planets.PlanetCalculations;

@Controller
public class AlienAgeController {

	@RequestMapping("/alienAgeInput")
	public String calculateAlienAge() {
		
		return "alienAgeInput";
	}
	
	@RequestMapping("/alienAgeResult")
	public String showAlienAge(HttpServletRequest request) {
		PlanetCalculations calc = new PlanetCalculations();
		int earthAge = Integer.parseInt(request.getParameter("earthAge"));
		String planetName = request.getParameter("planet");
		Planet thePlanet = calc.getPlanetByName(planetName);
		
		
		request.setAttribute("planetAge", calc.calculateAgeInPlanetYears(earthAge, thePlanet));		
				
		return "alienAgeResult";
	}
	
}
