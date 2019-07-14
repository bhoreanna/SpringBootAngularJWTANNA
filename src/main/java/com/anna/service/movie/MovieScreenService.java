package com.anna.service.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.movie.MovieScreenServiceInterface;
import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.MovieTheater;
import com.anna.repository.movie.MovieScreenRepository;

@Service

public class MovieScreenService implements MovieScreenServiceInterface {
	
	@Autowired
	MovieScreenRepository repository ;
	public MovieScreenService() {
		
	}

	@Override
	public List<MovieScreen> getMovieScreenList() {
		return (List<MovieScreen>) repository.findAll();
	}

	@Override
	public MovieScreen saveMovieScreen(MovieScreen movieScreen) {
		return null;
	}

	@Override
	public Optional<MovieScreen> searchMovieScreen(BigDecimal screenId) {
		return null;
	}

	@Override
	public int deleteMovieScreen(BigDecimal screenId) {
		return 0;
	}

	@Override
	public MovieScreen updateMovieScreen(MovieScreen movieScreen) {
		return null;
	}

	@Override
	public List<MovieScreen> getMovieScreenListByMovieTheater(MovieTheater movieTheater) {
		return repository.findByMovieTheater(movieTheater);
	}

}
