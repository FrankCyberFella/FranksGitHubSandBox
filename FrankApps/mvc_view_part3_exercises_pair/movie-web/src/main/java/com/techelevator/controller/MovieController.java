package com.techelevator.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.Movie;
import com.techelevator.model.ShowTime;

@Controller
public class MovieController {

	private static List<Movie> movies = getMovies();

	@RequestMapping({"/", "/movieList"})
	public String displayMovieList(HttpServletRequest request) {
		request.setAttribute("movies", movies);
		return "movieList";
	}

	@RequestMapping("/movieDetail")
	public String displayMovieDetail(HttpServletRequest request) {
		Long id = Long.valueOf(request.getParameter("movieId"));
		request.setAttribute("movie", getMovieById(id));
		return "movieDetail";
	}

	private Movie getMovieById(Long id) {
		Movie result = null;
		for (Movie movie : movies) {
			if (id.equals(movie.getId())) {
				result = movie;
			}
		}
		return result;
	}

	// DONT MODIFY THESE
	private static List<Movie> getMovies() {
		ArrayList<Movie> movies = new ArrayList<>();

		Movie m = new Movie("Interstellar",
				"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
				179, 2014, "Space");
		m.addCastMember("Matthew McConaughey");
		m.addCastMember("Anne Hathaway");
		m.addCastMember("Matt Damon");
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 15, 12, 0, 0), "Regal Cinemas"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 15, 15, 0, 0), "Valley View"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 15, 18, 0, 0), "Strongsville"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 15, 21, 0, 0), "Regal Cinemas"));
		movies.add(m);

		m = new Movie("Batman Begins",
				"After training with his mentor, Batman begins his war on crime to free the crime-ridden Gotham City from corruption that the Scarecrow and the League of Shadows have cast upon it.",
				140, 2005, "Action");
		m.addCastMember("Christian Bale");
		m.addCastMember("Michael Caine");
		m.addCastMember("Ken Watanabe");
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 10, 12, 0, 0), "Regal Cinemas"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 12, 12, 0, 0), "Regal Cinemas"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 13, 12, 0, 0), "Regal Cinemas"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 13, 15, 0, 0), "Regal Cinemas"));
		movies.add(m);

		m = new Movie("Inception",
				"A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.",
				148, 2010, "Action");
		m.addCastMember("Leonardo DiCaprio");
		m.addCastMember("Michael Caine");
		m.addCastMember("Joseph Gordon-Levitt");
		m.addCastMember("Ellen Page");
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 10, 12, 0, 0), "Strongsville"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 12, 12, 0, 0), "Strongsville"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 13, 12, 0, 0), "Strongsville"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 13, 15, 0, 0), "Strongsville"));
		movies.add(m);

		m = new Movie("The Dark Knight",
				"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.",
				152, 2008, "Action");
		m.addCastMember("Christian Bale");
		m.addCastMember("Michael Caine");
		m.addCastMember("Heath Ledger");
		m.addCastMember("Aaron Eckhart");
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 10, 12, 0, 0), "Drive-In"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 10, 15, 0, 0), "Drive-In"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 10, 18, 0, 0), "Drive-In"));
		m.addShowTime(new ShowTime(LocalDateTime.of(2016, 06, 10, 21, 0, 0), "Drive-In"));
		movies.add(m);

		return movies;
	}
}
