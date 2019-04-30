package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HelloController {

	@RequestMapping("/greeting")
	public String displayGreeting(HttpSession session) {
		
		return "greeting";
	}
	
	@RequestMapping("/")
	public String rootGreeting(HttpSession session) {
		
		return "greeting";
	}
}