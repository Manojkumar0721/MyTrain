package com.tutorsdude.mytrain.service;

import java.util.List;
import java.util.Optional;

import com.tutorsdude.mytrain.dto.User;

public interface UserService {
	
	public boolean createUser(User user);
	
	public List<User> getAllUser();
	
	public Optional<User> getAllUserById(int id);
	
	public User updateUser(int id,User userDetails);
	
	public void deleteUser(int id);
	
}
