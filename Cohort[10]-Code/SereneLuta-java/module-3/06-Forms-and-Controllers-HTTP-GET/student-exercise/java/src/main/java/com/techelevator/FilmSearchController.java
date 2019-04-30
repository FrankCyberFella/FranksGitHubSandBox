package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;

import java.util.List;

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
    
    @RequestMapping(path="filmList", method=RequestMethod.GET)
    public String showFilmSearchForm(ModelMap filmMap) {
    	if(!filmMap.containsAttribute("Film")) {
			filmMap.addAttribute("Film", new Film());
		}
        return "filmList";
    }

    @RequestMapping(path="filmSearchResult", method=RequestMethod.GET)
	public String showFilmSearch() {
		
		return "filmSearchResult";
	}

    
    @RequestMapping(path="filmSearchResult", method=RequestMethod.POST)
    public String submitFilmSearch(@Valid @ModelAttribute("Film") Film searchValues,
    								BindingResult result,
    								RedirectAttributes flash) {
    	if(result.hasErrors()) {
    		flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Film", result);
    		flash.addFlashAttribute("Film", searchValues);
    		return "redirect:/filmList";
    	}
    		List<Film> searchFilm = filmDao.getFilmsBetween(searchValues.getName(),searchValues.getMinLength(), searchValues.getMaxLength());
    		flash.addFlashAttribute("filmKey", searchFilm);
    		return "redirect:/filmSearchResult";
    }
    
//    @RequestMapping("filmSearchResult")
//    public String searchFilms(HttpServletRequest request) {
//    	 String getGenre = request.getParameter("genre");
//    	 int getMinLength = Integer.parseInt(request.getParameter("minLength"));
//    	 int getMaxLength = Integer.parseInt(request.getParameter("maxLength"));
//		 java.util.List<Film> searchMovies = filmDao.getFilmsBetween(getGenre, getMinLength, getMaxLength);
//		 request.setAttribute("filmKey", searchMovies);
//		/* Call the model and pass values to the jsp */
//        return "filmSearchResult";
//    }
    
    
}