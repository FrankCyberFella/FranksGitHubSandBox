package com.techelevator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;
//import com.techelevator.validation.model.Login;

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

	
	
	/* What request mapping do we want here */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showSearchActorForm() {
		return "actorList2";
	}

//	@RequestMapping(path="/actorList", method=RequestMethod.POST)
//	public String displayLoginPage(@Valid @ModelAttribute("Actor") Actor actorLogin,
//									BindingResult result,
//									RedirectAttributes flash) {
//		if (result.hasErrors()) {
//			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Actor", result);
//			flash.addFlashAttribute("Actors", actorLogin);
//			return "redirect:/";
//		}
//		List<Actor> actorList = actorDao.getMatchingActors(actorLogin.getLastName());
//		flash.addFlashAttribute("Actors", actorList);
//		return "redirect:/actorList2";
//	}
	
	/* What about here? */
	@RequestMapping("/actorList")
	public String searchActors(HttpServletRequest request) {
		String lastName = request.getParameter("last_name");
		List<Actor> actorList = actorDao.getMatchingActors(lastName);
		
		request.setAttribute("actors", actorList);
		/* Call the model and pass values to the jsp */
		return "actorList2";
	}
}
