package com.example.electronicsstore.repository.product;

import com.example.electronicsstore.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByCategory(String cat);
    Product findByPrice(int price);
}