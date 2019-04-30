package com.techelevator;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.echo.model.Echo;

@Controller 
public class HomeController {

//	@RequestMapping("/")
//	public String displayHomePage() {
//		
//		return "homePage";
//	}
	
	@RequestMapping({"/", "echoHome"})
	public String displayEchoHome() {
		return "echoHome";
	}
	

	
	@RequestMapping(path="echoShow", method= RequestMethod.GET)
	public String getEchoInfo(@RequestParam int startingFontSize,
							  @RequestParam String word,
							  ModelMap request
							   ) {
		Echo newEcho = new Echo();
		newEcho.setStartingFontSize(startingFontSize);
		newEcho.setWord(word);
		request.addAttribute("echo", newEcho);
		//
		return "echoShow";
	}
	
//	@RequestMapping(path="/echoShow", method=RequestMethod.GET)
//	public String showEchoOutput(HttpServletRequest request) {
//		request.setAttribute("echo", newEcho);
//	}
	
	
	
}
