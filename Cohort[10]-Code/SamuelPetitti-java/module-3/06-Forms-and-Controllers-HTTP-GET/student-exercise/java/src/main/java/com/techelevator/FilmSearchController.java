package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;

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
        public String showFilmListForm() {
        	return "filmList";
        }
    
    @RequestMapping("/filmSearch")
    public String searchFilms(HttpServletRequest request) {
       int minLength = Integer.parseInt(request.getParameter("minLength"));
       int maxLength = Integer.parseInt(request.getParameter("maxLength"));
       String genre = request.getParameter("genre");
       List<Film> films = filmDao.getFilmsBetween(genre, minLength, maxLength);
       request.setAttribute("films", films);
       return "filmList";
    }
    
}


///* What request mapping do we want here */
//@RequestMapping({"/", "/actorList"})
//public String showSearchActorForm() {
//	return "actorList";
//}
//
///* What about here? */
//@RequestMapping("/searchActors")
//public String showSearchActorResult(HttpServletRequest request) {
//	/* Call the model and pass values to the jsp */
//	String actor = request.getParameter("actor");
//	List <Actor> actors = actorDao.getMatchingActors(actor);
//	request.setAttribute("actors", actors);
//	return "actorList";
//}