package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping({"/","/homePage"})
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping(path={"/bellPeppers"}, method = RequestMethod.GET)
	public String displayBellPeppers() {
		return "bellPeppers";
	}
	
	@RequestMapping(path= {"/carrots"}, method = RequestMethod.GET)
	public String displayCarrots() {
		return "carrots";
	}
	
	@RequestMapping("/cucumber")
	public String displayCucumbers() {
		return "cucumber";
	}
	
	@RequestMapping("/tomatoes")
	public String displayTomatoes() {
		return "tomatoes";
	}
	
	@RequestMapping("/radishes")
	public String displayRadishes() {
		return "radishes";
	}
	
	@RequestMapping(path={"/bellPeppers"}, method = RequestMethod.POST)
	public String processBellPeppers(@RequestParam String bellPepperQuantity, HttpSession session) {
		int finalBellPepperQuantity = 0;
		
		if (session.getAttribute("shoppingCart") == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			finalBellPepperQuantity = Integer.parseInt(bellPepperQuantity);	

			shoppingCart.setBellPepperQuantity(finalBellPepperQuantity);			
			System.out.println(shoppingCart.getBellPepperQuantity());
			session.setAttribute("shoppingCart",shoppingCart);
			return "redirect:/homePage";
		} 
		
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		finalBellPepperQuantity = Integer.parseInt(bellPepperQuantity) + shoppingCart.getBellPepperQuantity();			
		shoppingCart.setBellPepperQuantity(finalBellPepperQuantity);			
		
		System.out.println(shoppingCart.getBellPepperQuantity());
		
		session.setAttribute("shoppingCart",shoppingCart);
		return "redirect:/homePage";

	}
	
	@RequestMapping(path= {"/carrots"}, method = RequestMethod.POST)
	public String processCarrots(@RequestParam String carrotQuantity, HttpSession session) {
	int finalCarrotQuantity = 0;
	
	if (session.getAttribute("shoppingCart") == null) {
		ShoppingCart shoppingCart = new ShoppingCart();
		finalCarrotQuantity = Integer.parseInt(carrotQuantity);	

		shoppingCart.setCarrotQuantity(finalCarrotQuantity);			
		System.out.println(shoppingCart.getCarrotQuantity());
		session.setAttribute("shoppingCart",shoppingCart);
		return "redirect:/homePage";
	} 
	
	ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
	finalCarrotQuantity = Integer.parseInt(carrotQuantity) + shoppingCart.getCarrotQuantity();			
	shoppingCart.setCarrotQuantity(finalCarrotQuantity);			
	
	System.out.println(shoppingCart.getCarrotQuantity());
	
	session.setAttribute("shoppingCart",shoppingCart);
	return "redirect:/homePage";
	}
	
	@RequestMapping(path= {"/cucumbers"}, method = RequestMethod.POST)
	public String processCucumbers(@RequestParam String cucumberQuantity, HttpSession session) {
	int finalCucumberQuantity = 0;
	
	if (session.getAttribute("shoppingCart") == null) {
		ShoppingCart shoppingCart = new ShoppingCart();
		finalCucumberQuantity = Integer.parseInt(cucumberQuantity);	

		shoppingCart.setCucumberQuantity(finalCucumberQuantity);			
		System.out.println(shoppingCart.getCucumberQuantity());
		session.setAttribute("shoppingCart",shoppingCart);
		return "redirect:/homePage";
	} 
	
	ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
	finalCucumberQuantity = Integer.parseInt(cucumberQuantity) + shoppingCart.getCucumberQuantity();			
	shoppingCart.setCucumberQuantity(finalCucumberQuantity);			
	
	System.out.println(shoppingCart.getCucumberQuantity());
	
	session.setAttribute("shoppingCart",shoppingCart);
	return "redirect:/homePage";
	}
	
	@RequestMapping(path= {"/tomatoes"}, method = RequestMethod.POST)
	public String processTomatos(@RequestParam String tomatoQuantity, HttpSession session) {
	int finalTomatoQuantity = 0;
	
	if (session.getAttribute("shoppingCart") == null) {
		ShoppingCart shoppingCart = new ShoppingCart();
		finalTomatoQuantity = Integer.parseInt(tomatoQuantity);	

		shoppingCart.setTomatoQuantity(finalTomatoQuantity);			
		System.out.println(shoppingCart.getTomatoQuantity());
		session.setAttribute("shoppingCart",shoppingCart);
		return "redirect:/homePage";
	} 
	
	ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
	finalTomatoQuantity = Integer.parseInt(tomatoQuantity) + shoppingCart.getTomatoQuantity();			
	shoppingCart.setTomatoQuantity(finalTomatoQuantity);			
	
	System.out.println(shoppingCart.getTomatoQuantity());
	
	session.setAttribute("shoppingCart",shoppingCart);
	return "redirect:/homePage";
	}
	
	@RequestMapping(path= {"/radishes"}, method = RequestMethod.POST)
	public String processRadishes(@RequestParam String radishQuantity, HttpSession session) {
	int finalRadishQuantity = 0;
	
	if (session.getAttribute("shoppingCart") == null) {
		ShoppingCart shoppingCart = new ShoppingCart();
		finalRadishQuantity = Integer.parseInt(radishQuantity);	

		shoppingCart.setRadishQuantity(finalRadishQuantity);			
		System.out.println(shoppingCart.getRadishQuantity());
		session.setAttribute("shoppingCart",shoppingCart);
		return "redirect:/homePage";
	} 
	
	ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
	finalRadishQuantity = Integer.parseInt(radishQuantity) + shoppingCart.getRadishQuantity();			
	shoppingCart.setRadishQuantity(finalRadishQuantity);			
	
	System.out.println(shoppingCart.getRadishQuantity());
	
	session.setAttribute("shoppingCart",shoppingCart);
	return "redirect:/homePage";
	}
	
	@RequestMapping("/this-is-the-end")
	public String weAreDone(HttpSession session, HttpServletRequest request) {
		
		if (session.getAttribute("shoppingCart") == null) {
			ShoppingCart shoppingCart = new ShoppingCart();

			session.setAttribute("shoppingCart",shoppingCart);
			return "redirect:/productList";
		} 
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		
		shoppingCart.setBellPepperTotal(shoppingCart.getBellPepperPrice()*shoppingCart.getBellPepperQuantity());
		shoppingCart.setCarrotTotal(shoppingCart.getCarrotPrice()*shoppingCart.getCarrotQuantity());
		shoppingCart.setCucumberTotal(shoppingCart.getCucumberPrice()*shoppingCart.getCucumberQuantity());
		shoppingCart.setTomatoTotal(shoppingCart.getTomatoPrice()*shoppingCart.getTomatoQuantity());
		shoppingCart.setRadishTotal(shoppingCart.getRadishPrice()*shoppingCart.getRadishQuantity());
		
		shoppingCart.setTotalTotal(shoppingCart.getBellPepperTotal()+shoppingCart.getCarrotTotal()+shoppingCart.getCucumberTotal()+shoppingCart.getTomatoTotal()+shoppingCart.getRadishTotal());
		
		
		request.setAttribute("s",shoppingCart);
		
		return"productList";
	}
	
	
	
}

