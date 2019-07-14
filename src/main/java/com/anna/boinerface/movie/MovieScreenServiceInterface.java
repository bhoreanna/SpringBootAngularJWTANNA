package com.anna.boinerface.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.MovieTheater;

public interface MovieScreenServiceInterface {
	

	public List< MovieScreen> getMovieScreenList();
	public  MovieScreen saveMovieScreen( MovieScreen  movieScreen);
	public Optional< MovieScreen> searchMovieScreen(BigDecimal screenId);
	public int deleteMovieScreen(BigDecimal screenId);
	public  MovieScreen updateMovieScreen( MovieScreen  movieScreen);
	public List< MovieScreen> getMovieScreenListByMovieTheater(MovieTheater movieTheater);

}
