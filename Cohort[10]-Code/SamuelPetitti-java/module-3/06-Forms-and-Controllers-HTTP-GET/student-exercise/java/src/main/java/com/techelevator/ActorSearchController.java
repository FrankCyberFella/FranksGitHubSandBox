package com.techelevator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.validation.model.ActorSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	/* What request mapping do we want here */
	@RequestMapping({"/", "/actorList"})
	public String showSearchActorForm() {
		return "actorList";
	}
	
	@RequestMapping(path= "searchActors", method=RequestMethod.POST)
	public String getActorSearch(
			@Valid @ModelAttribute("ActorValidationModel") ActorSearch newActor,
			BindingResult result,
			RedirectAttributes flash
			) {
			if(result.hasErrors()) {
				flash.addAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);
				flash.addAttribute("ActorValidationModel", newActor);
				return "redirect:/register";
			}
			return "redirect:/register";
	}
	
	
	/* What about here? */
	@RequestMapping("/searchActors")
	public String showSearchActorResult(HttpServletRequest request) {
		/* Call the model and pass values to the jsp */
		String actor = request.getParameter("actor");
		List <Actor> actors = actorDao.getMatchingActors(actor);
		request.setAttribute("actors", actors);
		return "actorList";
	}
}


