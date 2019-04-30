package com.techelevator;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Film;
import com.techelevator.dao.model.FilmSearch;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;
    
    
    
   @RequestMapping(path="/filmList", method=RequestMethod.GET)
   public String showFilmList(Model modelHolder) {
	   
	   if(! modelHolder.containsAttribute("FilmSearch")) {
		   modelHolder.addAttribute("FilmSearch", new FilmSearch());
	   }
	   
       return "filmList";
    }

    @RequestMapping(path="/filmList", method=RequestMethod.POST)	    
    public String searchFilms(@Valid @ModelAttribute("FilmSearch") FilmSearch films,
    						   RedirectAttributes flash, BindingResult result) {
    		
    	
    	
    		if(result.hasErrors()) {
    			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "FilmSearch", result);
    			flash.addFlashAttribute("FilmSearch", films);
    			return "redirect:/filmList";
    		}
    		
    		
    		List<Film> matchingFilms = filmDao.getFilmsBetween(films.getGenre(), films.getMinLength(), films.getMaxLength());
    		
    		flash.addFlashAttribute("films", matchingFilms);
    		
    		return "redirect:/filmList";
    	
    }
    
    @RequestMapping(path="/filmSearch", method=RequestMethod.GET)
    public String showFilmSearchForm(Model modelHolder) {
 	   
 	
 		   modelHolder.addAttribute("FilmSearch", new FilmSearch());
 	   
 	   
        return "filmList";
     }
    
    
}