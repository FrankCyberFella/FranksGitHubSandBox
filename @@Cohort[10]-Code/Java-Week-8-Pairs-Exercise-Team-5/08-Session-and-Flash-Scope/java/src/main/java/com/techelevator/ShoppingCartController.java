package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.ShoppingCart;
import com.techelevator.model.Vegetable;


@Controller
public class ShoppingCartController {
	@RequestMapping({"/"})
	public String startSession(HttpSession session) {
		session.setAttribute("vegetables", new ArrayList<Vegetable>());
		return "mainPage";
	}

	@RequestMapping({"/mainPage"})
	public String showMainPage() {
		return "mainPage";
	}
	
   	@RequestMapping("/bellPeppers")
	public String showBellPeppers() {
		 return "bellPeppers";
	}
	
	@RequestMapping("/heirloomTomatoes")
	public String showHeirloomTomatoes() {
		return "heirloomTomatoes";
	}
	@RequestMapping("/radishes")
	public String showRadishes() {
		return "radishes";
	}
	@RequestMapping("/carrots")
	public String showCarrots() {
		return "carrots";
	}
	@RequestMapping("/cucumbers")
	public String showCucumber() {
		return "cucumbers";
	}
	
	
	
	@RequestMapping(path = "shoppingCart", method = RequestMethod.POST)
		public String addVegetableToCart(@RequestParam int quantity,
										 @RequestParam String type,
										 @RequestParam double price,
										 HttpSession session
				) throws FileNotFoundException,IOException  {
			Vegetable vegetable = new Vegetable(type, quantity, price);
			List<Vegetable> vegetableList = (List<Vegetable>)session.getAttribute("vegetables");
			vegetableList.add(vegetable); 
			return "redirect:/shoppingCart";
	}
	
	
   @RequestMapping(path= "/shoppingCart", method= RequestMethod.GET)
	public String showShoppingCart() {
		return "shoppingCart";
	}
	
//path= {"/peppers","/carrots","/cucumbers","/heirloomTomatoes","radishes"}
	
}
