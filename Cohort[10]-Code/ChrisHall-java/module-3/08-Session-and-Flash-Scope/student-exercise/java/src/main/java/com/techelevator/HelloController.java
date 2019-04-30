package com.techelevator;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/greeting")
	public String displayGreeting() {

		return "greeting";
	}

	@RequestMapping(path = { "/"}, method = RequestMethod.GET)
	public String showWelcome() {
		
		return "/FavoriteThings";
	}
	
	@RequestMapping(path = { "/page1"}, method = RequestMethod.GET)
	public String goToPage1() {
			
		return "/page1";
	}
	
	
	@RequestMapping(path = {"/page1" }, method = RequestMethod.POST)
	public String postAnswerOne() {	
		
		return "/page2";
	}
	
	@RequestMapping(path = {"/page2" }, method = RequestMethod.GET)
	public String gotoPageTwo() {
			
		return "/page2";
	}
	
	@RequestMapping(path = {"/page2" }, method = RequestMethod.POST)
	public String postAnswerTwo() {
			
		return "redirect:/page3";
	}
	
	@RequestMapping(path = {"/page3" }, method = RequestMethod.POST)
	public String postAnswerThree() {
		
		
		return "redirect:/Summary";
	}
}
