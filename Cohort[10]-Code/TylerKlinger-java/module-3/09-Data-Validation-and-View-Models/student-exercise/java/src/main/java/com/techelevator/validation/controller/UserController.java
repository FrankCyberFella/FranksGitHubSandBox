package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;
import com.techelevator.validation.model.SignUp;

@Controller
public class UserController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String getNewRegister() {
		return "register";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getUserLogin() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("Log In") Login registerFormValues, //validate the data in model entry SignUp and put it in SignUp object
			BindingResult result, //object to hold the result of validation
			RedirectAttributes flash //define a flash object (exists only for next request)
	){
		if(result.hasErrors()) { // if there were any validation errors...
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Log In", result); // add data to flash object
			flash.addFlashAttribute("Log In", registerFormValues); // add the data in the Model used in view
																	//key=MODEL_KEY+PREFIX constant+name of model data
																	// className.SignUp
																	//value=BindingResult object from validation
			return "redirect:/login";	//redirects to /mailingList url GET controller
		}									// re-display with error messages
		
		flash.addFlashAttribute("message", "Welcome!"); //if no errors = set a message
		
		return "redirect:/confirmation"; //redirect to /confirmation GET controller
	}
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("Log In") Registration registerFormValues, //validate the data in model entry SignUp and put it in SignUp object
			BindingResult result, //object to hold the result of validation
			RedirectAttributes flash //define a flash object (exists only for next request)
	){
		if(result.hasErrors()) { // if there were any validation errors...
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Register", result); // add data to flash object
			flash.addFlashAttribute("Register", registerFormValues); // add the data in the Model used in view
																	//key=MODEL_KEY+PREFIX constant+name of model data
																	// className.SignUp
																	//value=BindingResult object from validation
			return "redirect:/register";	//redirects to /mailingList url GET controller
		}									// re-display with error messages
		
		flash.addFlashAttribute("message", "Welcome!"); //if no errors = set a message
		
		return "redirect:/confirmation"; //redirect to /confirmation GET controller
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
