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
	// Display homePage vie wwith greeting and invitation to sign up for mailing list 
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}
	
	// GET: /mailingList
	// Display empty mailingList view 
	
	@RequestMapping(path="/mailingList", method=RequestMethod.GET)
	public String showRegisterForm(Model modelHolder) { // Defines a Model called modelHolder
		if( ! modelHolder.containsAttribute("SignUp")) { // If modelHolder does NOT have a SignUp attribute...
			modelHolder.addAttribute("SignUp", new SignUp()); //...give it one - new SignUp Object
		}
		return "mailingList";
	}
	
	// POST: /mailingList
	// Validate the model and redirect to confirmation (if successful) 
	// or return the mailingList view (if validation fails)

	@RequestMapping(path="/mailingList", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("SignUp") SignUp registerFormValues, //validate the data in model entry SignUp and put it in SignUp object
			BindingResult result, //object to hold the result of validation
			RedirectAttributes flash //define a flash object (exists only for next request)
	){
		if(result.hasErrors()) { // if there were any validation errors...
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "SignUp", result); // add data to flash object
			flash.addFlashAttribute("SignUp", registerFormValues); // add the data in the Model used in view
																	//key=MODEL_KEY+PREFIX constant+name of model data
																	// className.SignUp
																	//value=BindingResult object from validation
			return "redirect:/mailingList";	//redirects to /mailingList url GET controller
		}									// re-display with error messages
		
		flash.addFlashAttribute("message", "You have successfully registered."); //if no errors = set a message
		
		return "redirect:/confirmation"; //redirect to /confirmation GET controller
	}
	
	

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "confirmation";
	}
}
