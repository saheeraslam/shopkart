package com.example.onlinekart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException ex) {
	        Map<String, Object> error = new HashMap<>();
	        error.put("error", ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	    }
}
