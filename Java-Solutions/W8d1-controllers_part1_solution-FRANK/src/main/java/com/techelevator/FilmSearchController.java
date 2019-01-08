package com.techelevator;

import com.techelevator.dao.FilmDao;
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
    private FilmDao filmDao;

    @RequestMapping(path="/filmList")
    public String showFilmSearchForm() {
    	
        return "filmList";
    }
    
    @RequestMapping(path="/filmListResults", method=RequestMethod.GET)
    public String searchFilms(@RequestParam(defaultValue="0") int minLength, @RequestParam(defaultValue="999") int maxLength, @RequestParam String genre, ModelMap modelHolder) {
        modelHolder.put("films", filmDao.getFilmsBetween(genre, minLength, maxLength));
		
		return "filmList";
    }
}