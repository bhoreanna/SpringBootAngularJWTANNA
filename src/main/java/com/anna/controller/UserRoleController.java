package com.anna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.UserRoleInterface;
import com.anna.component.UserRole;


@RestController
public class UserRoleController {
	
	UserRole useRole;
	@Autowired
	UserRoleInterface userRoleService;
	
	public UserRoleController(){
		System.out.println("I am in UserRoleController ");
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/userRoleList")
	public List<UserRole> userList() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		System.out.println("i am in userList in main Controllar");
		List<UserRole> userRoleList = userRoleService.getUserRoleList();
		System.out.println("User List Size in Controller: " + userRoleList.size());
		return userRoleList;
	}

}
