package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.AttendeeDAO;
import com.techelevator.model.CookoutDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class AuthenticationController {

	private UserDAO userDAO;
	private CookoutDAO cookoutDAO;
	private AttendeeDAO attendeeDAO;
	// private MenuDAO menuDAO;

	@Autowired
	public AuthenticationController(UserDAO userDAO, CookoutDAO cookoutDAO, AttendeeDAO attendeeDAO) {
		this.userDAO = userDAO;
		this.cookoutDAO = cookoutDAO;
		this.attendeeDAO = attendeeDAO;
	
	}
	@RequestMapping(path= {"/", "/login"}, method=RequestMethod.GET)
	public String displayLoginForm() {
		return "login";
	}
	
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String displayDashboard(HttpSession session, ModelMap modelHolder) {
		User userName = (User) session.getAttribute("currentUser");
		
		session.setAttribute("userCookouts", cookoutDAO.getCookoutByUserNameAndDate(userName.getUserName()));
		modelHolder.put("userCookouts", session.getAttribute("userCookouts"));
		return "dashboard";
	}
	
	@RequestMapping(path="/EmailForm", method=RequestMethod.GET)
	public String displayEmail(ModelMap modelHolder, HttpSession session) {
		int cookoutId = (int)session.getAttribute("cookoutId");
		modelHolder.put("cookout", cookoutId);
		modelHolder.put("emails", attendeeDAO.displayAttendees(cookoutId));
		
		return "EmailForm";
	}
	
	@RequestMapping(path="/Result", method=RequestMethod.GET)
	public String displayResultPage() {
		return "Result";
	}
	@RequestMapping(path="/Result", method=RequestMethod.POST)
	public String returnEmailSender() {
		return "redirect:/Result";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam String userName, 
						@RequestParam String password, 
						@RequestParam(required=false) String destination,
						RedirectAttributes flash,
						HttpSession session) {
		
		if(userDAO.searchForUsernameAndPassword(userName, password)) {
			session.setMaxInactiveInterval(0);
			session.setAttribute("currentUser", userDAO.getUserByUserName(userName));
			session.setAttribute("userCookouts", cookoutDAO.getCookoutByUserNameAndDate(userName));
			
			if(destination != null && ! destination.isEmpty()) {
				return "redirect:" + destination;
			} else {

				return "dashboard";

			}
		} else {
			flash.addFlashAttribute("errorMessage", "Invalid Username / Password");
			return "redirect:/login";
		}
	}

	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		model.remove("currentUser");
		session.invalidate();
		return "redirect:/";
	}
}
