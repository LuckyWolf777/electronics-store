package com.example.electronicsstore.repository;

import com.example.electronicsstore.models.entity.BuyerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerLogRepository extends JpaRepository<BuyerLog, Long> {
    Optional<BuyerLog> findById (Long id);
}
