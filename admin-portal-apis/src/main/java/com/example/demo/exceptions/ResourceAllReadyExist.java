package com.example.demo.exceptions;

import lombok.Data;

@Data
public class ResourceAllReadyExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	int id;
	
	public ResourceAllReadyExist(String message,int id) {
		
		super(String.format("%s : %s",message,id));
		this.message=message;
		this.id=id;
	}
	

}
