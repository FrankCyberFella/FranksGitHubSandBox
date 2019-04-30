package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.ssg.model.planets.AlienAge;



@Controller
public class AlienAgeController {
	@RequestMapping("/alienAgeInput")
	public String showAlienAgeInputPage(){
		return "alienAgeInput";
	}

	@RequestMapping("/alienAgeResult")
	public String showAlienAgeCalculatorResult(HttpServletRequest request) {
		int age = Integer.parseInt(request.getParameter("age"));
		String planet = request.getParameter("planet");
		AlienAge newAge = new AlienAge(age, planet);
		double newPlanetAge = newAge.calculateAge(); 
	    request.setAttribute("newPlanetAge", newPlanetAge);
		
		return "alienAgeResult";
	}
	
	
	
	
	
}
