package com.dhanushs.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidation extends RuntimeException{
    public RequestValidation(String message) {
        super(message);
    }
}
