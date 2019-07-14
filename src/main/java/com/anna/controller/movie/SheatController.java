package com.anna.controller.movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.movie.SheatServiceInterface;
import com.anna.component.movie.MovieScreen;
import com.anna.component.movie.Sheat;
import com.anna.exception.ExceptionHandling;
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/sheat")
public class SheatController {
	
	@Autowired
	SheatServiceInterface sheatService;
		public SheatController(){
			System.out.println(" I   In SheatController: ");

		}
	
	@RequestMapping(value = "/sheatList")
	public List<Sheat> sheatList() {
		System.out.println(" sheatList in main Controllar: ");
		List<Sheat> sheatList = sheatService.getSheatList();
		System.out.println("sheatList List Size in Controller: " + sheatList.size());
		
		for (Sheat sheat : sheatList) {
			System.out.println("********************* Sheat List ***************");
			System.out.println("sheat screenId: "+sheat.getSheatId());
			sheat.setScreenId(sheat.getMovieScreen().getScreenId());
			System.out.println("MovieShreen getScreenId: "+sheat.getMovieScreen().getScreenId());
			
		}
		
		System.out.println("sheatList: " + sheatList);
		
		return sheatList;
	}
	
	
	
	
	@RequestMapping(value = "/sheatListByScreenId", method = RequestMethod.POST)
	public List<Sheat>  getsheatListByScreenId(@RequestBody BigDecimal screenId) throws ExceptionHandling  {
		
		System.out.println("*********************getsheatListByScreenId START**************************");
		System.out.println("I am in ScreenMasterListByModuleUid  Controllar screenId: " + screenId);
		List<Sheat> sheatList = new ArrayList<>();
		MovieScreen movieScreen = new MovieScreen();
		movieScreen.setScreenId(screenId);
		
		sheatList	= sheatService.getSheatListByMovieScreen(movieScreen);
		 
		for (Sheat sheat : sheatList) {
			System.out.println("********************* Sheat List ***************");
			System.out.println("sheat screenId: "+sheat.getSheatId());
			sheat.setScreenId(sheat.getMovieScreen().getScreenId());
			System.out.println("MovieShreen getScreenId: "+sheat.getMovieScreen().getScreenId());
			
			if(sheat.getIsbookedDB()==1) {
				sheat.setBookedStatus(true);
			}
			else
			{
				sheat.setBookedStatus(false);

			}
			
			if(sheat.getStatus().equalsIgnoreCase("active")) {
				sheat.setSheatBookedStatus(true);
			}else
			{
				sheat.setSheatBookedStatus(false);

			}
			
		}
			
		System.out.println("-----------------Before returnning------------------------");
			System.out.println("sheatList: " + sheatList);
			System.out.println("*********************getsheatListByScreenId END**************************");

			return sheatList;
	
	}
	
	
	
	@RequestMapping(value = "/bookSheats", method = RequestMethod.POST)
	public boolean  bookSheats(@RequestBody List<Sheat> bookSheats) throws ExceptionHandling  {
		
		System.out.println("bookSheats: " + bookSheats);
		
		for (Sheat sheat : bookSheats) {
			System.out.println("Sheat Id: " + sheat.getSheatId());
			System.out.println("Sheat Name: " + sheat.getSheatName());
			System.out.println("Screen Id: " + sheat.getScreenId());
			
			sheat.setStatus("inActive");
			MovieScreen movieScreen = new MovieScreen();
			
			movieScreen.setScreenId(sheat.getScreenId());
			sheat.setMovieScreen(movieScreen);
		}
		System.out.println("**********************************************************************");
		
		System.out.println("Before Saving Book List");
		System.out.println("bookSheats List: "  + bookSheats);
		return sheatService.updateSheatList(bookSheats);
	}
	
	
	

}
