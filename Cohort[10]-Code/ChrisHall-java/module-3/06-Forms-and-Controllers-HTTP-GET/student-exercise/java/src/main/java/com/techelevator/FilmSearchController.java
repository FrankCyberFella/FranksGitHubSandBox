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

	int minLength;
	int maxLength;
	String genre;

	@RequestMapping(value = "filmSearch")
	public String showFilmSearchForm(HttpServletRequest request) {

		return "filmList";
	}

	@RequestMapping(value = "filmList")
	public String searchFilms(HttpServletRequest request) {
//
//		minLength = Integer.parseInt(request.getParameter("minLength"));
//		maxLength = Integer.parseInt(request.getParameter("maxLength"));
		String genre = request.getParameter("genreChoice");

		if (request.getParameter("minLength") == null || (request.getParameter("maxLength") == null)){
			List<Film> matchingFilms = filmDao.getAllFilms(genre);
			request.setAttribute("films", matchingFilms);
			
		} else {
			
			minLength = Integer.parseInt(request.getParameter("minLength"));
			maxLength = Integer.parseInt(request.getParameter("maxLength"));
			List<Film> matchingFilms = filmDao.getFilmsBetween(genre, minLength, maxLength);
			request.setAttribute("films", matchingFilms);

		}
		return "filmList";
	}
}
