package com.anna.component;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUCTORDETIALS") 
public class InstructorDetials implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="YOUTUBECHANNEL")
	private String youtubeChannel;

	@Column(name="HOBBY")
	private String hobby;
	
	public InstructorDetials() {
		
	}

	public InstructorDetials(BigDecimal id, String youtubeChannel, String hobby) {
		super();
		this.id = id;
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	
	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetials [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
	


}
