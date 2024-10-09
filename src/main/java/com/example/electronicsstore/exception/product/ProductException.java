package com.example.electronicsstore.exception.product;

import lombok.Getter;

@Getter
public class ProductException extends RuntimeException{
    private String message;
    private String code;
    private String date;

    public ProductException(String message, String code, String date) {
        super(message);
        this.message = message;
        this.code = code;
        this.date = date;
    }
}
