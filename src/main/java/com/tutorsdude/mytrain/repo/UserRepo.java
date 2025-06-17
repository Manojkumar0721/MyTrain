package com.tutorsdude.mytrain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorsdude.mytrain.dto.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
