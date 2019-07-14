package com.anna.component.movie;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "MOVIESCREEN")
public class MovieScreen {

	@Id
	@Column(name = "SCREENID")
	private BigDecimal screenId;

	@Column(name = "SCREENNAME")
	private String screenName;

	@Column(name = "SCREENTYPE")
	private String screenType;

	@Column(name = "SHEATCOUNT")
	private int sheatCount;

	@Transient
	private BigDecimal theaterId;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEATERID", 
			foreignKey = @ForeignKey(name = "FK_THEATER_ID"))
	private MovieTheater movieTheater;
	
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "movieScreen", cascade = CascadeType.ALL)
	private List<Sheat> sheatList;

	public MovieScreen() {

	}

	public MovieScreen(BigDecimal screenId, String screenName, String screenType, int sheatCount, BigDecimal theaterId,
			MovieTheater movieTheater) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.screenType = screenType;
		this.sheatCount = sheatCount;
		this.theaterId = theaterId;
		this.movieTheater = movieTheater;
	}

	public BigDecimal getScreenId() {
		return screenId;
	}

	public void setScreenId(BigDecimal screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public int getSheatCount() {
		return sheatCount;
	}

	public void setSheatCount(int sheatCount) {
		this.sheatCount = sheatCount;
	}

	public BigDecimal getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(BigDecimal theaterId) {
		this.theaterId = theaterId;
	}

	public MovieTheater getMovieTheater() {
		return movieTheater;
	}

	public void setMovieTheater(MovieTheater movieTheater) {
		this.movieTheater = movieTheater;
	}
	
	

	public List<Sheat> getSheatList() {
		return sheatList;
	}

	public void setSheatList(List<Sheat> sheatList) {
		this.sheatList = sheatList;
	}

	@Override
	public String toString() {
		return "MovieScreen [screenId=" + screenId + ", screenName=" + screenName + ", screenType=" + screenType
				+ ", sheatCount=" + sheatCount + ", movieTheater=" + movieTheater + "]";
	}

}
