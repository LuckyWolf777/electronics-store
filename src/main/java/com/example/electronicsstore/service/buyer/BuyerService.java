package com.example.electronicsstore.service.buyer;

import com.example.electronicsstore.models.entity.Buyer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface BuyerService {
    Buyer create (Buyer buyer);
    List<Buyer> getAllBuyer();
}