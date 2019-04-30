package com.techelevator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.classes.Item;
import com.techelevator.classes.ShoppingCart;

@Controller 
public class HelloController {

	@RequestMapping("/")
	public String displayGreeting(HttpSession session) {
		ShoppingCart cart = new ShoppingCart();
		session.setAttribute("cart", cart);
		return "greeting";
	}
	
	@RequestMapping("/greeting")
	public String backToHome() {
		return "greeting";
	}
	
@RequestMapping("/bellPeppers")
public String displayBellPeppers(HttpSession session) {
	
	Item item = new Item();
	item.setName("Bell Pepper");
	item.setImageName("bellPepper.jpg");
	item.setPrice(4.99);
	System.out.println(item);
	session.setAttribute("bellPepper", item);
	return "bellPeppers";
}

@RequestMapping("/carrots")
public String displayCarrots(HttpSession session) {
	Item item = new Item();
	item.setName("Carrots");
	item.setImageName("carrots.jpg");
	item.setPrice(2.99);
	System.out.println(item);
	session.setAttribute("carrots", item);
	return "carrots";
}

@RequestMapping("/cucumbers")
public String displayCucumbers(HttpSession session) {
	Item item = new Item();
	item.setName("Cucumbers");
	item.setImageName("cucumbers.jpg");
	item.setPrice(3.99);
	System.out.println(item);
	session.setAttribute("cucumbers", item);
	return "cucumbers";
}

@RequestMapping("/heirloomTomatoes")
public String displayHeirloomTomatoes(HttpSession session) {
	Item item = new Item();
	item.setName("Heirloom Tomatoes");
	item.setImageName("tomatoes.jpg");
	item.setPrice(5.99);
	System.out.println(item);
	session.setAttribute("heirloomTomatoes", item);

	return "heirloomTomatoes";
}

@RequestMapping("/radishes")
public String displayRadishes(HttpSession session) {
	Item item = new Item();
	item.setName("Radishes");
	item.setImageName("radishes.jpg");
	item.setPrice(1.99);
	System.out.println(item);
	session.setAttribute("radishes", item);
	return "radishes";
}

@RequestMapping(path="/addToCart", method=RequestMethod.POST) 
public String addItemToCart(@RequestParam String quantity, @RequestParam String type, HttpSession session) {
	
	String vegetableType = type;
	Double vegetableQuantity = Double.parseDouble(quantity);
	
	Item item = (Item)session.getAttribute(type);

	
	item.setQuantity(vegetableQuantity);
	
	ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
	
	cart.add(item);
	System.out.println(cart.seeCart().size());
	return "redirect:/greeting";
}

@RequestMapping("/shoppingCart")
public String showShoppingCart(HttpSession session) {
	
	ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
	List<Item> cartList = cart.seeCart();
	session.setAttribute("cartList", cartList);
	for(Item item: cartList){
		System.out.println(item);
	}
	return "shoppingCart";
}
}
