package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.loginDetails;
import com.example.demo.payload.AdminDto;
import com.example.demo.payload.ApiResponse;



public interface AdminService {
	
	 AdminDto registerAdmin(AdminDto AdminDto);
	 AdminDto updateAdmin(AdminDto AdminDto,Integer uderId);
	 List<AdminDto> getAllAdmins();
	 AdminDto getAdminById(Integer userId);

	 
	
	

}
