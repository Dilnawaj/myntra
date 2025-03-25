package com.app.myntra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", ex.getCode());
        errorResponse.put("error", HttpStatus.valueOf(ex.getCode()).getReasonPhrase());
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.valueOf(ex.getCode())).body(errorResponse);
    }
}
