package com.example.demo.payload;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
	
	    private int adminId;
	    private String userName;
	    private String email;
	    private String mobileNumber;
	    private String photoUrl;
	    private String password;
	    private String status;
}
