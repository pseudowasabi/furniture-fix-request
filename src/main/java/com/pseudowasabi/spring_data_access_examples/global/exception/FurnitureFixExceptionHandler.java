package com.pseudowasabi.spring_data_access_examples.global.exception;

import com.pseudowasabi.spring_data_access_examples.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FurnitureFixExceptionHandler {

    @ExceptionHandler(FurnitureFixRequestException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureFixRequestException(FurnitureFixRequestException furnitureFixRequestException) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(furnitureFixRequestException.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
