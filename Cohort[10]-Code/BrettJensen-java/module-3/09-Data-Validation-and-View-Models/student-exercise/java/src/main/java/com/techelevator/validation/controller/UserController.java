package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;

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
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String getNewUser() {
		return "newUser";
	}
	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)

	// GET: /login
	// Return the empty login view
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLogin(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Login")) {
			modelHolder.addAttribute("Login", new Login());
		}
	
		return "login";
	}
	// POST: /login
	// Validate the model and redirect to login (if successful) or return the
	// login view (if validation fails)
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String getValidateLogin(@Valid @ModelAttribute("Login") Login login,
	        BindingResult result,
	        RedirectAttributes flash) {
		
		if(result.hasErrors()) {
            flash.addFlashAttribute("login", login);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "login", result);
             return "redirect:/login";
        }
		
        return "redirect:/confirmation";
	}
	// GET: /confirmation
	// Return the confirmation view
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmation() {
		
		return "confirmation";
	}
}
