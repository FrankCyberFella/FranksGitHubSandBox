package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class alienWeightController {
	@RequestMapping("/alienWeightInput")
	public String showAlienWeightInputPage() {
		return "alienWeightInput";
	}
	
	@RequestMapping("/alienWeightResult")
	public String showAlienWeightInputResults(HttpServletRequest request) {
		
		double alienWeight = Double.parseDouble(request.getParameter("earthWeight"));
		String planet = request.getParameter("planet");
		
		switch (planet) {
		case "Mars": 
		alienWeight = (alienWeight * 0.38);
			
		break;
		case "Jupiter": planet = "Jupiter";
		alienWeight = (alienWeight * 2.65);
		break;
		case "Saturn": planet = "Saturn";
		alienWeight = (alienWeight * 1.13);

		break;
		case "Venus": planet = "Venus";
		alienWeight = (alienWeight * 0.90);

		break;
		case "Uranus": planet = "Uranus";
		alienWeight = (alienWeight * 1.09);

		break;
		case "Neptune": planet = "Neptune";
		alienWeight = (alienWeight * 1.43);

		break;
		case "Mercury": planet = "Mercury";
		alienWeight = (alienWeight * 0.37);

		break;
		}
		
		
		
		
		
		request.setAttribute("alienWeight", alienWeight);
		
		return "alienWeightResult";
	}
}