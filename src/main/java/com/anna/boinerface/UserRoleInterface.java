package com.anna.boinerface;

import java.util.List;
import java.util.Optional;

import com.anna.component.UserRole;


public interface UserRoleInterface {
	
	public List<UserRole> getUserRoleList();
	public UserRole saveUserRole(UserRole userRole);
	public Optional<UserRole> searchUserRole(String userRoleName);
	public int deleteUserRole(String userName);
	public UserRole updateUserRole(UserRole userRole);

}
