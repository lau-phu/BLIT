package com.example.demo.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exception.DiaryNotFoundException;
import com.example.demo.exception.StuffWorksException;

public class DiaryExceptionHandler {

	
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler(value= {DiaryNotFoundException.class})
	public ResponseEntity<Object> handleDiaryNotFoundException(DiaryNotFoundException diaryNotFoundException){
		return new ResponseEntity<>("yo~ you got "+ HttpStatus.I_AM_A_TEAPOT +" because stuff you asked doesn't exists", HttpStatus.I_AM_A_TEAPOT);
	}
	

}
