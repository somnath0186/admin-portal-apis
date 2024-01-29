package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.UserDto;
import com.example.demo.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
	UserDto saveUser =this.userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(saveUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/update_user/{userId}")
	private ResponseEntity<UserDto>updateAdmin(@RequestBody UserDto userDto,@PathVariable Integer userId){
	UserDto updateUser	=this.userService.updateUser(userDto, userId);
	return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	private ResponseEntity<UserDto>getsingleAdmin(@PathVariable Integer userId){
	UserDto foundUser	=this.userService.getUserById(userId);
	return new ResponseEntity<UserDto>(foundUser,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	private ResponseEntity<List<UserDto>> getAllAdmin(){
List<UserDto> userList	=	this.userService.getAllUsers();
return new ResponseEntity<List<UserDto>>(userList,HttpStatus.OK);
	}
	
}
