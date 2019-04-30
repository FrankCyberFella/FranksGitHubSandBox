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
	@RequestMapping(path="/registrationView", method=RequestMethod.GET)
	public String showRegistrationView(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Registration")) {
			modelHolder.addAttribute("Registration", new Registration());
		}
		return "registrationView";
	}

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	@RequestMapping(path="/registrationView", method=RequestMethod.POST)
	public String submitRegistration(
			@Valid @ModelAttribute("Registration") Registration registerFormValues,
			BindingResult result,
			RedirectAttributes flash
	){
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);
			flash.addFlashAttribute("Registration", registerFormValues);
			return "redirect:/registrationView";
		}
		
		flash.addFlashAttribute("message", "You have successfully registered.");
		
		return "redirect:/confirmation";
	}

	// GET: /login
	// Return the empty login view
	@RequestMapping(path="/loginView", method=RequestMethod.GET)
	public String showLoginView(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Login")) {
			modelHolder.addAttribute("Login", new Login());
		}
		return "loginView";
	}

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	@RequestMapping(path="/loginView", method=RequestMethod.POST)
	public String submitLogin(
			@Valid @ModelAttribute("Login") Login loginValues,
			BindingResult result,
			RedirectAttributes flash
	){
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
			flash.addFlashAttribute("Login", loginValues);
			return "redirect:/loginView";
		}
		
		flash.addFlashAttribute("message", "You have successfully registered.");
		
		return "redirect:/confirmation";
	}

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "confirmation";
	}
}
