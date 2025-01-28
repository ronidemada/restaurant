package com.example.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlatNotFoundException extends RuntimeException {
    public PlatNotFoundException(String message) {
        super(message);
    }
}
