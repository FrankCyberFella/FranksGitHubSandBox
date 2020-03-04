package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Film;
import com.techelevator.model.FilmDAO;

@Controller
public class WebController {
	@Autowired
	private FilmDAO filmDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
	
	@RequestMapping(path="/films", method=RequestMethod.GET)
	public String searchFilms(HttpServletRequest request, @RequestParam String search) {
		List<Film> films = filmDao.searchFilmTitle(search);
		request.setAttribute("films", films);
		return "filmList";
	}
}
