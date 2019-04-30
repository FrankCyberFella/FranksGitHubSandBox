package com.techelevator.ssg.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

import Model.AlienAgeCalculator;
import Model.AlienTravelCalculator;
import Model.AlienWeightCalculator;

@Controller
public class HomeController {
	
	@Autowired
	private ForumDao forumDao;
	
	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}

	@RequestMapping("/alienAgeInput")
	public String showAlienAgeInputpage() {
		return "alienAgeInput";
	}

	@RequestMapping("/alienAgeResult")
	public String showAlienAgeResults(HttpServletRequest request) {
		int earthAge = Integer.parseInt(request.getParameter("earthAgeValue"));
		String planet = request.getParameter("planetChoiceValue");

		AlienAgeCalculator alienAgeCalc = new AlienAgeCalculator(earthAge, planet);
		request.setAttribute("ageValue", alienAgeCalc.getPlanetAge());

		return "alienAgeOutput";
	}

	@RequestMapping("/alienWeightInput")
	public String showAlienWeightInput(HttpServletRequest request) {
		return "alienWeightInput";
	}

	@RequestMapping("/alienWeightOutput")
	public String showAlienWeightResults(HttpServletRequest request) {

		int earthWeight = Integer.parseInt(request.getParameter("earthWeightValue"));
		String planet = request.getParameter("planetChoiceValue");

		AlienWeightCalculator alienWeightCalc = new AlienWeightCalculator(earthWeight, planet);
		request.setAttribute("weightValue", alienWeightCalc.getAlienWeight());

		return "alienWeightOutput";
	}

	@RequestMapping("/driveTimeInput")
	public String showDriveTimeInput() {
		return "driveTimeInput";
	}

	@RequestMapping("/driveTimeOutput")
	public String showTravelTimeResults(HttpServletRequest request) {
		int earthAge = Integer.parseInt(request.getParameter("earthAgeValue"));
		String planet = request.getParameter("planetChoiceValue");
		String trans = request.getParameter("transValue");

		AlienTravelCalculator alienTravelCalc = new AlienTravelCalculator(earthAge, planet, trans);
		request.setAttribute("finalAgeValue", alienTravelCalc.getFinalAge());
		request.setAttribute("travelYears", alienTravelCalc.getTravelYears());
		request.setAttribute("planet", alienTravelCalc.getPlanet());
		request.setAttribute("trans", alienTravelCalc.getTrans());
		return "driveTimeOutput";

	}

	@RequestMapping("/forumPosting")
	public String showForumPosting() {
		return "forumPosting";
	}

	@RequestMapping(path = "/forumPosting", method = RequestMethod.POST)
	public String saveForumPost(@RequestParam String userName, @RequestParam String subject,
								@RequestParam String message) {

		ForumPost post = new ForumPost();
		post.setUsername(userName);
		post.setSubject(subject);
		post.setMessage(message);
		//post.setDatePosted(LocalDateTime.now("post_date"));
		post.setDatePosted(LocalDateTime.now());
		forumDao.save(post);

		return "redirect: forumListing";
	}
	@RequestMapping("/forumListing")
	public String showForumListing(HttpServletRequest request) {
		List<ForumPost> forumPost = new ArrayList<>();
		forumPost = forumDao.getAllPosts();
		request.setAttribute("posts", forumPost);
		
		return "forumListing";
	}

}