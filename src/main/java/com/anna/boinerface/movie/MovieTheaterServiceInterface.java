package com.anna.boinerface.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.movie.MovieTheater;

public interface MovieTheaterServiceInterface {

	
	public List<MovieTheater> getMovieTheaterList();
	public MovieTheater saveMovieTheater(MovieTheater movieTheater);
	public Optional<MovieTheater> searchMovieTheater(BigDecimal theaterId);
	public int deleteMovieTheater(BigDecimal theaterId);
	public MovieTheater updateMovieTheater(MovieTheater movieTheater);
}
