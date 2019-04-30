package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;

import java.util.List;

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
    @RequestMapping(path="/filmList", method=RequestMethod.GET)
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping(path="/filmList", method=RequestMethod.POST)
	public String postfilmList(@RequestParam String minLength, @RequestParam String maxLength, @RequestParam String genre, ModelMap modelHandler) {
    	int minLengthInt = Integer.parseInt(minLength);
    	int maxLengthInt = Integer.parseInt(maxLength);
		List<Film> matchingFilms = filmDao.getFilmsBetween(genre, minLengthInt, maxLengthInt);
		modelHandler.put("films", matchingFilms);
		
		
		
		return "filmList";
    }
    
    
}