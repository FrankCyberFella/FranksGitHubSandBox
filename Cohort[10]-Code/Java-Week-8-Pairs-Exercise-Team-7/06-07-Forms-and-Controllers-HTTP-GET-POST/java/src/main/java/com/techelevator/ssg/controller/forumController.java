package com.techelevator.ssg.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class forumController {

	@Autowired
	private ForumDao forumDao;
	
	@RequestMapping(path = "/spaceForum", method=RequestMethod.GET)
	public String showSpaceForum(HttpServletRequest request) {
		
		List<ForumPost> forumPosts = forumDao.getAllPosts();
		
		request.setAttribute("forumPosts", forumPosts);
		
		return "spaceForum";
	}
	
	@RequestMapping(path = "/spaceForumInput", method=RequestMethod.GET)
	public String showSpaceForumInput() {
		
		return "spaceForumInput";
	}
	
	@RequestMapping(path = "/spaceForumInput", method=RequestMethod.POST)
	public String sendSpaceForumInput(@RequestParam String username,
			 @RequestParam String subject,
			 @RequestParam String message) throws FileNotFoundException, IOException {
			LocalDateTime now = LocalDateTime.now();
		
			ForumPost post = new ForumPost();
			post.setUsername(username);
			post.setMessage(message);
			post.setSubject(subject);
			post.setDatePosted(now);
		
			forumDao.save(post);
			

/* If the String returned by a handler method starts with "redirect:", this causes Spring
* to send an HTTP 3xx redirect response to the client. In this case, the value following 
* "redirect:" is treated as an HTTP resource and **NOT** a logical view name. */
return "redirect:/spaceForum";
	}
	
	
	
}
