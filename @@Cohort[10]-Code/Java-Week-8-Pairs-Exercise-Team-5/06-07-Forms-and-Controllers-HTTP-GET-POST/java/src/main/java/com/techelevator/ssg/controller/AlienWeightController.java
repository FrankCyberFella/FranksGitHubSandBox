package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.ssg.model.planets.AlienAge;
import com.techelevator.ssg.model.planets.AlienWeight;


	@Controller
	public class AlienWeightController {
		@RequestMapping("/alienWeightInput")
		public String showAlienWeightInputPage(){
			return "alienWeightInput";
		}
		
		@RequestMapping("/alienWeightResult")
		public String showAlienWeightCalculatorResult(HttpServletRequest request) {
			int weight = Integer.parseInt(request.getParameter("weight"));
			String planet = request.getParameter("planet");
			AlienWeight newWeight = new AlienWeight(weight, planet);
			request.setAttribute("newWeight", newWeight);
			
			return "alienWeightResult";
		}
		
	
	}

