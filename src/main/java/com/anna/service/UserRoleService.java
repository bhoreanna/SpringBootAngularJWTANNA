package com.anna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.UserRoleInterface;
import com.anna.component.User;
import com.anna.component.UserRole;
import com.anna.repository.UserRoleRepository;

@Service
public class UserRoleService implements UserRoleInterface{

	@Autowired
	UserRoleRepository repository;
	
	@Override
	public List<UserRole> getUserRoleList() {
		return (List<UserRole>)repository.findAll() ;	}

	@Override
	public UserRole saveUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserRole> searchUserRole(String userRoleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUserRole(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}

}
