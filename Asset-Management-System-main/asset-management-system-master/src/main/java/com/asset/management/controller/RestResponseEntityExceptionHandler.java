package com.asset.management.controller;

import com.asset.management.exceptions.EmailExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<Object> emailAlreadyExists(HttpServletRequest request, Exception ex) {

        LinkedHashMap<String, String> errorResponseMap = new LinkedHashMap<String, String>();
        errorResponseMap.put("status", "400");
        errorResponseMap.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponseMap, HttpStatus.BAD_REQUEST);

    }
}