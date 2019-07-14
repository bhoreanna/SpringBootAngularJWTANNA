package com.anna.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anna.component.Instructor;


public interface InstructorRepository extends JpaRepository<Instructor , BigDecimal>{

}
