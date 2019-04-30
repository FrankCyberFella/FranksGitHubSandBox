package com.techelevator.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
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

	@RequestMapping(path="register", method=RequestMethod.GET)
	public String showNewUserRegistration(ModelMap regMap) {
		if(!regMap.containsAttribute("Registration")) {
			regMap.addAttribute("Registration", new Registration());
		}
		return "register";
	}
	
	@RequestMapping(path="register", method=RequestMethod.POST)
	public String showRegistrationConfirmation(@Valid @ModelAttribute("Registration") Registration registerFormValues,
												BindingResult result,
												RedirectAttributes flash) {
		if(result.hasErrors()) { 
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);
			flash.addFlashAttribute("Registration", registerFormValues);
			return "redirect:/register"; 
			}
	
		flash.addFlashAttribute("message", "You have successfully registered.");
		return "redirect:/confirmation";
	}
	
	
	@RequestMapping(path="login", method=RequestMethod.GET)
	public String showLogin(ModelMap loginMap) {
		if(!loginMap.containsAttribute("Login")) {
			loginMap.addAttribute("Login", new Login());
		}
		return "login";
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public String showLoginConfirmation(@Valid @ModelAttribute("Login") Login loginFormValues,
										 BindingResult result,
										 RedirectAttributes flash) {
		if(result.hasErrors()) { 
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
			flash.addFlashAttribute("Login", loginFormValues);
			return "redirect:/login"; 
			}
	
		flash.addFlashAttribute("message", "You have successfully logged in.");
		return "redirect:/confirmation";
	}
	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)

	// GET: /login
	// Return the empty login view

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)

	// GET: /confirmation
	// Return the confirmation view
}
