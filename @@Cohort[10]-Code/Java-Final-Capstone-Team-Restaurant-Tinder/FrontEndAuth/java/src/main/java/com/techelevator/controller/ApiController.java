package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AuthProvider authProvider;

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String authorizedOnly() throws UnauthorizedException {
        /*
        You can lock down which roles are allowed by checking
        if the current user has a role.
        */
		//System.out.print("\n\n\n\n\nSuccess!  ! ! !! ! !! !\n\n\n\n\n\n");
		/*
        In this example, if the user does not have the admin role
        we send back an unauthorized error.
        */
        if( ! authProvider.userHasRole(new String[] {"admin"})) {
            throw new UnauthorizedException();
        }
        return "Success";
    }
    
//    @RequestMapping(path="/", method=RequestMethod.POST)
//    public String saveRestaurant() throws UnauthorizedException {
//        System.out.print("\n\n\n\n\nSuccess!  ! ! !! ! !! !\n\n\n\n\n\n");
//        return "Success";
//    }
    
}