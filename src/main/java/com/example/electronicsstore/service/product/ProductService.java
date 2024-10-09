package com.example.electronicsstore.service.product;

import com.example.electronicsstore.models.dto.ProductDto;
import com.example.electronicsstore.models.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface ProductService {
    Product findById (Long id);
    List<Product> getAllProducts();
    Product create (ProductDto productDto);
    List<Product> getProductCategory(String cat);
    void delete (Long id);

    Product updateProduct(Long id, ProductDto dto);


    List<Product> getFilter(String p1, int salary);
}