package com.example.electronicsstore.config.exception;

import com.example.electronicsstore.models.dto.ExceptionResponse;
import com.example.electronicsstore.exception.product.ProductException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class    CustomExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ExceptionResponse> handleProductNotFoundException (ProductException e) {
        log.error("not found", e);
        return new ResponseEntity<>(generationException(e), HttpStatus.NOT_FOUND);
    }

    private ExceptionResponse generationException(ProductException e) {
        return new ExceptionResponse(e.getMessage(), e.getCode(), e.getDate());
    }
}
