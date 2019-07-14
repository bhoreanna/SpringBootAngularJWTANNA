package com.anna.controller.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.movie.MovieTheaterServiceInterface;
import com.anna.component.movie.MovieTheater;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/movieTheater")
public class MovieTheaterController {

	@Autowired
	MovieTheaterServiceInterface movieTheaterService;
	public MovieTheaterController() {
		System.out.println(" I   In MovieTheaterController: ");

	}
	
	
	
	@RequestMapping(value = "/movieTheaterList")
	public List<MovieTheater> MovieTheaterList() {
		System.out.println("i am in MovieTheaterList in main Controllar");
		List<MovieTheater> movieTheaterList = movieTheaterService.getMovieTheaterList();
		System.out.println("User List Size in Controller: " + movieTheaterList.size());
		return movieTheaterList;
	}
}
