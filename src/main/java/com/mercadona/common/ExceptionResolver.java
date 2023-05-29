package com.mercadona.common;

import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;

@ControllerAdvice

public class ExceptionResolver {
 @ExceptionHandler
    public ResponseEntity handleValidationException(MethodArgumentNotValidException exception) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleException(Exception exception) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    
}
