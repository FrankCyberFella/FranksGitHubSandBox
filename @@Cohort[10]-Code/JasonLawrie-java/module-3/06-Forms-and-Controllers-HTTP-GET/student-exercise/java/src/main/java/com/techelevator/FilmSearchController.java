package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.FilmSearch;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value="/filmList", method=RequestMethod.GET)
    public String showFilmSearchForm(ModelMap map) {
    	if(map.containsAttribute("FilmSearch")) {
			map.addAttribute("FilmSearch", map.get("FilmSearch"));
		}else {
			map.put("FilmSearch", new FilmSearch());
		}
        return "filmList";
    }

    @RequestMapping(value="/filmList", method=RequestMethod.POST)
    public String searchFilms(@Valid @ModelAttribute("FilmSearch") FilmSearch filmSearch,
    							BindingResult result,
    							RedirectAttributes flash) {
    	if(result.hasErrors()) {										//if there were any validation errors do this stuff
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "FilmSearch", result);
			flash.addFlashAttribute("FilmSearch", filmSearch);
			return "redirect:/filmList";
		} 
        flash.addFlashAttribute("films", filmDao.getFilmsBetween(filmSearch.getGenre(), filmSearch.getMinLength(), filmSearch.getMaxLength()));
    	return "redirect:/filmList";
    }
    
    
}