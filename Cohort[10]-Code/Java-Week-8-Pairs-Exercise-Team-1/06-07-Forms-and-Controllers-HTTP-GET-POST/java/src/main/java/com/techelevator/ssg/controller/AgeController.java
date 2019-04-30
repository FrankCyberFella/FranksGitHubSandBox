package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgeController {

	@RequestMapping("/ageConverter")
	public String displayAgeConverterPage() {
		return "ageConverter";
	}
	
	@RequestMapping("/AgeConverterResults")
	public String displayAgeConverterResults(HttpServletRequest request) {
		
		double planetYear = Double.parseDouble(request.getParameter("planet"));
		double enteredAge = Double.parseDouble(request.getParameter("age"));
		
		double ageDays = enteredAge * (365.26);
		double finalAge = ageDays/planetYear;
		
		request.setAttribute("convertedAge", finalAge);
		
		return "AgeConverterResults";
	}
}