package com.example.springcrud.config.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    private final MessageService messageService;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiCustomResponse<Void>> handleEntityNotFoundException(EntityNotFoundException ex) {
        ApiCustomResponse<Void> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(apiCustomResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityCreationException.class)
    public ResponseEntity<ApiCustomResponse<Void>> handleEntityCreationException(EntityCreationException ex) {
        ApiCustomResponse<Void> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(apiCustomResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiCustomResponse<Void>> handleGlobalException() {
        ApiCustomResponse<Void> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value(), messageService.getMessage("error.handleGlobalException"));
        return new ResponseEntity<>(apiCustomResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ApiCustomResponse<Void>> securityException(Exception ex) {
        ApiCustomResponse<Void> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.UNAUTHORIZED.getReasonPhrase(), HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity<>(apiCustomResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiCustomResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiCustomResponse<Map<String, String>> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), messageService.getMessage("error.handleValidationExceptions"), errors);
        apiCustomResponse.setDataCount(errors.size());

        return ResponseEntity.badRequest().body(apiCustomResponse);
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<ApiCustomResponse<Void>> handleAuthException(Exception ex) {
        ApiCustomResponse<Void> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value(), (ex.getMessage()));
        return new ResponseEntity<>(apiCustomResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiCustomResponse<Void>> handleAccessDeniedException(AccessDeniedException ex) {
        ApiCustomResponse<Void> apiCustomResponse = new ApiCustomResponse<>(HttpStatus.UNAUTHORIZED.getReasonPhrase(), HttpStatus.UNAUTHORIZED.value(), messageService.getMessage("error.handleAccessDeniedException"));
        return new ResponseEntity<>(apiCustomResponse, HttpStatus.UNAUTHORIZED);
    }
}
