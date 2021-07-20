package com.asset.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistsException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 3591007738066103764L;

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }
}