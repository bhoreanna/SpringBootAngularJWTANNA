package com.anna.component.movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "MOVIETHEATER")
public class MovieTheater {

	@Id
	@Column(name = "THEATERID")
	private BigDecimal theaterId;

	@Column(name = "THEATERNAME")
	private String theaterName;

	@Column(name = "THEATERCITY")
	private String theaterCity;

	@Column(name = "THEATERTYPE")
	private String theaterType;

	@JsonManagedReference
	@OneToMany(mappedBy = "movieTheater", cascade = CascadeType.ALL)
	private List<MovieScreen> movieScreenList;
	
	 @ManyToMany(mappedBy = "movieTheaters")
	    private List<Movie> movies = new ArrayList<>();

	public MovieTheater() {

	}

	public MovieTheater(BigDecimal theaterId, String theaterName, String theaterCity, String theaterType,
			List<MovieScreen> movieScreenList) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.theaterType = theaterType;
		this.movieScreenList = movieScreenList;
	}

	public BigDecimal getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(BigDecimal theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public String getTheaterType() {
		return theaterType;
	}

	public void setTheaterType(String theaterType) {
		this.theaterType = theaterType;
	}

	public List<MovieScreen> getMovieScreenList() {
		return movieScreenList;
	}

	public void setMovieScreenList(List<MovieScreen> movieScreenList) {
		this.movieScreenList = movieScreenList;
	}

	@Override
	public String toString() {
		return "MovieTheater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", theaterType=" + theaterType + "]";
	}

}
