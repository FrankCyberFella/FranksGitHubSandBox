package com.techelevator;

import java.util.List;
import java.util.ArrayList;
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

	@Autowired //No touchie!
	private ActorDao actorDao;

	/* What request mapping do we want here */
	@RequestMapping(path="/actorList", method=RequestMethod.GET)
	public String showSearchActorForm(ModelMap map) {
		if(!map.containsAttribute("Actor")) {
			map.addAttribute("Actor", new Actor());
		}
		return "actorList";
	}
	
	@RequestMapping(path="actorSearchResult", method=RequestMethod.GET)
	public String showActorSearhResult() {
		
		return "actorSearchResult";
	}

	@RequestMapping(path="actorSearchResult", method=RequestMethod.POST)
	public String submitSearchActors(@Valid @ModelAttribute("Actor") Actor searchValues,
								BindingResult result,
								RedirectAttributes flash) {
		if(result.hasErrors()) { 
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Actor", result);
			flash.addFlashAttribute("Actor", searchValues);
			return "redirect:/actorList"; 
		}
		 System.out.println(searchValues);
		 List<Actor> searchActor = actorDao.getMatchingActors(searchValues.getLastName());
		 System.out.print(searchActor.size());
		 flash.addFlashAttribute("actorKey", searchActor);
		 System.out.println("Did the flash thing\n\n\n\n");
		 System.out.flush();
		return "redirect:/actorSearchResult";
	}
	
	
//	@RequestMapping("actorSearchResult")
//	public String searchActors(HttpServletRequest request) {
//		String actorLastName = request.getParameter("lastName");
//		 java.util.List<Actor> searchActor = actorDao.getMatchingActors(actorLastName);
//		 request.setAttribute("actorKey", searchActor);
//		/* Call the model and pass values to the jsp */
//		return "actorSearchResult";
//	}
}
