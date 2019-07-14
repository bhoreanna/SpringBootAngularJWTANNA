package com.anna.repository.movie;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.MovieTheater;

@Repository
public interface MovieScreenRepository extends CrudRepository<MovieScreen , BigDecimal> {
	
	public List<MovieScreen> findByMovieTheater(MovieTheater movieTheater); 


}
