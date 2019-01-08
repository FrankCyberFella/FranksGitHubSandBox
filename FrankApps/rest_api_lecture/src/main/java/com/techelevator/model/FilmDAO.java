package com.techelevator.model;

import java.util.List;

public interface FilmDAO {
	List<Film> getAllFilms();
	List<Film> searchFilmTitle(String search);
}
