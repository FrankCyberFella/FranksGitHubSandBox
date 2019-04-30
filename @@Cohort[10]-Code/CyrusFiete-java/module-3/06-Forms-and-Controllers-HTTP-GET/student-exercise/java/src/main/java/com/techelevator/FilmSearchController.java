package com.techelevator;

import com.techelevator.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/filmSearch")
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping(path="/filmList", method=RequestMethod.GET)
    public String searchFilms(@RequestParam String genre, int minLength, int maxLength, ModelMap modelHolder) {
        modelHolder.put("films", filmDao.getFilmsBetween(genre, minLength, maxLength));
        return "filmList";
    }
    
    
}