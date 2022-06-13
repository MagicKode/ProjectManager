package com.example.projectmanager.controller.exceptionHandler;

import com.example.projectmanager.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> entity(NotFoundException notFoundException) {
        return new ResponseEntity(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
