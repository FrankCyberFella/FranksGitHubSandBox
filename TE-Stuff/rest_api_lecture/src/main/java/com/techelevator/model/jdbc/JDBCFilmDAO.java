package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Film;
import com.techelevator.model.FilmDAO;

@Component
public class JDBCFilmDAO implements FilmDAO {
	
	private static final String SQL_GET_ALL_FILMS = "SELECT * FROM film";
	private static final String SQL_SEARCH_FILMS = "SELECT * FROM film WHERE title LIKE ?";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCFilmDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Film> getAllFilms() {
		SqlRowSet results = jdbcTemplate.queryForRowSet(SQL_GET_ALL_FILMS);
		return mapResultsToFilms(results);
	}

	@Override
	public List<Film> searchFilmTitle(String search) {
		SqlRowSet results = jdbcTemplate.queryForRowSet(SQL_SEARCH_FILMS, "%"+search.toUpperCase()+"%");
		return mapResultsToFilms(results);
	}
	
	private List<Film> mapResultsToFilms(SqlRowSet results) {
		List<Film> films = new ArrayList<Film>();
		
		while(results.next()) {
			films.add(mapRowToFilm(results));
		}
		
		return films;
	}
	
	private Film mapRowToFilm(SqlRowSet row) {
		Film film = new Film();
		
		film.setId(row.getLong("film_id"));
		film.setTitle(row.getString("title"));
		film.setRating(row.getString("rating"));
		film.setDescription(row.getString("description"));
		film.setReleaseYear(row.getInt("release_year"));
		film.setRunTime(row.getInt("length"));
		
		return film;
	}
}
