package com.shanpadayhag.event_service.configs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shanpadayhag.event_service.exceptions.core.NotFoundException;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException exception) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        String message = extractReadableErrorMessage(exception);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
        body.put("message", "Validation failed for the request");
        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException exception) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", "Aw, Sorry About That!");
        errorBody.put("message", exception.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    private String extractReadableErrorMessage(HttpMessageNotReadableException exception) {
        Throwable rootCause = exception.getMostSpecificCause();

        if (rootCause instanceof DateTimeParseException) {
            return "Invalid date format. Please use 'yyyy-MM-dd HH:mm:ss'.";
        } else if (exception.getMessage().contains("Required request body is missing")) {
            return "The request body is missing. Please provide the required data.";
        } else {
            return "Invalid input. Please check your data.";
        }
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}
