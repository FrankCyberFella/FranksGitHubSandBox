package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HelloController {

	@RequestMapping({"greeting","/"})
	public String displayGreeting() {
		
		return "greeting";
	}
	
	@RequestMapping(path="Page1", method=RequestMethod.GET)
	public String showPage1(HttpSession session) {
		session.setAttribute("answers", new ArrayList<String>());
		return "Page1";
	}
	
	@RequestMapping(path="Page1", method=RequestMethod.POST)
	public String submitPage1(HttpSession session,@RequestParam String favorite) {
		List<String> sessionArray = (ArrayList<String>)session.getAttribute("answers");
		sessionArray.add(favorite);
		return "redirect:/summary";
	}
	
	@RequestMapping("summary")
	public String showSummary() {
		return "summary";
	}
}
