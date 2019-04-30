package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Card;
import com.techelevator.model.CardDAO;
import com.techelevator.model.Deck;
import com.techelevator.model.DeckDAO;
import com.techelevator.model.User;

@Controller
public class DeckController {

	private DeckDAO deckDAO;
	@Autowired
	private CardDAO cardDAO;

	@Autowired
	public DeckController(DeckDAO deckDAO) {
		this.deckDAO = deckDAO;
	}

	@RequestMapping(path = "/createNewUserDeck", method = RequestMethod.POST)
	public String createNewUserDeck(@Valid @ModelAttribute Deck newDeck, HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser.getUserName().equals("admin")) {
			deckDAO.saveDeck(newDeck.getDeckName(), newDeck.getDeckDescription(), currentUser.getUserName(), true);
		} else {
			deckDAO.saveDeck(newDeck.getDeckName(), newDeck.getDeckDescription(), currentUser.getUserName(), false);
		}

		return "redirect:/homePage";
	}

	// Should this be in a session controller?
	@RequestMapping(path = "/deckPage", method = RequestMethod.GET)
	public String displayDeckPage(@RequestParam Long deckId, HttpSession session, ModelMap modelHolder) {
		List<Card> cardsWithKeywords = cardDAO.getCardByDeckId(deckId);
		for(Card card: cardsWithKeywords) {
			card.setKeyword(cardDAO.getKeywordsByCard(card.getCardId()));
		}
		modelHolder.put("listOfCardsPerDeck", cardsWithKeywords);
		modelHolder.put("deckId", deckId);
		modelHolder.put("deck", deckDAO.getDeckByDeckID(deckId));
		modelHolder.put("listOfKeywordsByDeck", cardDAO.getKeywordsByDeck(deckId));
		session.removeAttribute("correctList");
		session.removeAttribute("incorrectList");
		session.removeAttribute("skippedList");
		return "/deckPage";

	}

	// Should this be in a session controller?
	@RequestMapping(path = "/deckPagePerKeyword", method = RequestMethod.GET)
	public String displayDeckPagePerKeyword(@RequestParam String userName, @RequestParam Long deckId,
			@RequestParam String keyword, HttpSession session, ModelMap modelHolder) {
		modelHolder.put("listOfCardsPerKeyword", cardDAO.getAllUserCardsByKeyword(userName, keyword));
		modelHolder.put("listOfKeywordsByDeck", cardDAO.getKeywordsByDeck(deckId));
		return "/deckPagePerKeyword";
	}

	@RequestMapping(path = "/modifyDeck", method = RequestMethod.POST)
	public String createNewUserDeck(@RequestParam Long deckId, @RequestParam String deckName,
			@RequestParam String deckDescription, HttpSession session, RedirectAttributes redirectAttributes) {

		deckDAO.modifyDeck(deckId, deckName, deckDescription);
		redirectAttributes.addAttribute("deckId", deckId);

		return "redirect:/deckPage";
	}

	@RequestMapping(path = "/createKeywordDeck", method = RequestMethod.GET)
	public String displayKeywordDeck(@RequestParam String keyword, HttpSession session,
			RedirectAttributes redirectAttributes, ModelMap modelHolder) {

		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser.getUserName().equals("admin")) {
			session.setAttribute("listOfCardsByKeyword", cardDAO.getAllCardsByKeyword(keyword));
			return "/createKeywordDeck";
		}
		session.setAttribute("listOfCardsByKeyword",
				cardDAO.getAllUserCardsByKeyword(keyword, currentUser.getUserName()));
		return "/createKeywordDeck";

	}

	@RequestMapping(path = "/saveKeywordDeck", method = RequestMethod.POST)
	public String createKeywordDeck(@RequestParam String deckName, @RequestParam String deckDescription,
			HttpSession session, RedirectAttributes redirectAttributes, ModelMap modelHolder) {

		User currentUser = (User) session.getAttribute("currentUser");
		String userName = currentUser.getUserName();
		Boolean isPublic = false;
		List<Card> currentList = (List<Card>) session.getAttribute("listOfCardsByKeyword");
		if (userName.equals("admin")) {
			isPublic = true;
		}
		long deckId = deckDAO.saveDeck(deckName, deckDescription, userName, isPublic);
		for (Card card : currentList) {
			cardDAO.addCardToDeck(card.getCardId(), deckId);
		}

		session.removeAttribute("listOfCardsByKeyword");

		return "redirect:/";

	}

}
