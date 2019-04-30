package com.techelevator.validation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginScreen(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Login")) {		//If our model holder does not have sign up attribute,
			modelHolder.addAttribute("Login", new Login());	//give it one
		}
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String loginAttempt(@Valid @ModelAttribute("Login") Login login,
								BindingResult result, HttpServletRequest request, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
			flash.addFlashAttribute("Login", login);
			return "redirect:/login";
		}
		request.setAttribute("message", "Congrats, you logged in, good for you.");
		return "confirmation";
	}
	
	@RequestMapping(path="/registration", method=RequestMethod.GET)
	public String getRegistrationScreen(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Registration")) {		//If our model holder does not have sign up attribute,
			modelHolder.addAttribute("Registration", new Registration());	//give it one
		}
		return "registration";
	}
	
	@RequestMapping(path="/registration", method=RequestMethod.POST)
	public String loginAttempt(@Valid @ModelAttribute("Registration") Registration registrationInfo,
								BindingResult result, RedirectAttributes flash, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);
			flash.addFlashAttribute("Registration", registrationInfo);
			return "redirect:/registration";
		}
		request.setAttribute("registrationMessage", "Congrats, you registered, good for you.");
		return "registrationConfirmation";
	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
		public String confirmationScreen() {
		return "confirmation";
	}
	
	@RequestMapping(path="/registrationConfirmation", method=RequestMethod.GET)
	public String registrationConfirmationScreen() {
	return "registrationConfirmation";
}
	

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
}
