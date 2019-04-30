package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeightController {

	@RequestMapping("/weightConverter")
	public String displayWeightConverterPage() {
		return "weightConverter";
	}


	@RequestMapping("/weightConverterResults")
	public String displayWeightConverterResults(HttpServletRequest request) {
		
		double planetGravity = Double.parseDouble(request.getParameter("planet"));
		double enteredWeight = Double.parseDouble(request.getParameter("weight"));
		
		double finalWeight = planetGravity * enteredWeight;
		
		request.setAttribute("convertedWeight", finalWeight);
	
		return "weightConverterResults";
	}
}