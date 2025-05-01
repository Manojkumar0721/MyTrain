package com.tutorsdude.mytrian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorsdude.mytrian.dto.User;
import com.tutorsdude.mytrian.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public String createUser(@RequestBody User user) {
		if(user!=null) {
			service.createUser(user);
			return "User added successfully";
		}
		return "User not added try again";
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable int id){
		return service.getAllUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User userDetails) {
		return service.updateUser(id, userDetails);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		if(id>0) {
			service.deleteUser(id);
			return "User deleted successfully";
		}
		return "Task not deleted try again";
	}

}
