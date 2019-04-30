package com.techelevator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	/* What request mapping do we want here */
	@RequestMapping("/")
	public String searchActorsDefault() {

		return "actorList";
	}
	@RequestMapping(path="actorList", method=RequestMethod.GET)
	public String searchActors(HttpServletRequest request){
		
		return "actorList";
	}
	
	@RequestMapping(path="/actorList", method=RequestMethod.POST)
	public String postActorList(@RequestParam String name, ModelMap modelHandler) {
		System.out.println(name);
		List<Actor> matchingActors = actorDao.getMatchingActors(name);
		modelHandler.put("actors", matchingActors);
		
		System.out.println(name);
		
		return "actorList";
	}
}

