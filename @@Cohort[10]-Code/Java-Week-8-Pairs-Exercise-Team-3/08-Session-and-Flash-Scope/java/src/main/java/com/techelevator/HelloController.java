package com.techelevator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HelloController {

	@RequestMapping(path= {"/","index"}, method=RequestMethod.GET)
	public String displayIndex(ModelMap map) {
		
		map.addAttribute("productList", Product.listAll());
		
		return "index";
	}
	
	@RequestMapping(path="product", method=RequestMethod.GET)
	public String displayProductPage(HttpServletRequest request) {
		String productName = request.getParameter("name");
		Product p = getProductByName(productName);
		
		request.setAttribute("seedDisplay", p);
		
		return "product";
	}
	
	
	
//	@RequestMapping(path="product", method=RequestMethod.POST)
//	public String putProductPageNew(@RequestParam String productName,
//									@RequestParam int quantity,
//									HttpSession session) {
//		Product product = getProductByName(productName);
//		Map<String, Integer> newMap = new HashMap<String, Integer>();
//		newMap.put(product.getName(), quantity);
//		session.setAttribute("cart", newMap);
//		
//		return "product";
//	}
//	
//	@RequestMapping(path="product", method=RequestMethod.POST, params= {"cart","productName", "quantity"})
//	public String putProductPageExisting(@RequestParam String productName,
//										 @RequestParam int quantity,
//										 HttpSession session) {
//		Product product = getProductByName(productName);
//		Map<String, Integer> existingMap = (Map<String,Integer>)session.getAttribute("cart");
//		if(existingMap.containsKey(product.getName())) {
//			existingMap.put(product.getName(), existingMap.get(product.getName())+quantity);
//		} else {
//			existingMap.put(product.getName(),quantity);
//		}
//		return "product";
//	}
	
	@RequestMapping(path="product", method=RequestMethod.POST)
	public String putProductPage(@RequestParam String productName,
								@RequestParam int quantity,
								HttpSession session) {
		Product product = getProductByName(productName);

		try {
			Map<String, Integer> existingMap = (Map<String,Integer>)session.getAttribute("cart");
			if(existingMap.containsKey(product.getName())) {
				existingMap.put(product.getName(), existingMap.get(product.getName())+quantity);
			} else {
				existingMap.put(product.getName(),quantity);
			}
		}catch(Exception e) {
			Map<String, Integer> newMap = new HashMap<String, Integer>();
			newMap.put(product.getName(), quantity);
			session.setAttribute("cart", newMap);
		}
		return "redirect:confirmation?name="+productName+"&value="+quantity;
	}
	
	@RequestMapping(path="cart",method=RequestMethod.GET)
	public String showCart(ModelMap map) {
		map.addAttribute("productList", Product.listAll());
		return "cart";
	
	}

	@RequestMapping(path="confirmation", method=RequestMethod.GET)
	public String showConfirmation() {
		return "confirmation";
	}
	
	
	private Product getProductByName(String productName) {
		for(Product p : Product.listAll()) {
			if(p.getName().equals(productName)) {
				return p;
			}
		}
		
		return null;
	}
	
	
}
