package com.techelevator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class homepageController {

	@RequestMapping("/")
	public String showHomepage() {
		return "homepage";
	}
	
}
