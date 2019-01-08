package com.techelevator.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class UserController {

	private UserDAO userDAO;
	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm(ModelMap model) {
		if(!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		return "newUser";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user,
			BindingResult result,
			HttpSession session,
			RedirectAttributes flash) {
		//map to ensure data is being collected
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getPassword());
		System.out.println(user.getUserName());
		System.out.println(user.getRole());

		if(result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/users/" + user.getUserName();
		}
		
		userDAO.saveUser(user.getFirstName(), 
						 user.getLastName(),
						 user.getUserName(),
						 user.getPassword());
		session.setAttribute("currentUser", user);	
		flash.addFlashAttribute("message", "Account creation successful.");
		return "dashboard";
	}
	
	@RequestMapping(path="/users/changePassword", method=RequestMethod.POST)
	public String updatePassword(@Valid @ModelAttribute User user,
			BindingResult result,
			HttpSession session,
			RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			return "redirect:/changePassword";
		}
		
		userDAO.updatePassword(((User)session.getAttribute("currentUser")).getUserName(),
							  user.getConfirmPassword());
		return "redirect:/dashboard/";
		
	}
	
	@RequestMapping(path="/changePassword", method=RequestMethod.GET)
	public String displayPasswordChanged(ModelMap model) {
		if(!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		return "changePassword";
	}
}
