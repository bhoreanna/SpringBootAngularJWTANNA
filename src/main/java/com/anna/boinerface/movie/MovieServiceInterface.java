package com.anna.boinerface.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.movie.Movie;

public interface MovieServiceInterface {

	
	public List< Movie> getMoviesList();
	public  Movie saveMovie( Movie  movie);
	public Optional< Movie> searchMovie(BigDecimal movieId);
	public int deleteMovie(BigDecimal movieId);
	public  Movie updateMovie( Movie  movie);
}
