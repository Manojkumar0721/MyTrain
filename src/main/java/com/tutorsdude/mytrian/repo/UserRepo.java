package com.tutorsdude.mytrian.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorsdude.mytrian.dto.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
