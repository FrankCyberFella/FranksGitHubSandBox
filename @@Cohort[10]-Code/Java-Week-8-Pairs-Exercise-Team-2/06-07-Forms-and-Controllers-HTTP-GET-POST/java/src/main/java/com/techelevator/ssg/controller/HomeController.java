package com.techelevator.ssg.controller;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.planets.PlanetAge;
import com.techelevator.ssg.model.planets.PlanetDistance;
import com.techelevator.ssg.model.planets.PlanetGravity;
import java.util.List;
@Controller
public class HomeController {
@Autowired
private ForumDao forumDao;

	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/alienWeightInput")
	public String showAlienWeightInput() {
		return "alienWeightInput";
	}
	
	@RequestMapping("/alienWeightResult")
	public String showAlienWeightResult(HttpServletRequest request) {
		
		String selectPlanet = request.getParameter("selectPlanet");
		int earthWeight = Integer.parseInt(request.getParameter("earthWeight"));
		PlanetGravity weight = new PlanetGravity();
		double calculation = weight.planetWeightCalculation(earthWeight, selectPlanet);
		request.setAttribute("weight", calculation);
		
		return "alienWeightResult";
	}
	
	@RequestMapping("/alienAgeInput")
	public String showAlienAgeInput() {
		return "alienAgeInput";
	}
	
	@RequestMapping("/alienAgeResult")
	public String showAlienAgeResult(HttpServletRequest request) {
		
		String selectPlanet = request.getParameter("selectPlanet");
		int earthAge = Integer.parseInt(request.getParameter("earthAge"));
		PlanetAge age = new PlanetAge();
		double calculation = age.planetAgeCalculation(earthAge, selectPlanet);
		request.setAttribute("age", calculation);
		
		return "alienAgeResult";
	}
	
	@RequestMapping("/alienDriveTimeInput")
	public String showAlienDriveTimeInput() {
		return "alienDriveTimeInput";
	}
	
	@RequestMapping("/alienDriveTimeResult")
	public String showAlienDriveTimeResult(HttpServletRequest request) {
		
		String selectPlanet = request.getParameter("selectPlanet");
		String selectVehicle = request.getParameter("selectVehicle");
		int earthAge = Integer.parseInt(request.getParameter("earthAge"));
		PlanetDistance distance = new PlanetDistance();
		double calculation = distance.planetDistanceCalculation(selectPlanet, selectVehicle);
		request.setAttribute("years", calculation);
		
		return "alienDriveTimeResult";
	}
	
	@RequestMapping("/spaceForumInput")
	public String showSpaceForumInput() {
		return "spaceForumInput";
	}
	
	@RequestMapping(path="/spaceForumOutput", method=RequestMethod.POST)
	public String processSpaceForumPost(@RequestParam String userName,
										@RequestParam String subject,
										@RequestParam String message)
										throws FileNotFoundException, IOException {
	LocalDateTime now = LocalDateTime.now();
	ForumPost post = new ForumPost();
	post.setUsername(userName);
	post.setSubject(subject);
	post.setMessage(message);
	post.setDatePosted(now);
	forumDao.save(post);
	return "redirect:/spaceForumOutput";
	}
	
	@RequestMapping(path="/spaceForumOutput", method=RequestMethod.GET)
	public String showForumOutput(HttpServletRequest request) {
		List<ForumPost> forumPost = new ArrayList<>();
		forumPost = forumDao.getAllPosts();
		request.setAttribute("posts", forumPost);
		return "spaceForumOutput";
	}

}
	