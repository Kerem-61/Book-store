package com.example.publishermicroservice.controller.handler;


import com.example.publishermicroservice.application.business.exceptions.PublisherAlreadyExistException;
import com.example.publishermicroservice.application.business.exceptions.PublisherNotFoundException;
import com.example.publishermicroservice.dto.error.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestControllerErrorHandler {
	@ExceptionHandler(PublisherNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleCustomerNotFoundException(PublisherNotFoundException e) {
		return new ErrorResponse("Customer Rest API", e.getMessage());
	}

	@ExceptionHandler(PublisherAlreadyExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleCustomerAlreadyExistException(PublisherNotFoundException e) {
		return new ErrorResponse("Customer Rest API", e.getMessage());
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ErrorResponse handleRuntimeException(RuntimeException e) {
		return new ErrorResponse("Application", e.getMessage());
	}
	
	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse handleExpiredJwtException(ExpiredJwtException e) {
		return new ErrorResponse("Security", e.getMessage());
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		var message = e.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList().toString();
		return new ErrorResponse("Validation", message);
	}
}
