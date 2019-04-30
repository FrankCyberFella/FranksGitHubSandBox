	package com.techelevator;

import com.techelevator.dao.FilmDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/filmList")
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping("/filmResult")
    public String searchFilms(HttpServletRequest request) {
    	
    	int minLength = Integer.parseInt(request.getParameter("minLength"));
    	int maxLength = Integer.parseInt(request.getParameter("maxLength"));
    	String genre = request.getParameter("genre");
    	
    	request.setAttribute("films", filmDao.getFilmsBetween(genre, minLength, maxLength));
        return "filmResult";
    }
    

}