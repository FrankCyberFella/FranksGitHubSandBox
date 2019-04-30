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
	
	@RequestMapping(path="register", method=RequestMethod.GET)
	public String getRegisterView(Model registerHolder) {
		if(! registerHolder.containsAttribute("Registration")) {
			registerHolder.addAttribute("Registration", new Registration());
		}
		return "register";
	}

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	@RequestMapping(path="register", method=RequestMethod.POST)
	public String submitLogin(
			@Valid @ModelAttribute("Registration") Registration newRegister,
			BindingResult result,
			RedirectAttributes flash
		) {
			if(result.hasErrors()) {
				flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);
				flash.addFlashAttribute("Registration", newRegister);
				return "redirect:/register";
			}
			flash.addFlashAttribute("message", "You have successfully registered.");
			return "redirect:/registerConfirmation";
	}
	// GET: /confirmation
	// Return the confirmation view

	@RequestMapping(path="registerConfirmation", method=RequestMethod.GET)
	public String showrRegistrationConfirmationView() {
		return "registerConfirmation";
	}
	
	
	
	
	// GET: /login
	// Return the empty login view
	@RequestMapping(path="login", method=RequestMethod.GET)
	public String getLoginView(Model loginHolder) {
		if(! loginHolder.containsAttribute("Login")) {
			loginHolder.addAttribute("Login", new Login());
		}
		return "login";
	}
	

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	@RequestMapping(path="login", method=RequestMethod.POST)
	public String submitLogin(
			@Valid @ModelAttribute("Login") Login loginUser,
			BindingResult result,
			RedirectAttributes flash
		) {
			if(result.hasErrors()) {
				flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
				flash.addFlashAttribute("Login", loginUser);
				return "redirect:/login";
			}
			flash.addFlashAttribute("message", "You have successfully logged in.");
			return "redirect:/loginConfirmation";
	}
	// GET: /confirmation
	// Return the confirmation view

	@RequestMapping(path="loginConfirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "loginConfirmation";
	}
	
}
