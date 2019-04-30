package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.ActorSearch;



@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping(path="/actorList", method=RequestMethod.GET)
	public String searchActors( Model modelHolder) {
		
		if( ! modelHolder.containsAttribute("ActorSearch")) {		//If our model holder does not have sign up attribute,
			modelHolder.addAttribute("ActorSearch", new ActorSearch());	//give it one
		}
		
		return "actorList";
	}
	
	@RequestMapping(path="/actorList", method=RequestMethod.POST)
	public String searchActors(  @Valid @ModelAttribute("ActorSearch") ActorSearch search,
							   BindingResult result, RedirectAttributes flash
							  ) {
		
		if(result.hasErrors()) {	
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "ActorSearch", result);
			flash.addFlashAttribute("ActorSearch", search);
			return "redirect:/actorList"; //goes to mailingList GET with error messages
		}
		List<Actor> matchingActors = actorDao.getMatchingActors(search.getName());
		flash.addFlashAttribute("actors", matchingActors);
		
		
		return "redirect:/actorList";
	}
	
	
	@RequestMapping("/")
		public String searchActorsDefault(Model modelHolder) {
		modelHolder.addAttribute("ActorSearch", new ActorSearch());
		return "actorList";
	}
	
}
