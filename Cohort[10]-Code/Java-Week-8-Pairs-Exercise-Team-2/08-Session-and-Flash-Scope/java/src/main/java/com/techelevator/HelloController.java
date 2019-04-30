package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Vegetable;

@Controller 
public class HelloController {

	@RequestMapping({"/","/mainPage"})
	public String showMainPage() {
		return "mainPage";
	}
	
	@RequestMapping({"/peppers"})
	public String showPeppers(HttpServletRequest request) {
		Vegetable pepper = new Vegetable();
		pepper.setName("Bell Pepper");
		pepper.setItemPrice(5.99);
		request.setAttribute("pepper", pepper);
		return "peppers";
	}
	
	@RequestMapping({"/carrots"})
	public String showCarrots() {
		
		return "carrots";
	}
	
	@RequestMapping({"/cucumbers"})
	public String showCucumbers() {
		
		return "cucumbers";
	}
	
	@RequestMapping({"/tomatoes"})
	public String showTomatoes() {
		
		return "tomatoes";
	}
	
	@RequestMapping({"/radishes"})
	public String showRadishes() {
		
		return "radishes";
	}
	
	@RequestMapping(path= {"/peppers","/carrots","/cucumbers","/tomatoes","/radishes"}, method=RequestMethod.POST)
	public String addPeppers(@RequestParam double quantity)
										throws FileNotFoundException, IOException {
	Vegetable vegetable = new Vegetable();
	return "redirect:/shoppingCart";
	}
	
	@RequestMapping(path={"/shoppingCart"}, method=RequestMethod.GET)
	public String showShoppingCart(HttpServletRequest request) {
		List<Vegetable> vegetables = new ArrayList<>();
		request.setAttribute("vegetables", vegetables);
		return "/shoppingCart";
	}
	
}
