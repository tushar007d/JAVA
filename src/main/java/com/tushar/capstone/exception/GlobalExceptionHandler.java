package com.tushar.capstone.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	
		@ExceptionHandler
		public ResponseEntity<?> InternalServerError(ClassCastException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		@ExceptionHandler
		public ResponseEntity<?> NullPointerException(NullPointerException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler
		public ResponseEntity<?> InternalServerError (HttpRequestMethodNotSupportedException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.METHOD_NOT_ALLOWED );
		}
		@ExceptionHandler
		public ResponseEntity<?> serverError(DataIntegrityViolationException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler
		public ResponseEntity<?>NoDataFound(NoDataException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
		
		@ExceptionHandler
		public ResponseEntity<?> inputError(InputDataError e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		@ExceptionHandler
		public ResponseEntity<?> insufficentFund(InsufficientFunds e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONTINUE);
			
		}
	

	
}
