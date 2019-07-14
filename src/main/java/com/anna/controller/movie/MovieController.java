package com.anna.controller.movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.movie.MovieServiceInterface;
import com.anna.component.movie.Movie;
import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.MovieTheater;
import com.anna.exception.ExceptionHandling;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/movie")
public class MovieController {

	@Autowired
	MovieServiceInterface movieService;
	public MovieController() {
		System.out.println("I am in MovieController Consructor");
	}
	
	@RequestMapping(value = "/movieList")
	public List<Movie> MovieList() {
		System.out.println("i am in MovieList in main Controllar");
		List<Movie> movieList = movieService.getMoviesList();
		System.out.println("User List Size in Controller: " + movieList.size());
		return movieList;
	}
	
	
	
	
	@RequestMapping(value = "/getTheaterListByMovieId", method = RequestMethod.POST)
	public  Optional< Movie>  getMovieScreenListByTheaterId(@RequestBody BigDecimal movieId) throws ExceptionHandling  {
		
		
		 System.out.println("movieId : " + movieId);
		
		 Optional< Movie> 	movie = movieService.searchMovie(movieId);
		 System.out.println("***********************************");
		 System.out.println("returnning Movie Object: " + movie.get().getMovieName());
		 System.out.println("***********************************");

			
			return movie;
	
	
}
}
