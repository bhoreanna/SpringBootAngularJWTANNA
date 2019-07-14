package com.anna.component.movie;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SHEAT")
public class Sheat {
	
	
	@Id
	@Column(name = "SHEATID")
	private BigDecimal sheatId ;

	@Column(name = "SHEATNAME")
	private String sheatName ;

	@Column(name = "SHEATTYPE")
	private String sheatType ;

	@Column(name = "SHEATPRICE")
	private double sheatPrice ;
	
	@Column(name = "STATUS")
	private String status ;
	
	@Transient
	private BigDecimal screenId ;
	
	@Column(name = "ISBOOKED")
	private int isbookedDB; 
	
	@Transient
	private boolean sheatBookedStatus ;
	
	@Transient
	private boolean bookedStatus;
	

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCREENID")
	private MovieScreen movieScreen;
	
	public Sheat() {
		
	}

	public Sheat(BigDecimal sheatId, String sheatName, String sheatType, double sheatPrice, String status,
			MovieScreen movieScreen) {
		super();
		this.sheatId = sheatId;
		this.sheatName = sheatName;
		this.sheatType = sheatType;
		this.sheatPrice = sheatPrice;
		this.status = status;
		this.movieScreen = movieScreen;
	}

	
	
	public BigDecimal getSheatId() {
		return sheatId;
	}

	public void setSheatId(BigDecimal sheatId) {
		this.sheatId = sheatId;
	}

	public String getSheatName() {
		return sheatName;
	}

	public void setSheatName(String sheatName) {
		this.sheatName = sheatName;
	}

	public String getSheatType() {
		return sheatType;
	}

	public void setSheatType(String sheatType) {
		this.sheatType = sheatType;
	}

	public double getSheatPrice() {
		return sheatPrice;
	}

	public void setSheatPrice(double sheatPrice) {
		this.sheatPrice = sheatPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getScreenId() {
		return screenId;
	}

	public void setScreenId(BigDecimal screenId) {
		this.screenId = screenId;
	}

	public MovieScreen getMovieScreen() {
		return movieScreen;
	}

	public void setMovieScreen(MovieScreen movieScreen) {
		this.movieScreen = movieScreen;
	}
	
	

	

	

	

	

	public boolean isSheatBookedStatus() {
		return sheatBookedStatus;
	}

	public void setSheatBookedStatus(boolean sheatBookedStatus) {
		this.sheatBookedStatus = sheatBookedStatus;
	}

	public boolean isBookedStatus() {
		return bookedStatus;
	}

	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}

	public int getIsbookedDB() {
		return isbookedDB;
	}

	public void setIsbookedDB(int isbookedDB) {
		this.isbookedDB = isbookedDB;
	}

	@Override
	public String toString() {
		return "Sheat [sheatId=" + sheatId + ", sheatName=" + sheatName + ", sheatType=" + sheatType + ", sheatPrice="
				+ sheatPrice + ", status=" + status + ", movieScreen=" + movieScreen + "]";
	}
	
	
	


}
