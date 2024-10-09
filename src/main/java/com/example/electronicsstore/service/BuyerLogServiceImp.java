package com.example.electronicsstore.service;

import com.example.electronicsstore.models.dto.BuyerDto;
import com.example.electronicsstore.models.dto.BuyerLogDto;
import com.example.electronicsstore.models.dto.ProductDto;
import com.example.electronicsstore.models.entity.BuyerLog;
import com.example.electronicsstore.models.entity.Product;
import com.example.electronicsstore.repository.BuyerLogRepository;
import com.example.electronicsstore.repository.buyer.BuyerRepository;
import com.example.electronicsstore.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyerLogServiceImp implements BuyerLogService{
    private final BuyerLogRepository logRepo;
    private final ProductRepository prodRepo;
    private BuyerDto buyerDto;
    private ProductDto productDto;
    private final BuyerRepository buyerRepository;

//    @Override
//    public BuyerLogDto buy(BuyerLogDto buyerLogDto, Long id) {
//        Product product = prodRepo.findById(id).get();
//        BuyerLog buyerLog = new BuyerLog();
//        buyerLog.setBuyer(buyerLogDto.getBuyer());
//        buyerLog.setProduct(product.getBrand());
//        buyerLog.setLocalDateTime(LocalDateTime.now());
//        return buyerLogDto;
//    }
    @Override
    public BuyerLogDto buy(BuyerLogDto buyerLogDto, Long id) {
        Product product = prodRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        BuyerLog buyerLog = new BuyerLog();
        buyerLog.setBuyer(buyerLogDto.getBuyer());
        buyerLog.setProduct(product.getBrand());
        buyerLog.setLocalDateTime(LocalDateTime.now());
        BuyerLog savedBuyerLog = logRepo.save(buyerLog);
        BuyerLogDto savedBuyerLogDto = new BuyerLogDto();
        savedBuyerLogDto.setBuyer(savedBuyerLog.getBuyer());
        savedBuyerLogDto.setProduct(savedBuyerLog.getProduct());
        savedBuyerLogDto.setLocalDateTime(savedBuyerLog.getLocalDateTime());
        log.info("Buyer log: {}", savedBuyerLogDto);
        return savedBuyerLogDto;
    }
}
