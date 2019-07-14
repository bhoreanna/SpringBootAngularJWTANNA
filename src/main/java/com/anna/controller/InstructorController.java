package com.anna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.InstructorServiceInterface;
import com.anna.component.Instructor;
import com.anna.component.InstructorDetials;
import com.anna.component.course.Course;

@RestController
public class InstructorController {

	Instructor instructor;
	@Autowired
	InstructorServiceInterface instructorService;

	public InstructorController() {
		System.out.println("I am in InstructorController");

	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/instructorList")
	public List<Instructor> instructorList() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		System.out.println("i am in Instructor in main Controllar");
		List<Instructor> instructorList = instructorService.getInstructorList();
		System.out.println("InstructorList List Size: " + instructorList.size());

		/*
		for (Instructor instructor : instructorList) {
			System.out.println(" Instructor NAme: " + instructor.getFirstName());

			System.out.println("*********************Instructor Detial Object  Start************************");
			InstructorDetials instructorDetials = instructor.getInstructorDetials();
			System.out.println("instructorDetials Hobby Name:  " + instructorDetials.getHobby());

			System.out.println("*********************Instructor Detial Object  END************************");

			System.out.println("********************  Course Object Start  ******************************");

			if (instructor.getCourseList().size() > 0 && instructor.getCourseList() != null) {
				System.out.println("instructor Course List: " + instructor.getCourseList());
				List<Course> courseList =  instructor.getCourseList();
				System.out.println("courseList Size : " + courseList.size());

				for (Course course : courseList) {
					System.out.println("course: " + course.getCourseName());
				}

				System.out.println("********************  Course Object Start  ******************************");
			}

		}*/

		return instructorList;
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/saveInstructor")
	public String saveInstructor() {

		InstructorDetials instructorDetials = new InstructorDetials();
		instructorDetials.setHobby("suhash");
		instructorDetials.setYoutubeChannel("suhash@youtube.com");
		Instructor instructor = new Instructor();
		instructor.setFirstName("suhash");
		instructor.setLastName("Bhore");
		instructor.setEmail("suhash@gmail.com");

		instructor.setInstructorDetials(instructorDetials);
		System.out.println("Instructor Object: " + instructor);
		instructor = instructorService.saveInstructor(instructor);
		System.out.println("After Saving instructor: " + instructor);
		return "instructor Save SucessFully....!" + instructor;

	}

}
