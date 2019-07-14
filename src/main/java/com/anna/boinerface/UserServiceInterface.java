package com.anna.boinerface;

import java.util.List;
import java.util.Optional;

import com.anna.component.User;

public interface UserServiceInterface {
	public List<User> getUserList();
	public User saveUserList(User user);
	public Optional<User> searchUser(String userName);
	public int deleteUser(String userName);
	public User updateUser(User user);

}
