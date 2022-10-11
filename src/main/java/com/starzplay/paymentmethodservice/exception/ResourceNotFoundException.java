package com.starzplay.paymentmethodservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
public class ResourceNotFoundException extends  RuntimeException{

    private HttpStatus httpStatus;
    private String message;

    public ResourceNotFoundException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ResourceNotFoundException(String message) {
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.message = message;
    }
}
