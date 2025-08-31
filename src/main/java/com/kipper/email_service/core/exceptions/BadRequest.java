package com.kipper.email_service.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}
