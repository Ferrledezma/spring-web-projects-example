package com.example.response;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponseBody {
	private HttpStatus status;
	private String path;
	private Instant instant;
	private String message;
}
