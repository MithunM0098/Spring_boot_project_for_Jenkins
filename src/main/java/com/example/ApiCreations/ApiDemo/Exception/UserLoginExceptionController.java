package com.example.ApiCreations.ApiDemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserLoginExceptionController {

    @ExceptionHandler(value = {UserLoginNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserLoginNotFoundException ex) {
        UserLoginException response = new UserLoginException(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public ResponseEntity<Object> handleIncorrectCredentialsException(IncorrectCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
    
    public ResponseEntity<Object> handleUserFavFoodException(UserFavFoodNotFound ex){
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
}