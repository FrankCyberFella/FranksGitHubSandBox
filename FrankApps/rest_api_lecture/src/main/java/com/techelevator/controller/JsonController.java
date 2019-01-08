package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Film;
import com.techelevator.model.FilmDAO;

@RestController
@RequestMapping("/api")
public class JsonController {
	@Autowired
	private FilmDAO filmDao;
	
	@RequestMapping(path="/films", method=RequestMethod.GET)
	public List<Film> searchFilms(HttpServletRequest request, @RequestParam String search) {
		return filmDao.searchFilmTitle(search);
	}
}
