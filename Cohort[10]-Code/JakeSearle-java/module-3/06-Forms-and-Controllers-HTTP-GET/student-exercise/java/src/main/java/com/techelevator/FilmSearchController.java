package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(path="filmSearchOutput")
    public String searchFilms(HttpServletRequest request) {
    	int minLength = Integer.parseInt(request.getParameter("minLength"));
    	int maxLength = Integer.parseInt(request.getParameter("maxLength"));
		String film = request.getParameter("genre");
		
		List<Film> listOfFilms = new ArrayList<Film>();
		
		listOfFilms = filmDao.getFilmsBetween(film, minLength, maxLength);
		
		request.setAttribute("listOfFilms", listOfFilms);
		
		return "filmSearchOutput";
    }
    
    
}