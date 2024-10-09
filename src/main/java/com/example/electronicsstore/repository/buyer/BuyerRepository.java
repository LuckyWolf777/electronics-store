package com.example.electronicsstore.repository.buyer;

import com.example.electronicsstore.models.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
}
