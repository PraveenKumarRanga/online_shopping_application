package com.masaischool.exception;

public class InvalidEmailException extends RuntimeException{

	public InvalidEmailException(String msg) {
		super(msg);
	}
	
}
