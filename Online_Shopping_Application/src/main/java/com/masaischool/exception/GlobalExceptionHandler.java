package com.masaischool.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ErrorDetails> invalidEmailHandler(InvalidEmailException iee){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(),iee.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundHandler(NotFoundException iee){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(),iee.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> validationHandler(MethodArgumentNotValidException iee){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(),iee.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
}
