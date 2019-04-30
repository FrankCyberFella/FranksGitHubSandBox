package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.CardDAO;
import com.techelevator.model.Deck;
import com.techelevator.model.DeckDAO;

@Controller
public class CardController {

	@Autowired
	CardDAO cardDAO;
	@Autowired
	DeckDAO deckDAO;

	public List<String> getKeywordsForACard(Long cardId) {
		return cardDAO.getKeywordsByCard(cardId);

	}

	@RequestMapping(path = "/getCard", method = RequestMethod.GET)
	public String getCard(@RequestParam Long cardId) {
		cardDAO.getCardById(cardId);

		return "/cardPage";
	}

	@RequestMapping(path = "/createCard", method = RequestMethod.GET)
	public String createCard(@RequestParam Long deckId, ModelMap modelHolder) {
		modelHolder.put("deckId", deckId);
		Deck deck = deckDAO.getDeckByDeckID(deckId);
		String userName = deck.getUserName();
		if (userName.equals("admin")) {
			modelHolder.put("listOfKeywords", cardDAO.getAllKeywords());
		} else {
			modelHolder.put("listOfKeywords", cardDAO.getAllUserKeywords(userName));
		}
		return "/createCard";
	}

	@RequestMapping(path = "/addCard", method = RequestMethod.POST)
	public String addCard(@RequestParam Long deckId, @RequestParam String front, @RequestParam String back,
			@RequestParam String keyword, RedirectAttributes redirectAttributes) {
		long cardId = cardDAO.addCard(front, back);
		cardDAO.addCardToDeck(cardId, deckId);
		if (!keyword.equals("")) {
			cardDAO.addKeywordToCard(keyword, cardId);
		}
		redirectAttributes.addAttribute("deckId", deckId);
		return "redirect:/deckPage";
	}

	@RequestMapping(path = "/modifyCard", method = RequestMethod.GET)
	public String modifyCard(@RequestParam Long deckId, @RequestParam Long cardId, ModelMap modelHolder) {
		List<String> keywordsPerCard = cardDAO.getKeywordsByCard(cardId);
		modelHolder.put("keywordsPerCard", keywordsPerCard);
		modelHolder.put("card", cardDAO.getCardById(cardId));
		modelHolder.put("deckId", deckId);
		return "/modifyCard";
	}

	@RequestMapping(path = "/modifyCardWithKeyword", method = RequestMethod.POST)
	public String modifyCardWithKeyword(@RequestParam Long deckId, @RequestParam Long cardId, ModelMap modelHolder,
			@RequestParam String keyword, @RequestParam String front, @RequestParam String back,
			RedirectAttributes redirectAttributes) {
		if (!keyword.equals("")) {
			cardDAO.addKeywordToCard(keyword, cardId);
		}
		cardDAO.modifyCard(front, back, cardId);
		redirectAttributes.addAttribute("deckId", deckId);
		redirectAttributes.addAttribute("cardId", cardId);

		return "redirect:/modifyCard";
	}

	@RequestMapping(path = "/modifyCardDeleteKeyword", method = RequestMethod.POST)
	public String modifyCardDeleteKeyword(@RequestParam Long deckId, @RequestParam Long cardId, ModelMap modelHolder,
			@RequestParam String keyword, RedirectAttributes redirectAttributes) {
		cardDAO.removeKeywordFromCard(cardId, keyword);
		redirectAttributes.addAttribute("deckId", deckId);
		redirectAttributes.addAttribute("cardId", cardId);

		return "redirect:/modifyCard";
	}

	@RequestMapping(path = "/modifyCard", method = RequestMethod.POST)
	public String updateCard(@RequestParam Long deckId, @RequestParam Long cardId, @RequestParam String front,
			@RequestParam String back, RedirectAttributes redirectAttributes) {
		cardDAO.modifyCard(front, back, cardId);

		redirectAttributes.addAttribute("deckId", deckId);

		return "redirect:/deckPage";
	}

	@RequestMapping(path = "/deleteCard", method = RequestMethod.POST)
	public String deleteCard(@RequestParam Long deckId, @RequestParam Long cardId, HttpSession session,
			ModelMap modelHolder, RedirectAttributes redirectAttributes) {
		cardDAO.deleteCard(cardId);

		redirectAttributes.addAttribute("deckId", deckId);
		return "redirect:/deckPage";
	}

}
