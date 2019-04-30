package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {
	// GET: /
	@RequestMapping(path= {"/","/homePage"}, method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginPage(Model model) {
		if (! model.containsAttribute("Login")) {
			model.addAttribute("Login", new Login()); 
		}

		return "LoginInput";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String displayLoginPage(@Valid @ModelAttribute("Login") Login registerLogin,
									BindingResult result,
									RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
			flash.addFlashAttribute("Login", registerLogin);
			return "redirect:/login";
		}
		flash.addFlashAttribute("SignUp", registerLogin);
		return "redirect:/confirmation";
	}
	
	@RequestMapping("/confirmation")
	public String displayConfirmation() {
		return "confirmation";
	}
	
	@RequestMapping(path="/newUser", method=RequestMethod.GET)
	public String getNewUserPage(Model model) {
		if (!model.containsAttribute("registration")) {
			model.addAttribute("registration", new Registration());
		}
		return "newUser";
	}
	
	@RequestMapping(path="/newUser", method=RequestMethod.POST)
	public String displayLoginPage(@Valid @ModelAttribute("registration") Registration registerUser,
									BindingResult result,
									RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "registration", result);
			flash.addFlashAttribute("registration", registerUser);
			return "redirect:/newUser";
		}
		flash.addFlashAttribute("registration", registerUser);
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
