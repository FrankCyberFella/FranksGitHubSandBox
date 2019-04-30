package com.techelevator;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Item;
import com.techelevator.model.ShoppingCart;

@Controller 
public class HomeController {

	@RequestMapping("/")
	public String displayGreeting(HttpSession session) {
		ShoppingCart shoppingCart = new ShoppingCart();
		session.setAttribute("shoppingCart", shoppingCart);
		
		return "home";
	}
	
	@RequestMapping(path="/home", method=RequestMethod.POST)
	public String addToShoppingCart(@RequestParam int quantity, @RequestParam String type, HttpSession session) {
		
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		
		for (int i = 0; i < quantity; i++) {
			Item item = new Item(type, shoppingCart.getItemPrice(type), shoppingCart.getItemName(type));
			
			shoppingCart.add(item);
			
			System.out.println("Added" + quantity + item.getName());
		}
		
		
		return "redirect:/home";
		
	}
	
	@RequestMapping(path= {"/home"}, method=RequestMethod.GET)
	public String displayHome() {
		
		
		return "home";
	}
}
