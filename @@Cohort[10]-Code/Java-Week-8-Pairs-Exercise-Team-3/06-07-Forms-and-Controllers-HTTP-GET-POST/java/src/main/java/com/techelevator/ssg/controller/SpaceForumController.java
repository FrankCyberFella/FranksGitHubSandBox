package com.techelevator.ssg.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String showForum(HttpServletRequest request) {
		List<ForumPost> forumPost = forumDao.getAllPosts();
		request.setAttribute("postsKey", forumPost);
		return "spaceForum";
	}
	
//	@RequestMapping("/spaceForum")
//	public String showForum(ModelMap map) {
//		map.put("posts",forumDao.getAllPosts());
//		return "spaceForum";
//	}
	
	@RequestMapping(path="/postSpaceForum", method=RequestMethod.GET)
	public String makeAForumPost() {
		return "postSpaceForum";
	}
	
	@RequestMapping(path="/postSpaceForum", method=RequestMethod.POST)
	public String submitForumPost(@RequestParam String userName, @RequestParam String subject, @RequestParam String message) {
		ForumPost post = new ForumPost();
		LocalDateTime datePosted = LocalDateTime.now();
		post.setDatePosted(datePosted);
		post.setMessage(message);
		post.setSubject(subject);
		post.setUsername(userName);
		forumDao.save(post);
		return "redirect:spaceForum";
	}
	
	
}
