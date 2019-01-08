package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.bouncycastle.asn1.ocsp.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Cookout;
import com.techelevator.model.CookoutDAO;
import com.techelevator.model.MenuDAO;
import com.techelevator.model.Order;
import com.techelevator.model.OrderDAO;

@Controller
public class OrderController {
	
	private OrderDAO orderDAO;
	private CookoutDAO cookoutDAO;
	private MenuDAO menuDAO;

	
	@Autowired
	public OrderController(OrderDAO orderDAO, CookoutDAO cookoutDAO, MenuDAO menuDAO) {
		this.orderDAO = orderDAO;
		this.cookoutDAO = cookoutDAO;
		this.menuDAO = menuDAO;
	}
	
	// Displays the order page with only "grillable" items listed
	@RequestMapping(path="/order", method=RequestMethod.GET)
	public String showOrderPage(ModelMap modelholder, HttpSession session) { 
		modelholder.put("grillOptions", menuDAO.displayGrillableCookoutMenu((int)session.getAttribute("cookoutId")));
		
		return "/order";
	}
	
	
	// Method to submit Grill order. Pulls cookoutId from session to add user simplicity.
	@RequestMapping(path="/order", method=RequestMethod.POST)
	public String submitGrillOrder(@RequestParam int[] itemId,
								  @RequestParam int[] quantity,
								  @RequestParam String[] comments,
								  @RequestParam String orderName,
								  HttpSession session,
								  RedirectAttributes flashScope) {
		orderDAO.addOrderItems(orderName, (int)session.getAttribute("cookoutId"), itemId, comments, quantity);
		
		return "redirect:/details?cookoutId="+ (int)session.getAttribute("cookoutId");
	}
	
	
	
	// Gives the chef a view of all of the orders as well as a summary of orders.
	@RequestMapping(path="/chefSummary", method=RequestMethod.GET)
	public String showOrders(ModelMap modelHolder, HttpSession session) {
		modelHolder.put("orderList", orderDAO.displayOrders((int)session.getAttribute("cookoutId")));
		modelHolder.put("orderSummary", orderDAO.showOrderSummary((int)session.getAttribute("cookoutId")));
		return "/chefSummary";
	}
	
	
	@RequestMapping(path="/chefSummary", method=RequestMethod.POST)
	public String updateOrderStatus(@RequestParam int[] orderId, HttpSession session) {
		orderDAO.completeOrder(orderId);
	
		return "redirect:/chefSummary?cookoutId="+ (int)session.getAttribute("cookoutId");

	}
	
}

