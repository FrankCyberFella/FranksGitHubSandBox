package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.ssg.model.planets.Planet;
import com.techelevator.ssg.model.planets.PlanetCalculations;

@Controller
public class TransitTimeController {
	
	@RequestMapping(path="/transitTimeInput")
	public String showTransitTimeForm() {
		return "transitTimeInput";
	}
	
	@RequestMapping(path="/transitTimeResult")
	public String showTransitTimeResult(HttpServletRequest request) {
		PlanetCalculations calc = new PlanetCalculations();
		String planetName = request.getParameter("planet");
		String transitMode = request.getParameter("mode");
		Planet thePlanet = calc.getPlanetByName(planetName);
		
		
		
		request.setAttribute("years", calc.calculateTravelTimeFromEarth(transitMode, thePlanet));
		
		return "transitTimeResult";
	}
}
