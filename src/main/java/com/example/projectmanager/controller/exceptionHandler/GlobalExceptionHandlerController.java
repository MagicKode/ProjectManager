package com.example.projectmanager.controller.exceptionHandler;

import com.example.projectmanager.exception.NotFoundException;
import com.example.projectmanager.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandlerController {
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> entity(NotFoundException notFoundException) {
        logger.log(Level.SEVERE, notFoundException.getMessage(), notFoundException);
        return new ResponseEntity(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
