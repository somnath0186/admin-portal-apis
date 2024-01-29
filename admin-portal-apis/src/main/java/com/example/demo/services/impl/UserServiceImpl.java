package com.example.demo.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.User;

import com.example.demo.payload.UserDto;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = new User();

		user.setName(userDto.getName());

		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setMobileNumber(userDto.getMobileNumber());
		user.setWalletAmount(userDto.getWalletAmount());
		user.setStatus(userDto.getStatus());
		User createduser = this.userRepo.save(user);
		return this.userToDto(createduser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id=", userId));
		user.setMobileNumber(userDto.getMobileNumber());
		user.setName(userDto.getName());

		user.setWalletAmount(userDto.getWalletAmount());

		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setStatus(userDto.getStatus());
		User updatedUser = this.userRepo.save(user);

		return this.userToDto(updatedUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> usersList = users.stream().map((user) -> this.userToDto(user)).collect(Collectors.toList());
		return usersList;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not fount with id=", userId));
		return this.userToDto(user);
	}

	public UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

	public User dtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}

}
