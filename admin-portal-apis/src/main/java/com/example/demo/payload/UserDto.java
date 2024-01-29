package com.example.demo.payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int userId;
	private String name;
	private String mobileNumber;
	private String password;
	private double walletAmount;
	private String status;
}
