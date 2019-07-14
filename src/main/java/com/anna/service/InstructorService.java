package com.anna.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.InstructorServiceInterface;
import com.anna.component.Instructor;
import com.anna.component.User;
import com.anna.repository.InstructorRepository;

@Service
public class InstructorService implements InstructorServiceInterface{

	@Autowired
	InstructorRepository instructorRepository; 
	
	@Override
	public List<Instructor> getInstructorList() {
		System.out.println("I am in getInstructorList ");	
		return (List<Instructor>) instructorRepository.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorRepository.save(instructor);
	}

	@Override
	public Optional<Instructor> searchInstructor(BigDecimal instId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteInstructor(BigDecimal instId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User updateUser(Instructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

}
