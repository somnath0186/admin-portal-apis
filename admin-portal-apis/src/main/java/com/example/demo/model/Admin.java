package com.example.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int adminId;
	    private String adminName;
	    private String email;
	    private String mobileNumber;
	    private String photoUrl;
	    private String password;
	    private String status;


}
