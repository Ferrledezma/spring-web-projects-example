package com.example.exception;

import jakarta.persistence.EntityNotFoundException;

public class DatabaseResourceNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public DatabaseResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public DatabaseResourceNotFoundException(Exception cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DatabaseResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DatabaseResourceNotFoundException(String message, Exception cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
