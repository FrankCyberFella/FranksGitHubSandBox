package com.alecpetro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
@Scope("session")
public class QuoteController {
	
	@Autowired
	private QuotesMethods quotesMethods;

	

	@RequestMapping(path= {"/", "/greeting"}, method=RequestMethod.GET) 
	public String displayGreeting(ModelMap modelHolder, HttpSession session, HttpServletRequest request) {
		
		session.setAttribute("choice", request.getParameter("size"));
		
		modelHolder.addAttribute("small", quotesMethods.getSmallQuote());
		modelHolder.addAttribute("medium", quotesMethods.getMediumQuote());
		modelHolder.addAttribute("large", quotesMethods.getLargeQuote());
		return "greeting";
	}
	
	// post method that takes user input from a drop down list.  List contains ints 1 - 5.  
	// take value add it to current quote object sum.  Add 1 to count for amount of votes placed.
	// display a value of sum / count to display quote's average rating
	
	  @RequestMapping(path= {"/greeting"}, method=RequestMethod.POST) public String
	  loadVotes(@ModelAttribute("small") Quote quote, BindingResult result,
	  ModelMap modelHolder) {
	  
	  if(result.hasErrors()) { return "greeting"; }
	  
	  modelHolder.addAttribute("sum", quote.getSum());
	  modelHolder.addAttribute("count", quote.getCount()); 
	  
	  return "greeting";
	 }
	 
	
	
}
