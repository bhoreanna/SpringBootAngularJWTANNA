package com.anna.component.course;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.anna.component.Instructor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Course") 
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COURSEID")
	private BigDecimal courseId ;
	
	@Column(name="COURSENAME")
	private String courseName  ;
	
	@Column(name="DURATION")
	private int duration ;
	
	@Column(name="TYPE")
	private String type ;
	
	
	@JsonBackReference
	 @ManyToOne
	@JoinColumn(name="INSTID")
    
	private Instructor instructor; 
	
	public Course() {
	}

	public Course(BigDecimal courseId, String courseName, int duration, String type, Instructor instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.type = type;
		this.instructor = instructor;
	}

	public BigDecimal getCourseId() {
		return courseId;
	}

	public void setCourseId(BigDecimal courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", type="
				+ type + ", instructor=" + instructor + "]";
	}

	
	
	
	
}
