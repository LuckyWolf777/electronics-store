package com.example.electronicsstore.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BuyerLogDto {
    private int id;
    private String buyer;
    private String product;
    private LocalDateTime localDateTime;
    private void onCreate() {
        this.localDateTime = LocalDateTime.now();
    }
}
