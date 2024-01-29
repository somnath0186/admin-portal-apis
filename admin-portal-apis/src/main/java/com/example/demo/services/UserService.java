package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.UserDto;

public interface UserService {
	
	 UserDto createUser(UserDto userDto);
	 UserDto updateUser(UserDto userDto,Integer uderId);
	 List<UserDto> getAllUsers();
	 UserDto getUserById(Integer userId);

}
