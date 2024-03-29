package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
	  String message=ex.getMessage();
	  ApiResponse apiResponse =new ApiResponse(message, false);
	  return new  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ResourceAllReadyExist.class)
	public ResponseEntity<ApiResponse>resourceAllReadyExistHandler(ResourceAllReadyExist ex){
		String message=ex.getMessage();
		ApiResponse apiResponse =new ApiResponse(message, false);
		return new  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
		
	}
}
