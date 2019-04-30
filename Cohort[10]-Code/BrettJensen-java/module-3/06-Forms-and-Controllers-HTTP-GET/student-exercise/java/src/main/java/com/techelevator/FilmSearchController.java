package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;
import com.techelevator.validation.model.ActorSearch;
import com.techelevator.validation.model.FilmSearch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping(path="/filmList", method=RequestMethod.GET)
    public String showFilmSearchForm(Model modelHolder) {
    	if( ! modelHolder.containsAttribute("FilmSearch")) {
			modelHolder.addAttribute("FilmSearch", new FilmSearch());
		}

        return "filmList";
    }
    
    @RequestMapping(path="/filmList", method=RequestMethod.POST)
    public String searchFilms(@Valid @ModelAttribute("FilmSearch") FilmSearch film,
			  				  BindingResult result,
			  				  RedirectAttributes flash, HttpServletRequest request) {
    	
    
    	if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "FilmSearch", result);
			flash.addFlashAttribute("FilmSearch", film);
			return "redirect:/filmList";
		}
    	
    	    	
    	List<Film> films = filmDao.getFilmsBetween(film.getGenre(), film.getMinLength(), film.getMaxLength());
    	
    	request.setAttribute("films", films);

        return "filmList";
    }
    
   
    
    
}