package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Card;
import com.techelevator.model.CardDAO;
import com.techelevator.model.Session;

@Controller
public class SessionController {

	@Autowired
	CardDAO cardDAO;

	@RequestMapping(path = "/sessionPage", method = RequestMethod.GET)
	public String sessionPage(@RequestParam Long deckId, @RequestParam int counter, @RequestParam String answer,
			HttpSession session, ModelMap modelHolder, RedirectAttributes redirectAttributes) {
		int newCounter = counter;
		List<Card> studySession;

		if (session.getAttribute("currentList") == null) {
			session.setAttribute("currentList", studySession = cardDAO.getCardByDeckId(deckId));
			session.removeAttribute("correctList");
			session.removeAttribute("incorrectList");
			session.removeAttribute("skippedList");
		} else {
			studySession = (List<Card>) session.getAttribute("currentList");
		}

		Object[] cardArray = studySession.toArray();

		if (answer.equals("correct")) {
			if (session.getAttribute("correctList") == null) {
				List<Card> correctList = new ArrayList<>();
				correctList.add((Card) cardArray[newCounter - 1]);
				session.setAttribute("correctList", correctList);
			} else {
				List<Card> correctList = (List<Card>) session.getAttribute("correctList");
				correctList.add((Card) cardArray[newCounter - 1]);
				session.setAttribute("correctList", correctList);
			}
		} else if (answer.equals("incorrect")) {
			if (session.getAttribute("incorrectList") == null) {
				List<Card> incorrectList = new ArrayList<>();
				incorrectList.add((Card) cardArray[newCounter - 1]);
				session.setAttribute("incorrectList", incorrectList);
			} else {
				List<Card> incorrectList = (List<Card>) session.getAttribute("incorrectList");
				incorrectList.add((Card) cardArray[newCounter - 1]);
				session.setAttribute("incorrectList", incorrectList);
			}
		} else if (answer.equals("skip")) {
			if (session.getAttribute("skippedList") == null) {
				List<Card> skippedList = new ArrayList<>();
				skippedList.add((Card) cardArray[newCounter - 1]);
				session.setAttribute("skippedList", skippedList);
			} else {
				List<Card> skippedList = (List<Card>) session.getAttribute("skippedList");
				skippedList.add((Card) cardArray[newCounter - 1]);
				session.setAttribute("skippedList", skippedList);
			}
		}

		if (newCounter == studySession.size()) {
			redirectAttributes.addAttribute("deckId", deckId);
			return "redirect:/resultsPage";
		}

		modelHolder.put("card", cardArray[newCounter]);
		modelHolder.put("size", cardArray.length);
		modelHolder.put("counter", newCounter);
		modelHolder.put("deckId", deckId);

		return "/sessionPage";
	}

	@RequestMapping(path = "/keywordSession", method = RequestMethod.GET)
	public String displayKeywordSessionPage(@RequestParam Long deckId, @RequestParam String order,
			@RequestParam Long count, @RequestParam String keyword, HttpSession session, ModelMap modelHolder,
			RedirectAttributes redirectAttributes) {

		List<Card> cardList = new ArrayList<>();

		if (!keyword.equals("allKeywords")) {
			cardList = cardDAO.getCardInDeckByKeyword(keyword, deckId);
			for (Card card : cardList) {
				card.setKeyword(cardDAO.getKeywordsByCard(card.getCardId()));
			}
		} else {
			cardList = cardDAO.getCardByDeckId(deckId);
		}

		long end;
		if (count == -1) {
			end = cardList.size();
		} else if (count > cardList.size()) {
			end = cardList.size();
		} else {
			end = count;
		}

		List<Card> currentList = new ArrayList<>();
		int i;
		for (i = 0; i < end; i++) {
			if (order.equals("random")) {
				int index = (int) (Math.random() * end);				
				currentList.add(cardList.get(index));
				cardList.remove(index);
				end = end - 1;
			} else {
				currentList.add(cardList.get(i));
			}
		}
		session.setAttribute("currentList", currentList);
		redirectAttributes.addAttribute("deckId", deckId);
		redirectAttributes.addAttribute("counter", 0);
		redirectAttributes.addAttribute("answer", "We're doing a really nice job");
		return "redirect:/sessionPage";
	}

	@RequestMapping(path = "/resultsPage", method = RequestMethod.GET)
	public String resultsPage(@RequestParam Long deckId, RedirectAttributes redirectAttributes, ModelMap modelHolder) {
		modelHolder.put("deckId", deckId);
		redirectAttributes.addAttribute("deckId", deckId);
		return "/resultsPage";
	}

	@RequestMapping(path = "/reStudy", method = RequestMethod.GET)
	public String reStudy(@RequestParam Long deckId, @RequestParam String answer, HttpSession session,
			ModelMap modelHolder, RedirectAttributes redirectAttributes) {
		if (answer.equals("reStudyCorrect")) {
			session.setAttribute("currentList", session.getAttribute("correctList"));
			session.removeAttribute("correctList");
			session.removeAttribute("incorrectList");
			session.removeAttribute("skippedList");
		} else if (answer.equals("reStudyIncorrect")) {
			session.setAttribute("currentList", session.getAttribute("incorrectList"));
			session.removeAttribute("correctList");
			session.removeAttribute("incorrectList");
			session.removeAttribute("skippedList");
		} else if (answer.equals("reStudySkipped")) {
			session.setAttribute("currentList", session.getAttribute("skippedList"));
			session.removeAttribute("correctList");
			session.removeAttribute("incorrectList");
			session.removeAttribute("skippedList");
		}

		redirectAttributes.addAttribute("deckId", deckId);
		redirectAttributes.addAttribute("counter", 0);
		redirectAttributes.addAttribute("answer", "We're pretty cool guys");

		return "redirect:/sessionPage";
	}

}
