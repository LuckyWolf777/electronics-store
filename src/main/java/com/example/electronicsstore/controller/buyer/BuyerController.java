package com.example.electronicsstore.controller.buyer;

import com.example.electronicsstore.models.dto.BuyerLogDto;
import com.example.electronicsstore.models.entity.Buyer;
import com.example.electronicsstore.models.entity.BuyerLog;
import com.example.electronicsstore.service.BuyerLogService;
import com.example.electronicsstore.service.BuyerLogServiceImp;
import com.example.electronicsstore.service.buyer.BuyerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerController {

    private final BuyerServiceImp buyerService;

    public BuyerController(BuyerServiceImp buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/new")
    public Buyer create(@RequestBody Buyer buyer) {
        buyerService.create(buyer);
        return buyer;
    }

    @GetMapping("/show")
    public List<Buyer> getAllBuyer() {
        return buyerService.getAllBuyer();
    }


}
