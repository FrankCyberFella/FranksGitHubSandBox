package com.techelevator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;


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

//	@RequestMapping("/")
//	public String showSearchActorForm() {
//		return "actorList";
//	}

	@RequestMapping(path="/actorList", method=RequestMethod.GET)
	public String searchActors(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Actor")) {	
			modelHolder.addAttribute("Actor", new Actor());	
		}
		return "actorList";
	}
	
	@RequestMapping(path="/actorList", method=RequestMethod.POST)
	public String submitRegisterForm(
			@Valid @ModelAttribute("Actor") Actor actorSearch, // validate the data in model entry Sign
																		//  and put the data in a SignUp object called registerFormValues
			BindingResult result,		// object to hold the result of validation
			RedirectAttributes flash	// define a flash object (exist only for the next request)
	){
		if(result.hasErrors()) {															// if there were any validation errors 
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Actor", result);		// add data to flash object
																							// key=MODEL_KEY_PREFIXconstant+name of model data
																							// 				UserController.SignUp
																							// value=BindingResult object from validation
			flash.addFlashAttribute("Actor", actorSearch);							// add the data in the Model used in view
			return "redirect:/actorList";													// redirect to /mailingList GET controller...
		}																					// ... re-display with error message
		
		flash.addFlashAttribute("actors", actorDao.getMatchingActors(actorSearch.getLastName())); 			// if no errors = set a message
		
		return "redirect:/actorList";													// redirect to /confirmation GET controller
	}
}

