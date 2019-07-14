
package com.anna.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.mockito.internal.util.io.IOUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.UserServiceInterface;
import com.anna.component.User;
import com.anna.exception.ExceptionHandling;
import com.anna.pdf.CreateUserPdf;
import com.anna.service.NotificationService;
import com.google.common.io.ByteStreams;
//import org.apache.log4j.Logger;


@RestController
// @RequestMapping("/AnnaSpringStudent")
public class UserController {

	
	User user;
	@Autowired
	UserServiceInterface userService;
	Logger logger = LogManager.getLogger("annaLogger");

	@Autowired
	NotificationService notificationService;

	List<User> userList = new ArrayList<User>();

	public UserController() {
		System.out.println("UserController Constructor");
		logger.info("UserController Constructor IN Spring Boot Angular JWT");
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/")
	public String userHome() {

		return "Spring Boot And Angular Application Started....!";

	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/userList")
	public List<User> userList() {
		System.out.println("i am in userList in main Controllar");
		List<User> userList = userService.getUserList();
		System.out.println("User List Size in Controller: " + userList.size());
		return userList;
	}

	// deleteUser
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@GetMapping(value = "/deleteUser/{userName}")

	public boolean deleteUser(@PathVariable String userName) {

		System.out.println("<--I am in  Delete USER-->");

		System.out.println("User Name in Delete: " + userName);
		int res = userService.deleteUser(userName);
		System.out.println("res After Delete Operation: " + res);

		return true;
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public User updateUser(@RequestBody User user) {
		System.out.println("<--Updated User Data-->");
		System.out.println("Student Id:" + user.getUserName());

		return userService.updateUser(user);

	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/registorUser", method = RequestMethod.POST)
	public boolean registorUser(@RequestBody User user) {
		System.out.println("<--Registor User -->" + user.getClass().getName());
		System.out.println("UserName: " + user.getUserName());
		System.out.println("Password: " + user.getPassword() != null ? user.getPassword() : "null");
		User uer1 = userService.saveUserList(user);

		return true;
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public Optional<User> loginUser(@RequestBody User user) {
		System.out.println("<--Registor User -->" + user.getClass().getName());
		System.out.println("UserName: " + user.getUserName());
		System.out.println("Password: " + user.getPassword() != null ? user.getPassword() : "null");
		Optional<User> user1 = userService.searchUser(user.getUserName());
		notificationService.sendNotication(user1.get().getEmail());
		return user1;
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public ResponseEntity<User> getUser(@RequestBody String userName) throws ExceptionHandling {
		System.out.println("<-- User Name -->" + userName);

		Optional<User> user1 = userService.searchUser(userName);
		System.out.println("*****************Get User From /getUser*************  " + user1);
		HttpHeaders headers = new HttpHeaders();
		if (!user1.isPresent()) {
			System.out.println("-----------------Throw Exception Return---------------");
			throw new ExceptionHandling("userName-" + userName);
		}

		ResponseEntity<User> resource = new ResponseEntity<User>(HttpStatus.OK);

		System.out.println("-----------------Response Return---------------");

		return resource;

	}

	@GetMapping("/userHeader")
	ResponseEntity<String> customHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Header", "Anna");

		return new ResponseEntity<>("Custom header set", headers, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/dummyList")
	public List<User> dummyList() {
		System.out.println("I am in dummyList in main Controllar");
		List<User> userList = new ArrayList<>();
		// userList.add(new User("anna", "anna123", "anna@gmail.com", "anna", "bhore",
		// "admin"));
		if (userList.size() <= 0) {
			throw new ExceptionHandling("UserList:- " + userList.size());

		}
		System.out.println("User List Size in Controller: " + userList.size());
		return userList;
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

	@GetMapping("/getUserPdf")
	
	public ResponseEntity<byte[]> getPDF() {

		try {
			FileInputStream fileStream;
			HttpHeaders headers = new HttpHeaders();

			fileStream = new FileInputStream(new File("C://Users//annasaheb.bhore//Desktop//MYPDF.pdf"));
			byte[] contenets = ByteStreams.toByteArray(fileStream);
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			String fileName = "MYPDF.pdf";
			headers.setContentDispositionFormData(fileName, fileName);
			ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contenets, headers, HttpStatus.OK);
			System.out.println("contenets size: " + contenets.length);
			System.out.println(".................Return response....................");
			return response;

		} catch (FileNotFoundException fnfexe) {
			System.out.println("FileNotFoundException: " + fnfexe);
		} catch (IOException ioexe) {
			System.out.println("IOException: " + ioexe);

		} catch (Exception e) {
			System.out.println("exception: " + e);

		}
		return null;
	}
	
	
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/getPdfbyList", method = RequestMethod.POST)
	public  ResponseEntity<byte[]> getPdfbyList(@RequestBody List<User> users) throws ExceptionHandling {
		byte[] contenets = null;
		System.out.println("_________________________________");

		System.out.println("users: " + users);
		
		System.out.println("_________________________________");

		try {
			
			CreateUserPdf pdf = new CreateUserPdf();
			contenets = pdf.creatingPDFDocument(users);
			HttpHeaders headers = new HttpHeaders();

			//byte[] contenets = ByteStreams.toByteArray(fileStream);
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			String fileName = "MYPDF.pdf";
			headers.setContentDispositionFormData(fileName, fileName);
			ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contenets, headers, HttpStatus.OK);
			System.out.println("contenets size: " + contenets.length);
			System.out.println(".................Return response....................");
			return response;

		}  catch (Exception e) {
			System.out.println("exception: " + e);

		}

		System.out.println("*********************return null");
		return null;

	}


}