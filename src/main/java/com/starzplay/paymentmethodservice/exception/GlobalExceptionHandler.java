package com.starzplay.paymentmethodservice.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex){
        ExceptionResponse error = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
