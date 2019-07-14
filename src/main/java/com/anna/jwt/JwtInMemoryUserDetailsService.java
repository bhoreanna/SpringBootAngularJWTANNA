package com.anna.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.anna.boinerface.UserServiceInterface;
import com.anna.component.User;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	
	
	@Autowired
	UserServiceInterface userService;

	static {
		System.out.println("----------Static Block For ---------");
		inMemoryUserList.add(new JwtUserDetails(1L, "annabhore",
				"$2a$10$/EqxW.lSxTQcYo/Jj2WhWOCD6GWgCWCYFCcASSI6kfEcL3Do/077i", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
				"$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));
		
		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
		System.out.println("inMemoryUserList: "+inMemoryUserList);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUserDetails findFirst1 =null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("username name in loadUserByUsername: "+username);
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();
		
		Optional<User> user1 = userService.searchUser(username);
		System.out.println("User From DB: " + user1);
	
		
		if(!user1.isPresent()) {
			System.out.println("!user1.isPresent(: "+(!user1.isPresent()));
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		
		String encodedString = encoder.encode(user1.get().getPassword());
		System.out.println("encodedString: " + encodedString);
		
		 findFirst1 = new JwtUserDetails(1L,user1.get().getUserName(),encodedString,user1.get().getUserRole());
		 System.out.println("Before return  findFirst1: " + findFirst1);
		 return findFirst1;
/*		
		if (!findFirst.isPresent()) {
			System.out.println("!findFirst.isPresent(): "+(!findFirst.isPresent()));
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();*/
	}

}
