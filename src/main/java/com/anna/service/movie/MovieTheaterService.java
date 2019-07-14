package com.anna.service.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.movie.MovieTheaterServiceInterface;
import com.anna.component.movie.MovieTheater;
import com.anna.repository.movie.MovieTheaterRepository;

@Service

public class MovieTheaterService implements MovieTheaterServiceInterface {

	@Autowired
	MovieTheaterRepository repository;
	public MovieTheaterService() {
		
	}
	@Override
	public List<MovieTheater> getMovieTheaterList() {
		return (List<MovieTheater>) repository.findAll();
	}

	@Override
	public MovieTheater saveMovieTheater(MovieTheater movieTheater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieTheater> searchMovieTheater(BigDecimal theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMovieTheater(BigDecimal theaterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MovieTheater updateMovieTheater(MovieTheater movieTheater) {
		// TODO Auto-generated method stub
		return null;
	}

}
