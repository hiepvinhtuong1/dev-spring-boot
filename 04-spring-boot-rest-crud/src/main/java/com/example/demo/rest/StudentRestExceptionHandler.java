package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handling code here

    // Add an exception handler using @ExeptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorReponse> handleException(StudentNotFoundException e) {

        // create a StudentErrorREsponse

        StudentErrorReponse error = new StudentErrorReponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler  ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorReponse> handleException(Exception e) {

        // create a StudentErrorREsponse

        StudentErrorReponse error = new StudentErrorReponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
