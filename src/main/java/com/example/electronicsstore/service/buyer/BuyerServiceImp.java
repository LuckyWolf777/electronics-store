package com.example.electronicsstore.service.buyer;

import com.example.electronicsstore.models.entity.Buyer;
import com.example.electronicsstore.repository.buyer.BuyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BuyerServiceImp implements BuyerService{
    private final BuyerRepository buyerRepo;

    public BuyerServiceImp(BuyerRepository buyerRepo) {
        this.buyerRepo = buyerRepo;
    }

    @Override
    public Buyer create(Buyer buyer) {
        return buyerRepo.save(buyer);
    }

    @Override
    public List<Buyer> getAllBuyer() {
        return buyerRepo.findAll();
    }
}
