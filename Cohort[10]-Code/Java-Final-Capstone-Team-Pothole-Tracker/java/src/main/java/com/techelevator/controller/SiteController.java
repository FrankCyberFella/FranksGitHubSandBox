package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.PotholeDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SiteController
 */
@Controller
public class SiteController {
    @Autowired
    private AuthProvider auth;
    @Autowired
    private PotholeDao potholeDao;
    
    @RequestMapping(path="/private", method=RequestMethod.GET)
    public String privatePage() throws UnauthorizedException {
        if(auth.userHasRole(new String[]{"admin", "user"})) {
            return "private";
        } else {
            throw new UnauthorizedException();
        }
    }

    @RequestMapping(path="/map", method=RequestMethod.GET)
    public String mapPage(ModelMap potholeMap, HttpServletRequest request) throws UnauthorizedException {
    	request.setAttribute("aPothole", potholeDao.getAllPotholes());
        return "map";
    }
}