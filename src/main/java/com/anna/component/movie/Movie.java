package com.anna.component.movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "MOVIE")
public class Movie {

	
	@Id
	@Column(name = "MOVIEID")
	private BigDecimal movieId;

	@Column(name = "MOVIENAME")
	private String movieName;

	

	@Column(name = "MOVIETYPE")
	private String movieType;
	

	
	
	
	  @ManyToMany(cascade = {
		        CascadeType.PERSIST,
		        CascadeType.MERGE
		    })
		    @JoinTable(name = "MOVIE_MOVIETHEATER",joinColumns = @JoinColumn(name = "movie_Id"),
		        inverseJoinColumns = @JoinColumn(name = "theater_Id")
		    )
		    private List<MovieTheater> movieTheaters = new ArrayList<>();
	
	public Movie() {
		
	}

	public BigDecimal getMovieId() {
		return movieId;
	}

	public void setMovieId(BigDecimal movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	

	public List<MovieTheater> getMovieTheaters() {
		return movieTheaters;
	}

	public void setMovieTheaters(List<MovieTheater> movieTheaters) {
		this.movieTheaters = movieTheaters;
	}

	@Override
	public int hashCode() {
		
		
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		
		if (movieTheaters == null) {
			if (other.movieTheaters != null)
				return false;
		} else if (!movieTheaters.equals(other.movieTheaters))
			return false;
		if (movieType == null) {
			if (other.movieType != null)
				return false;
		} else if (!movieType.equals(other.movieType))
			return false;
		return true;
	}
	
	
	
}
