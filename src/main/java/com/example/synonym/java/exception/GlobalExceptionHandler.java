package com.example.synonym.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
  @SuppressWarnings("checkstyle:FinalParameters")
  @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> handleException(HttpMessageNotReadableException exception, HttpServletRequest request) {
    return new ResponseEntity("You gave an incorrect input", HttpStatus.BAD_REQUEST);
  }
}
