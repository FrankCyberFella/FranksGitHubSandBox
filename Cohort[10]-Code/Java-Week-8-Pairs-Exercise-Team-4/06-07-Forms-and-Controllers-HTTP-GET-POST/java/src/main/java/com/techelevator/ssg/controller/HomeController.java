package com.techelevator.ssg.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.techelevator.ssg.model.store.AlienAge;
import com.techelevator.ssg.model.store.AlienWeight;
import com.techelevator.ssg.model.store.DriveTime;

@Controller
public class HomeController {

	@Autowired
	ForumDao forumDao;
	
	
	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/alienAge")
	public String calculateAlienAge() {
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeOutput")
	public String displayAlienAge(HttpServletRequest request) {
		String planet = request.getParameter("planet");
		double age = Double.parseDouble(request.getParameter("earthAge"));
		double earthAge = age;
		switch (planet) {
		case "Earth":
			break;
		case "Mercury":
			age = ((age * 100 * 365.25) / 87.96)/100;
			break;
		case "Venus":
			age = ((age * 100 * 365.25) / 224.68)/100;
			break;
		case "Mars":
			age = ((age * 100 * 365.25) / 686.98)/100;
			break;
		case "Jupiter":
			age = ((age * 100) / 11.82)/100;
			break;
		case "Saturn":
			age = ((age * 100) / 29.456)/100;
			break;
		case "Uranus":
			age = ((age * 100) / 84.07)/100;
			break;
		case "Neptune":
			age = ((age * 100) / 164.81)/100;
			break;
		case "Pluto":
			age = ((age * 100) / 247.7)/100;
		}
		
		AlienAge planetAge = new AlienAge(planet,age,earthAge);
		
		request.setAttribute("planet", planetAge);
		return "alienAgeOutput";
	}
	
	@RequestMapping ("/alienWeight")
	public String calculateAlienWeight() {
		return "alienWeight";
	}
	
	@RequestMapping ("/alienWeightOutput")
	public String displayAlienWeight(HttpServletRequest request) {
		String planet = request.getParameter("planet");
		double weight = Double.parseDouble(request.getParameter("earthWeight"));
		double earthWeight = weight;
		switch (planet) {
		case "Earth":
			break;
		case "Mercury":
			weight = (weight / 9.81) * 3.59;
			break;
		case "Venus":
			weight = (weight / 9.81) * 8.87;
			break;
		case "Mars":
			weight = (weight / 9.81) * 3.77;
			break;
		case "Jupiter":
			weight = (weight / 9.81) * 25.95;
			break;
		case "Saturn":
			weight = (weight / 9.81) * 11.08;
			break;
		case "Uranus":
			weight = (weight / 9.81) * 10.67;
			break;
		case "Neptune":
			weight = (weight / 9.81) * 14.07;
			break;
		case "Pluto":
			weight = (weight / 9.81) * .42;
		}
		
		AlienWeight planetWeight = new AlienWeight(earthWeight, weight, planet);
		
		request.setAttribute("planet", planetWeight);
		return "alienWeightOutput";
	}
	
	@RequestMapping("/driveTime") 
		public String calculateDriveTime() {
		return "driveTime";
	}
	
	@RequestMapping("/driveTimeOutput")
	public String displayDriveTime(HttpServletRequest request) {
		String transport = request.getParameter("transport");
		String planet = request.getParameter("planet");
		double endingAge = Double.parseDouble(request.getParameter("earthAge"));
		double startingAge = endingAge; 
		double speed = 0;
		double travelYears = 0;
		
		switch (transport) {
		case "Walking":
			speed = 3;
			break;
		case "Car":
			speed = 100;
			break;
		case "Bullet Train":
			speed = 200;
			break;
		case "Boeing 747":
			speed = 570;
			break;
		case "Concorde":
			speed = 1350;
			break;
				
		}
		
		
		switch (planet) {
		case "Earth":
			break;
		case "Mercury":
			travelYears = (56974146.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Venus":
			travelYears = (25724767.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Mars":
			travelYears = (48678219.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Jupiter":
			travelYears = (390674710.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Saturn":
			travelYears = (792248270.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Uranus":
			travelYears = (1692662530.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Neptune":
			travelYears = (2703959960.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		case "Pluto":
			travelYears = (100000000000000.0/speed)/24/365.25;
			endingAge = startingAge + travelYears;
			break;
		}
		
		DriveTime planetage = new DriveTime(planet, transport, startingAge, endingAge, travelYears);
		
		request.setAttribute("driveTime", planetage);
		return "driveTimeOutput";
		

	}
	
	@RequestMapping(path={"/spaceForum"}, method=RequestMethod.GET)
	public String displaySpacePost(HttpServletRequest request) {
		
		List<ForumPost> posts = new ArrayList<ForumPost>();
		
		posts = forumDao.getAllPosts();
		
		request.setAttribute("posts", posts);
		
		return "spaceForum";
	}
	
	@RequestMapping(path= {"/spaceForum"}, method=RequestMethod.POST)
	public String displayForumInfo(@RequestParam String username,
								   @RequestParam String subject,
								   @RequestParam String message) throws FileNotFoundException, IOException {
		
		ForumPost thePost = new ForumPost();
		
		LocalDateTime date = LocalDateTime.now();
		
		thePost.setMessage(message);
		thePost.setSubject(subject);
		thePost.setUsername(username);
		thePost.setDatePosted(date);
		
		forumDao.save(thePost);
		
		return "homePage";
	}
}
	

