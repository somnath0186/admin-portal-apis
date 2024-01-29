package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByMobileNumber(String mobileNumber);

}
