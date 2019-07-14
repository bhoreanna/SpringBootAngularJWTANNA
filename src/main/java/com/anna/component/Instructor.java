package com.anna.component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.anna.component.course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="INSTRUCTOR") 
public class Instructor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INSTID")
	private BigDecimal instId;
	
	@Column(name="FIRSTNAME")
	private String firstName;

	@Column(name="LASTNAME")
	private String lastName;
	

	@Column(name="EMAIL")
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name="INSTIDDETAILS")
	private InstructorDetials instructorDetials;
	
	
	@JsonManagedReference
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	 private List<Course> courseList;
	        
	  
	
	
	public Instructor() {
		
	}




	public Instructor(BigDecimal instId, String firstName, String lastName, String email,
			InstructorDetials instructorDetials, List<Course> courseList) {
		super();
		this.instId = instId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetials = instructorDetials;
		this.courseList = courseList;
	}




	public BigDecimal getInstId() {
		return instId;
	}




	public void setInstId(BigDecimal instId) {
		this.instId = instId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public InstructorDetials getInstructorDetials() {
		return instructorDetials;
	}




	public void setInstructorDetials(InstructorDetials instructorDetials) {
		this.instructorDetials = instructorDetials;
	}




	public List<Course> getCourseList() {
		return courseList;
	}




	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "Instructor [instId=" + instId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", instructorDetials=" + instructorDetials + ", courseList=" + courseList + "]";
	}

	
	
	
	

}
