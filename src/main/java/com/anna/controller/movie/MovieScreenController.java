package com.anna.controller.movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.movie.MovieScreenServiceInterface;
import com.anna.component.categories.Categories;
import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.MovieTheater;
import com.anna.component.products.Products;
import com.anna.exception.ExceptionHandling;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/movieScreen")
public class MovieScreenController {
	
	
	@Autowired 
	MovieScreenServiceInterface movieScreenService;
	public MovieScreenController() {
		System.out.println(" I   In MovieScreenController: ");
	}
	
	
		@RequestMapping(value = "/movieScreenList")
		public List<MovieScreen> movieScreenList() {
			System.out.println(" movieScreenList in main Controllar: ");
			List<MovieScreen> movieScreenList = movieScreenService.getMovieScreenList();
			System.out.println("movieScreenList List Size in Controller: " + movieScreenList.size());
			
			for (MovieScreen movieScreen : movieScreenList) {
				System.out.println("********************* movieScreen List ***************");
				System.out.println("MovieScreen ScreenId: "+movieScreen.getScreenId());
				movieScreen.setTheaterId(movieScreen.getMovieTheater().getTheaterId());
				System.out.println("MovieTheater getTheaterId: "+movieScreen.getMovieTheater().getTheaterId());
				
			}
			
			System.out.println("movieScreenList: " + movieScreenList);
			
			return movieScreenList;
		}
		
	
		//movieScreenListByTheaterId
	
		/*
		@RequestMapping(value = "/movieScreenListByTheaterId/{theaterId}")
		public List<MovieScreen> getMovieScreenListByTheaterId(@PathVariable(name="theaterId")BigDecimal theaterId) {
			System.out.println("I am in ScreenMasterListByModuleUid  Controllar categoryId: " + theaterId);
			List<MovieScreen> movieScreenList = new ArrayList<MovieScreen>();
			 Categories category = new Categories();
			category.setCategoryId(categoryId);
			 System.out.println("getCategoryId: " +category.getCategoryId());
			 productsList = productsService.getProductsListByCategory(category);
			 for (Products products : productsList) {
				 products.setCategoryId(products.getCategory().getCategoryId());
			}
			return movieScreenList;
		}
		
		*/
		
		
		
		@RequestMapping(value = "/movieScreenListByTheaterId", method = RequestMethod.POST)
		public List<MovieScreen>  getMovieScreenListByTheaterId(@RequestBody BigDecimal theaterId) throws ExceptionHandling  {
			
			System.out.println("I am in ScreenMasterListByModuleUid  Controllar categoryId: " + theaterId);
			List<MovieScreen> movieScreenList = new ArrayList<MovieScreen>();
			MovieTheater movieTheater = new MovieTheater();
			movieTheater.setTheaterId(theaterId);
			 movieScreenList	= movieScreenService.getMovieScreenListByMovieTheater(movieTheater);
			 
			 for (MovieScreen movieScreen : movieScreenList) {
					System.out.println("********************* movieScreen List ***************");
					System.out.println("MovieScreen ScreenId: "+movieScreen.getScreenId());
					movieScreen.setTheaterId(movieScreen.getMovieTheater().getTheaterId());
					System.out.println("MovieTheater getTheaterId: "+movieScreen.getMovieTheater().getTheaterId());
					
				}
				
				System.out.println("movieScreenList: " + movieScreenList);
				
				return movieScreenList;
		
		}
}
