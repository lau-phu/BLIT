package com.example.demo.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.StuffWorksException;

@RestControllerAdvice
public class StuffExceptionHandler {

//	@ResponseStatus(HttpStatus.OK)
//	@ExceptionHandler(value= {StuffWorksException.class})
//	public ResponseEntity<Object> StuffShouldNotWorkException(StuffWorksException stuffWorksException){
//		return new ResponseEntity<>("well, you are not allowed to do this.. but i will let this be an exception.", HttpStatus.OK);
//	}
}
