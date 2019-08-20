package com.survivorpoolcle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.survivorpoolcle.authentication.AuthProvider;
//import com.survivorpoolcle.authentication.UnauthorizedException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {

//	@Autowired
//    private AuthProvider authProvider;
//
//    @RequestMapping(path="/", method=RequestMethod.GET)
//    public String authorizedOnly() throws UnauthorizedException {
//    	/*
//    	You can lock down which roles are allowed by checking
//    	if the current user has a role.
//    	In this example, if the user does not have the admin role
//    	we send back an unauthorized error.
//    	*/
//        if(authProvider.userHasRole(new String[] {"admin"})) {
//            throw new UnauthorizedException();
//        }
//        return "Success";
//    }
//	
	
}
