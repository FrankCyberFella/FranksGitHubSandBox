package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

@Controller
public class UserController {
	// GET: /
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view
	
	@RequestMapping (path="/register", method=RequestMethod.GET)
	public String showLoginPage(Model modelHolder) {  
		if( ! modelHolder.containsAttribute("Register")) {      
			modelHolder.addAttribute("Register", new Registration());  
		}
		return "/login";
	}
	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
		
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String showLogin(@Valid @ModelAttribute("Login") Login registerFormValues, BindingResult result, RedirectAttributes flash){
			if(result.hasErrors()) {
				flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result); 
				flash.addFlashAttribute("Login", registerFormValues); 
				return "redirect:/login";   
			}                                    
			flash.addFlashAttribute("message", "You have successfully logged in."); 
			                     
			return "redirect:/loginSuccess";
		}

	// GET: /login
	// Return the empty login view

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)

	// GET: /confirmation
	// Return the confirmation view
}
