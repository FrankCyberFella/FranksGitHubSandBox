package com.techelevator;

import java.util.Map;
import javax.validation.Valid;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.actorSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	/* What request mapping do we want here */
	@RequestMapping(path= {"/","/actorList"}, method=RequestMethod.GET)
	public String showSearchActorForm(Model modelHolder) {
		if( ! modelHolder.containsAttribute("ActorSearch")) {		
			modelHolder.addAttribute("ActorSearch", new actorSearch());	
		}
		return "actorList";
	}


	/* What about here? */
	@RequestMapping(path= {"/actorList"}, method=RequestMethod.POST)
	public String searchActors(@Valid @ModelAttribute("ActorSearch") actorSearch name,
		//Took out httpservletrequest param, run in debug to figure out why it worked
	BindingResult result,
	RedirectAttributes flash) {
		/* Call the model and pass values to the jsp */
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX +"ActorSearch", result);
			flash.addFlashAttribute("ActorSearch", name);
			return "redirect:/actorList";
		}
		flash.addFlashAttribute("actors", actorDao.getMatchingActors(name.getName()));
		return "redirect:/actorList";
		
	}
	

}
