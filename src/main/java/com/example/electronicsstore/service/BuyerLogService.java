package com.example.electronicsstore.service;

import com.example.electronicsstore.models.dto.BuyerLogDto;
import org.springframework.stereotype.Service;

@Service
public interface BuyerLogService {
    BuyerLogDto buy (BuyerLogDto buyerLogDto, Long id);
}
