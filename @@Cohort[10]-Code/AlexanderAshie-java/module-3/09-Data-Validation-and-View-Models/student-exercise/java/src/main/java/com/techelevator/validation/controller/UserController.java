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
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	@RequestMapping(path="/newUser", method=RequestMethod.GET)
	public String getRegisternView(Model model) {
		
		if( ! model.containsAttribute("Registration")) {
			model.addAttribute("Registration", new Registration());
		}
		
		return "newUser";
	}

	@RequestMapping(path="/newUser", method=RequestMethod.POST)
	public String submitRegisterDetails(@Valid @ModelAttribute("Login") Registration registrationValues, BindingResult result, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);
			flash.addFlashAttribute("Registration", registrationValues);
			return "redirect:/newUser";
		}
		
		return "redirect:/registerSuccess";
	}

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginView(Model model) {
		
		if( ! model.containsAttribute("Login")) {
			model.addAttribute("Login", new Login());
		}
		
		return "login";
	}

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String submitLoginDetails(@Valid @ModelAttribute("Login") Login loginValues, BindingResult result, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
			flash.addFlashAttribute("Login", loginValues);
			return "redirect:/login";
		}
		
		return "redirect:/loginSuccess";
	}

	@RequestMapping(path="/loginSuccess", method=RequestMethod.GET)
	public String getLoginSoccessView() {
		
		return "loginSuccess";
	}
	
	@RequestMapping(path="/registerSuccess", method=RequestMethod.GET)
	public String getRegisterSoccessView() {
		
		return "registerSuccess";
	}
}
