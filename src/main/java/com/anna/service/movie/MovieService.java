package com.anna.service.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.movie.MovieServiceInterface;
import com.anna.component.movie.Movie;
import com.anna.repository.movie.MovieRepository;

@Service
public class MovieService  implements MovieServiceInterface{

	@Autowired 
	MovieRepository repository;
	
	@Override
	public List<Movie> getMoviesList() {
		return (List<Movie>) repository.findAll();
	}

	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> searchMovie(BigDecimal movieId) {
		// TODO Auto-generated method stub
		return repository.findById(movieId);
	}

	@Override
	public int deleteMovie(BigDecimal movieId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

}
