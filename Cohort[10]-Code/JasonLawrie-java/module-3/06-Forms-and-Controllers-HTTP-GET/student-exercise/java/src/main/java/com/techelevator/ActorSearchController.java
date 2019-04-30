package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping(value= {"/actorList","/"}, method=RequestMethod.GET)
	public String showSearchActorForm(ModelMap map) {
		if(map.containsAttribute("Actor")) {
			map.addAttribute("Actor", map.get("Actor"));
		}else {
			map.put("Actor", new Actor());
		}
		
		return "actorList";
	}

	@RequestMapping(value="/actorList", method=RequestMethod.POST)
	public String searchActors(@Valid @ModelAttribute("Actor") Actor theActor,
								BindingResult result,
								RedirectAttributes flash) {
		if(result.hasErrors()) {										//if there were any validation errors do this stuff
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Actor", result);
			flash.addFlashAttribute("Actor", theActor);
			return "redirect:/actorList";
		}
		
		flash.addFlashAttribute("Actors", actorDao.getMatchingActors(theActor.getLastName()));
		return "redirect:/actorList";
	}
}
