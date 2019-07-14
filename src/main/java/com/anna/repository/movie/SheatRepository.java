package com.anna.repository.movie;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.Sheat;
@Repository

public interface SheatRepository  extends CrudRepository<Sheat , BigDecimal>{
	public List<Sheat> findByMovieScreen(MovieScreen movieScreen); 

}
