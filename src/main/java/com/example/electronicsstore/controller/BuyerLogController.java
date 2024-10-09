package com.example.electronicsstore.controller;

import com.example.electronicsstore.models.dto.BuyerLogDto;
import com.example.electronicsstore.service.BuyerLogServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class BuyerLogController {
    private final BuyerLogServiceImp logService;

    @PostMapping("/buy/{id}")
    public ResponseEntity<String> buy(@RequestBody BuyerLogDto buyerLogDto, @PathVariable Long id) {
        BuyerLogDto result = logService.buy(buyerLogDto, id);
        return ResponseEntity.ok("Purchase recorded successfully");
    }
}
