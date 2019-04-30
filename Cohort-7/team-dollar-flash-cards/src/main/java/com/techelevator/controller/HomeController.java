package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.CardDAO;
import com.techelevator.model.DeckDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class HomeController {

	private UserDAO userDAO;
	@Autowired
	private DeckDAO deckDAO;
	@Autowired
	private CardDAO cardDAO;

	@Autowired
	public HomeController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayInitialPage() {
		return "redirect:/homePage";
	}

	@RequestMapping(path = "/homePage", method = RequestMethod.GET)
	public String displayHomePage(HttpSession session, ModelMap modelHolder) {
		if (session.getAttribute("currentUser") == null) {
			modelHolder.put("listOfPublicDecks", deckDAO.getAllPublicDecks());
			modelHolder.put("listOfAllPublicKeywords", cardDAO.getPublicKeywords());
		} else {
			User currentUser = (User) session.getAttribute("currentUser");
			if (currentUser.getUserName().equals("admin")) {
				modelHolder.put("listOfPublicDecks", deckDAO.getAllPublicDecks());
				modelHolder.put("listOfPrivateDecks", deckDAO.getAllPrivateDecks());
				modelHolder.put("listOfAllKeywords", cardDAO.getAllKeywords());
			} else {
				modelHolder.put("listOfPublicDecks", deckDAO.getAllPublicDecks());
				modelHolder.put("listOfPrivateDecks", deckDAO.getAllUserDecks(currentUser.getUserName()));
				modelHolder.put("listOfAllUserKeyword", cardDAO.getAllUserKeywords(currentUser.getUserName()));
			}
		}
		return "/homePage";
	}

	
}
