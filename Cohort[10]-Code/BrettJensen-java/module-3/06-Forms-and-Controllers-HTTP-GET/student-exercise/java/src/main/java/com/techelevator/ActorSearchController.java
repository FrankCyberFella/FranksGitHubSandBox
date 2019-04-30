package com.techelevator;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.validation.model.ActorSearch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	
	@RequestMapping(path="/actorList", method=RequestMethod.GET)
	public String showActorsSearch(Model modelHolder) {
		if( ! modelHolder.containsAttribute("ActorSearch")) {
			modelHolder.addAttribute("ActorSearch", new ActorSearch());
		}
		return "actorList";
	}

	@RequestMapping(path="/actorList", method=RequestMethod.POST)
	public String searchActors(@Valid @ModelAttribute("ActorSearch") ActorSearch name,
							  BindingResult result,
							  RedirectAttributes flash, HttpServletRequest request) {
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "ActorSearch", result);
			flash.addFlashAttribute("ActorSearch", name);
			return "redirect:/actorList";
		}
		
		
		List<Actor> actors = actorDao.getMatchingActors(name.getName());
		
		request.setAttribute("actors", actors);
		return "actorList";
	}
}
