package com.tutorsdude.mytrain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorsdude.mytrain.dto.User;
import com.tutorsdude.mytrain.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean createUser(User user) {
		if(user!=null){
		   userRepo.save(user);
		   return true;
		}
		return false;
	}
		

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getAllUserById(int id) {
		if(id>0) {
			return userRepo.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public User updateUser(int id, User userDetails) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setId(userDetails.getId());
			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			user.setPhoneNumber(userDetails.getPhoneNumber());
			user.setAge(userDetails.getAge());
			user.setAddress(userDetails.getAddress());
			return userRepo.save(user);
		}else {
			throw new RuntimeException("User With ID" + id + " not Found");
		}
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}

}
