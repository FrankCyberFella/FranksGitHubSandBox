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

	@RequestMapping(path="/registration", method=RequestMethod.GET)
	public String getMainPage(Model modelHolder) {
		if( ! modelHolder.containsAttribute("RegisterUp")) {		//if modelHolder does NOT have SignUp attribute
			modelHolder.addAttribute("RegisterUp", new Registration());	// give it one -> new SignUp object
		}
		return "registration";
}
	
	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	
	@RequestMapping(path="/registration", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("RegisterUp") Registration register,		
			BindingResult result,			
			RedirectAttributes flash		//define flash object (exists for next request only)
	){
		if(result.hasErrors()) {			// if there were any validation errors
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "RegisterUp", result);  //add data to flash object
																				//key-> MODEL_KEY_PREFIX constant+name of model data
																				//value = binding result object from validation
																				//className.SignUp OR UserController.SignUp
			flash.addFlashAttribute("RegisterUp", register);				//add data in model used in view 
			return "redirect:/registration";				
		}
		
		flash.addFlashAttribute("message", "You have successfully registered."); 
			//model names will change but lines 42 through 56 will not change for displaying error messages
		
		return "redirect:/confirmation";
	}

	// GET: /login
	// Return the empty login view
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginPage(Model modelHolder) {
		if( ! modelHolder.containsAttribute("SignUp")) {		//if modelHolder does NOT have SignUp attribute
			modelHolder.addAttribute("SignUp", new Login());	// give it one -> new SignUp object
		}
		return "login";
}

	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String submitLoginForm(
			@Valid @ModelAttribute("SignUp") Login login,		
			BindingResult result,			
			RedirectAttributes flash		//define flash object (exists for next request only)
	){
		if(result.hasErrors()) {			// if there were any validation errors
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "SignUp", result);  //add data to flash object
																				//key-> MODEL_KEY_PREFIX constant+name of model data
																				//value = binding result object from validation
																				//className.SignUp OR UserController.SignUp
			flash.addFlashAttribute("SignUp", login);				//add data in model used in view 
			return "redirect:/login";				
		}
		
		flash.addFlashAttribute("message", "You have successfully registered."); 
			//model names will change but lines 42 through 56 will not change for displaying error messages
		
		return "redirect:/confirmation";
	}

	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String getConfirmationPage() {

		return "confirmation";
}
	
}
