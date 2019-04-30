package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.techelevator.ssg.model.planets.Planet;
import com.techelevator.ssg.model.planets.PlanetCalculations;

@Controller
public class AlienWeightController {
	

	@RequestMapping("/alienWeightInput")
	public String showAlienWeightInput() {
		return "alienWeightInput";
		
	}
	
	@RequestMapping("/alienWeightResult")
	public String showAlienWeightResult(HttpServletRequest request) {
		PlanetCalculations calc = new PlanetCalculations();
		int earthWeight = Integer.parseInt(request.getParameter("earthWeight"));
		String planet = request.getParameter("planet");
		Planet thePlanet = calc.getPlanetByName(planet);
		
		request.setAttribute("planetWeight", calc.calculatePlanetWeight(earthWeight, thePlanet));
		
		return "alienWeightResult";
	}

	
}


