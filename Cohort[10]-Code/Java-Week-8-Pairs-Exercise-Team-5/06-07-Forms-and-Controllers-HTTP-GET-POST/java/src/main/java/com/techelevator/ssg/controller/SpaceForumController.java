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
public class SpaceForumController {
	
@Autowired ForumDao forumDao; 	
	
        @RequestMapping("/spaceForumInput")
		public String showSpaceForumPage(){
			return "spaceForumInput";
		}
        
       
        
        @RequestMapping(path= "/spaceForumOutput", method=RequestMethod.POST)
        public String processSpaceForumInput(@RequestParam String username,
        									 @RequestParam String subject,
        									 @RequestParam String message)
        									throws FileNotFoundException, IOException {
        	LocalDateTime now = LocalDateTime.now();
        	ForumPost post = new ForumPost();
        	post.setDatePosted(now);
        	post.setMessage(message);
        	post.setSubject(subject);
        	post.setUsername(username);
        	forumDao.save(post);
        	return "redirect:/spaceForumOutput";
        }
        
       
        @RequestMapping(path="/spaceForumOutput", method=RequestMethod.GET)
        public String showForumOutput(HttpServletRequest request) {
        	List <ForumPost> forumPost = forumDao.getAllPosts();
        	request.setAttribute("forumPost", forumPost);
        	return "spaceForumOutput";
       }
}
