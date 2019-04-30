package com.techelevator.ssg.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class SpaceForumController {
	
	@Autowired
	private ForumDao forumDao;

	@RequestMapping(path="/spaceForum", method=RequestMethod.GET)
	public String showSpaceForum(ModelMap map) {
		
		map.put("posts", forumDao.getAllPosts());
		
		return "spaceForum";
	}
	
	@RequestMapping("/spaceForumInput")
	public String showSpaceForumInput() {
		return "spaceForumInput";
	}
	
	@RequestMapping(path="/spaceForumInput", method=RequestMethod.POST)
	public String postToSpaceForum(@RequestParam String subject, @RequestParam String username, @RequestParam String message) {
		
		ForumPost posty = new ForumPost();
		
		posty.setDatePosted(LocalDateTime.now());
		posty.setMessage(message);
		posty.setSubject(subject);
		posty.setUsername(username);
		
		forumDao.save(posty);
		
		return "redirect:/spaceForum";
	}
	
	
}