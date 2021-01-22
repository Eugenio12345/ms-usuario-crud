package com.database.system.wsconsumedatabase.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.database.system.wsconsumedatabase.error.ErrorResponse;


@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public ResponseEntity<ErrorResponse> handlerNotFoundException(UsuarioNoEncontradoException exception){
		ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND_EXCEPTION", exception.getMessage(), 404, LocalDate.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getCode()));
	}
	
	
	
}
