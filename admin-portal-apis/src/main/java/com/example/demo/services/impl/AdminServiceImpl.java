package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Admin;

import com.example.demo.payload.AdminDto;

import com.example.demo.repository.AdminRepo;
import com.example.demo.services.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AdminDto registerAdmin(AdminDto AdminDto) {
	Admin admin=  this.adminRepo.save(this.dtoToAdmin(AdminDto));
		return this.adminToDto(admin);
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto, Integer adminId) {
    Admin admin  =this.adminRepo.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("User not found with id=",adminId));
    admin.setAdminName(adminDto.getUserName());
    admin.setEmail(adminDto.getUserName());
    admin.setMobileNumber(adminDto.getMobileNumber());
    admin.setPhotoUrl(adminDto.getPhotoUrl());
    admin.setStatus(adminDto.getStatus());
    admin.setPassword(adminDto.getPassword());
  Admin updatedUser = this.adminRepo.save(admin);
   
		return this.adminToDto(updatedUser) ;
	}

	@Override
	public List<AdminDto> getAllAdmins() {
	List<Admin> users=this.adminRepo.findAll();
	List<AdminDto>usersList=users.stream().map((user)-> this.adminToDto(user)).collect(Collectors.toList());
		return usersList;
	}

	@Override
	public AdminDto getAdminById(Integer adminId) {
	 Admin user= this.adminRepo.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("User not fount with id=", adminId));
		return this.adminToDto(user);
	}
	
	
	
	
	
	public AdminDto adminToDto(Admin admin) {
		return this.modelMapper.map(admin, AdminDto.class);
	}
	
	public Admin dtoToAdmin(AdminDto adminDto) {
		return this.modelMapper.map(adminDto, Admin.class);
	}



}
