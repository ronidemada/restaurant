package com.example.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlatExistException extends RuntimeException {
    public PlatExistException(String message) {
        super(message);
    }
}
