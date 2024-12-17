package com.ringoxcoffee.furniture_fix_request.global.exception;

import com.ringoxcoffee.furniture_fix_request.dto.response.ErrorResponse;
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
