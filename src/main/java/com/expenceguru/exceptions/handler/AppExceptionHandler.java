package com.expenceguru.exceptions.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.expenceguru.exceptions.PersonNotFoundException;
import com.expenceguru.exceptions.UserNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
   @ExceptionHandler(UserNotFoundException.class)
   protected ResponseEntity<Object> userNotFoundException( UserNotFoundException exception) {
       ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getErrorMessage());
       return buildResponseEntity(errorMessage);
   }
   
   @ExceptionHandler(PersonNotFoundException.class)
   protected ResponseEntity<Object> personNotFoundException( PersonNotFoundException exception) {
       ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getErrorMessage());
       return buildResponseEntity(errorMessage);
   }

	private ResponseEntity<Object> buildResponseEntity(ErrorMessage errorMessage) {
		 return new ResponseEntity<>(errorMessage, errorMessage.getStatus());
	}

}
