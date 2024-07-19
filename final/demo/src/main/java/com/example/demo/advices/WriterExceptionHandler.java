package com.example.demo.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.StuffWorksException;
import com.example.demo.exception.WriterNotFoundException;

@RestControllerAdvice
public class WriterExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {WriterNotFoundException.class})
	public ResponseEntity<Object> handleWriterNotFoundException(WriterNotFoundException writerNotFoundException){
		return new ResponseEntity<>("yo~ you got "+ HttpStatus.NOT_FOUND +" because stuff you asked doesn't exists", HttpStatus.NOT_FOUND);
	}
	

}
