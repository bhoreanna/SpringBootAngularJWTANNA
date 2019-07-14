package com.anna.repository.movie;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.movie.MovieTheater;
@Repository
public interface MovieTheaterRepository  extends CrudRepository<MovieTheater , BigDecimal> {

}
