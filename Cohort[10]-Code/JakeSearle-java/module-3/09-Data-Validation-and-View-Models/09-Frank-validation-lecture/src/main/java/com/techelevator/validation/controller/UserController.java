package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.SignUp;

@Controller
public class UserController {
	
	// GET: /
	// Display homePage view with greeting and invitation to sign up for mailing list 
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}
	
	// GET: /mailingList
	// Display empty mailingList view 
	
	@RequestMapping(path="/mailingList", method=RequestMethod.GET)
	public String showRegisterForm(Model modelHolder) {       // define a model called modelHolder
		if( ! modelHolder.containsAttribute("SignUp")) {      // if modelHolder does not have a SignUp attribute,
			modelHolder.addAttribute("SignUp", new SignUp()); // give it one. Which will be a new SignUp object. 
		}
		return "mailingList";
	}
	
	// POST: /mailingList
	// Validate the model and redirect to confirmation (if successful) 
	// or return the mailingList view (if validation fails)

	@RequestMapping(path="/mailingList", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("SignUp") SignUp registerFormValues, // validate the data in model entry SignUp 
			BindingResult result,                                       // and put the data in a SignUp object
			RedirectAttributes flash	// define a flash object		// called registerFormValues 
										// BindingResult result is an object to hold the result of validation
	){
		if(result.hasErrors()) { // if there were any validation errors, do the stuff below
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "SignUp", result); // add data to flash object
			flash.addFlashAttribute("SignUp", registerFormValues); // add data thats in the model used in the view jsp
			return "redirect:/mailingList";   // redirect to /mailingList GET controller
		}                                     // re-display with error message 
		
		flash.addFlashAttribute("message", "You have successfully registered."); 
		                     // if no errors - set a message, then redirect to /confirmation GET controller
		return "redirect:/confirmation";
	}
	
	

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "confirmation";
	}
}
