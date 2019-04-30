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
																//Model is just 1 entry, modelMap is manyx
	public String showRegisterForm(Model modelHolder) {			//Define a model called modelHolder
		if( ! modelHolder.containsAttribute("SignUp")) {		//If our model holder does not have sign up attribute,
			modelHolder.addAttribute("SignUp", new SignUp());	//give it one
		}
		return "mailingList";
	}
	
	// POST: /mailingList
	// Validate the model and redirect to confirmation (if successful) 
	// or return the mailingList view (if validation fails)

	@RequestMapping(path="/mailingList", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("SignUp") SignUp registerFormValues,  //validates date in SignUp
											 //puts data in SignUp object called registerFormValues
			BindingResult result,		
			//Data Binding -- binding data to another object, holds result of validation
			RedirectAttributes flash //RedirectAttributes defines a flash object, exists only for next request
	){
		if(result.hasErrors()) {	//if there were any validation errors
			//do stuff below
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "SignUp", result);
			//
			//Use the model key prefix constant in BindingResult concat with SignUp"data from model"
			
			//addFlashAttribute, not addAttribute
			flash.addFlashAttribute("SignUp", registerFormValues);
			//binding the String SignUp to  the SignUp model data
			//add data in the model in the model used in the view
			return "redirect:/mailingList"; //goes to mailingList GET with error messages
		}
		
		flash.addFlashAttribute("message", "You have successfully registered."); //gives you a message
		
		return "redirect:/confirmation";	//goes to confirmation GET
	}
	
	

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "confirmation";
	}
}
