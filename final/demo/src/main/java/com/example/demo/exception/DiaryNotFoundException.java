package com.example.demo.exception;

public class DiaryNotFoundException extends RuntimeException{

	public DiaryNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DiaryNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DiaryNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
