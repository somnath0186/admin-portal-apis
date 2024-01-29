package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.AdminDto;
import com.example.demo.services.AdminService;

import jakarta.persistence.PostUpdate;

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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<AdminDto> registerAdmin(@RequestBody AdminDto userDto) {
	AdminDto saveUser =this.adminService.registerAdmin(userDto);
		
		return new ResponseEntity<AdminDto>(saveUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/update_admin/{adminId}")
	private ResponseEntity<AdminDto>updateAdmin(@RequestBody AdminDto userDto,@PathVariable Integer adminId){
	AdminDto updateUser	=this.adminService.updateAdmin(userDto, adminId);
	return new ResponseEntity<AdminDto>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/{adminId}")
	private ResponseEntity<AdminDto>getsingleAdmin(@PathVariable Integer adminId){
	AdminDto foundUser	=this.adminService.getAdminById(adminId);
	return new ResponseEntity<AdminDto>(foundUser,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	private ResponseEntity<List<AdminDto>> getAllAdmin(){
List<AdminDto> userList	=	this.adminService.getAllAdmins();
return new ResponseEntity<List<AdminDto>>(userList,HttpStatus.OK);
	}

}
