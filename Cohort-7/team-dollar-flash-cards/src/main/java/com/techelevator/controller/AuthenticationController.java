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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class AuthenticationController {

	private UserDAO userDAO;

	@Autowired
	public AuthenticationController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String displayLoginForm() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String password,
			@RequestParam(required = false) String destination, HttpSession session, RedirectAttributes flash) {
		if (userDAO.searchForUsernameAndPassword(userName, password)) {
			session.setAttribute("currentUser", userDAO.getUserByUserName(userName));

			if (destination != null && !destination.isEmpty()) {
				return "redirect:" + destination;
			} else {
				return "redirect:/homePage";
			}
		} else {
			flash.addFlashAttribute("message", "Login Failed");
			return "redirect:/login";
		}
	}

	@RequestMapping(path = "/users/changePassword", method = RequestMethod.GET)
	public String getNewPassword(HttpSession session) {
		return "/changePassword";
	}

	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@Valid @RequestParam String currentPassword, @RequestParam String newPassword,
			HttpSession session, RedirectAttributes flash, ModelMap model) {
		User currentUser = (User) session.getAttribute("currentUser");
		if (userDAO.searchForUsernameAndPassword(currentUser.getUserName(), currentPassword)) {
			userDAO.updatePassword(currentUser.getUserName(), newPassword);
			model.remove("currentUser");
			session.invalidate();
			flash.addFlashAttribute("message", "You have successfully changed your password");
			return "redirect:/login";
		} else {
			flash.addFlashAttribute("message", "Sorry, the current password was incorect");
			return "redirect:/users/changePassword";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, RedirectAttributes flash) {
		session.invalidate();
		flash.addFlashAttribute("message", "You have been logged out");
		return "redirect:/homePage";
	}
	
}
