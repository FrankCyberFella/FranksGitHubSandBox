package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class alienAgeController {

	@RequestMapping("/alienAgeInput")
	public String showAlienAgeInputPage() {
		return "alienAgeInput";
	}
	
	@RequestMapping("/alienAgeResult")
	public String showAlienAgeInputResults(HttpServletRequest request) {
		
		double alienAge = Double.parseDouble(request.getParameter("earthAge"));
		String planet = request.getParameter("planet");
		
		switch (planet) {
		case "Mars": 
		alienAge = (alienAge * 365.26)/87.96;
			
		break;
		case "Jupiter": planet = "Jupiter";
		alienAge = (alienAge * 365.26)/11.862;
		
		break;
		case "Saturn": planet = "Saturn";
		alienAge = (alienAge * 365.26)/29.456;

		break;
		case "Venus": planet = "Venus";
		alienAge = (alienAge * 365.26)/224.68;

		break;
		case "Uranus": planet = "Uranus";
		alienAge = (alienAge * 365.26)/84.07;

		break;
		case "Neptune": planet = "Neptune";
		alienAge = (alienAge * 365.26)/164.81;
	
		break;
		case "Mercury": planet = "Mercury";
		alienAge = (alienAge * 365.26)/87.96;
	
		break;
		}
		
		
		
		
		
		request.setAttribute("alienAge", alienAge);
		
		return "alienAgeResult";
	}
	
}
