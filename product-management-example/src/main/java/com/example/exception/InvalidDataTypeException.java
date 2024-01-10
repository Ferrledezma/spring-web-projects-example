package com.example.exception;

public class InvalidDataTypeException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public InvalidDataTypeException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidDataTypeException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
