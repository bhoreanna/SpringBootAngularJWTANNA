package com.anna.boinerface.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.Sheat;

public interface SheatServiceInterface {

	public List< Sheat> getSheatList();
	public  Sheat saveMovieSheat( Sheat  sheat);
	public Optional< Sheat> searchSheat(BigDecimal sheatId);
	public int deleteSheat(BigDecimal sheatId);
	public  Sheat updateSheat( Sheat  Sheat);
	public  boolean updateSheatList( List<Sheat>  Sheats);
	public List< Sheat> getSheatListByMovieScreen(MovieScreen MovieScreen);
}
