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
	public String showRegisterForm(Model modelHolder) {
		if( ! modelHolder.containsAttribute("SignUp")) {		//if modelHolder does NOT have SignUp attribute
			modelHolder.addAttribute("SignUp", new SignUp());	// give it one -> new SignUp object
		}
		return "mailingList";
	}
	
	// POST: /mailingList
	// Validate the model and redirect to confirmation (if successful) 
	// or return the mailingList view (if validation fails)

	@RequestMapping(path="/mailingList", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("SignUp") SignUp registerFormValues,		
			BindingResult result,			
			RedirectAttributes flash		//define flash object (exists for next request only)
	){
		if(result.hasErrors()) {			// if there were any validation errors
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "SignUp", result);  //add data to flash object
																				//key-> MODEL_KEY_PREFIX constant+name of model data
																				//value = binding result object from validation
																				//className.SignUp OR UserController.SignUp
			flash.addFlashAttribute("SignUp", registerFormValues);				//add data in model used in view 
			return "redirect:/mailingList";				
		}
		
		flash.addFlashAttribute("message", "You have successfully registered."); 
			//model names will change but lines 42 through 56 will not change for displaying error messages
		
		return "redirect:/confirmation";
	}
	
	

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationView() {
		return "confirmation";
	}
}
