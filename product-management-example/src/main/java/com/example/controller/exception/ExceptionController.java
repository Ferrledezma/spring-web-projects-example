package com.example.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.DatabaseResourceNotFoundException;
import com.example.exception.InvalidDataTypeException;
import com.example.response.ErrorResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class ExceptionController {
	
	@ExceptionHandler({DatabaseResourceNotFoundException.class, InvalidDataTypeException.class})
	public ResponseEntity<ErrorResponseBody> handleUserDefinesExceptions(RuntimeException e, HttpServletRequest request){
		ErrorResponseBody body = createBodyResponse(e, request);
		log.error(e);
		return ResponseEntity.status(body.getStatus()).body(body);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<ErrorResponseBody> handleConstraintException(ConstraintViolationException e, HttpServletRequest request){
		ErrorResponseBody body = createBodyResponse(e, request);
		log.error(e);
		return ResponseEntity.status(body.getStatus()).body(body);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponseBody> handleGeneralException(Exception e, HttpServletRequest request){
		ErrorResponseBody body = createBodyResponse(e, request);
		log.error(e);
		return ResponseEntity.internalServerError().body(body);
	}
	
	private ErrorResponseBody createBodyResponse(Exception e, HttpServletRequest request) {
		HttpStatus statusCode = generateStatusCode(e);
		
		return new ErrorResponseBody(statusCode, request.getRequestURI(), Instant.now(), e.getMessage());
	}
	private HttpStatus generateStatusCode(Exception e) {
		return (e instanceof ConstraintViolationException) ? HttpStatus.BAD_REQUEST
				: (e instanceof DatabaseResourceNotFoundException) ? HttpStatus.NOT_FOUND
				: (e instanceof InvalidDataTypeException) ? HttpStatus.NOT_ACCEPTABLE
				: HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
