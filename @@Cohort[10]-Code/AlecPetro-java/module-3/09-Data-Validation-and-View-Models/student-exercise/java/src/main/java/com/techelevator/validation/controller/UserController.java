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
	public String getMainScreen(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Login")) {
			modelHolder.addAttribute("Login", new Login());
		}
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String showRegisterForm(Model modelHolder) { 	// Define a Model called modelHolder
		if( ! modelHolder.containsAttribute("Register")) {	// if modelHolder does not have a SignUp attribute...
			modelHolder.addAttribute("Register", new Registration());	// ... give it one - new SignUp Object
		}
		return "register";
	}
	


	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("Register") Registration registerFormValues, // validate the data in model entry Sign
																		//  and put the data in a SignUp object called registerFormValues
			BindingResult result,		// object to hold the result of validation
			RedirectAttributes flash	// define a flash object (exist only for the next request)
	){
		if(result.hasErrors()) {															// if there were any validation errors 
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Register", result);		// add data to flash object
																							// key=MODEL_KEY_PREFIXconstant+name of model data
																							// 				UserController.SignUp
																							// value=BindingResult object from validation
			flash.addFlashAttribute("Register", registerFormValues);							// add the data in the Model used in view
			return "redirect:/register";													// redirect to /mailingList GET controller...
		}																					// ... re-display with error message
		
		flash.addFlashAttribute("message", "You have successfully registered."); 			// if no errors = set a message
		
		return "redirect:/confirmation2";													// redirect to /confirmation GET controller
	}
	

	// GET: /login
	// Return the empty login view
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginPage(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Login")) {
			modelHolder.addAttribute("Login", new Login());
		}
		return "login";
	}

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String submitLoginForm(
			@Valid @ModelAttribute("Login") Login registerFormValues, // validate the data in model entry Sign
																		//  and put the data in a SignUp object called registerFormValues
			BindingResult result,		// object to hold the result of validation
			RedirectAttributes flash	// define a flash object (exist only for the next request)
	){
		if(result.hasErrors()) {															// if there were any validation errors 
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);		// add data to flash object
																							// key=MODEL_KEY_PREFIXconstant+name of model data
																							// 				UserController.SignUp
																							// value=BindingResult object from validation
			flash.addFlashAttribute("Login", registerFormValues);							// add the data in the Model used in view
			return "redirect:/login";													// redirect to /mailingList GET controller...
		}																					// ... re-display with error message
		
		flash.addFlashAttribute("message", "You have successfully logged in."); 			// if no errors = set a message
		
		return "redirect:/confirmation";													// redirect to /confirmation GET controller
	}

	// GET: /confirmation
	// Return the confirmation view
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "confirmation";
	}
	
	@RequestMapping(path="/confirmation2", method=RequestMethod.GET)
	public String showConfirmation2View() {
		return "confirmation2";
	}
}
