package com.anna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.UserServiceInterface;
import com.anna.component.User;
import com.anna.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> getUserList() {
		return (List<User>)repository.findAll() ;
	}

	@Override
	public User saveUserList(User user) {
		repository.save(user);
		return user;
	}

	@Override
	public Optional<User> searchUser(String userName) {
		return repository.findById(userName);
		
	}

	@Override
	public int deleteUser(String userName) {
		repository.deleteById(userName);
		return 1;
	}

	@Override
	public User updateUser(User user) {
		repository.save(user);
		return user;
	}

	
	

}
