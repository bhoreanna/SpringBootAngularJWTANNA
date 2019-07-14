package com.anna.boinerface;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.Instructor;
import com.anna.component.User;

public interface InstructorServiceInterface {

	
	public List<Instructor> getInstructorList();
	public Instructor saveInstructor(Instructor instructor);
	public Optional<Instructor> searchInstructor(BigDecimal instId);
	public int deleteInstructor(BigDecimal instId);
	public User updateUser(Instructor instructor);
}
