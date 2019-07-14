package com.anna.service.movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.movie.SheatServiceInterface;
import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.Sheat;
import com.anna.repository.movie.SheatRepository;

@Service

public class SheatService implements SheatServiceInterface {

	@Autowired
	SheatRepository repository; 
	
	public SheatService() {
			
		}

	@Override
	public List<Sheat> getSheatList() {
		// TODO Auto-generated method stub
		return (List<Sheat>) repository.findAll();
	}

	@Override
	public Sheat saveMovieSheat(Sheat sheat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Sheat> searchSheat(BigDecimal sheatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSheat(BigDecimal sheatId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sheat updateSheat(Sheat Sheat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sheat> getSheatListByMovieScreen(MovieScreen movieScreen) {
		// TODO Auto-generated method stub
		return repository.findByMovieScreen(movieScreen);
	}

	@Override
	public boolean updateSheatList(List<Sheat> Sheats) {
		// TODO Auto-generated method stub
		repository.saveAll(Sheats);
		return true;
	}
}
