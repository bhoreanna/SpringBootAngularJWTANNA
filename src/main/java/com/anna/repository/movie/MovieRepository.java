package com.anna.repository.movie;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.movie.Movie;


@Repository
public interface MovieRepository extends CrudRepository<Movie , BigDecimal> {


}
