package com.example.electronicsstore.service.product;

import com.example.electronicsstore.models.dto.ProductDto;
import com.example.electronicsstore.models.entity.Product;
import com.example.electronicsstore.exception.product.ProductException;
import com.example.electronicsstore.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ProductServiceImp implements ProductService {
    private final ProductRepository prodRepo;
    @Override
    public Product findById(Long id) {
        log.info("Starting of findById: {}" , id);
        return prodRepo.findById(id).orElseThrow(() -> new ProductException("PRODUCT " + id, "PRODUCT_NOT_FOOUND ", LocalDateTime.now().toString()));
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Starting of GetAllProducts");
        return prodRepo.findAll();
    }

    @Transactional
    @Override
    public Product create(ProductDto dto) {
        Product product = new Product();
        product.setBrand(dto.getBrand());
        product.setModel(dto.getModel());
        product.setSerialNumber(dto.getSerialNumber());
        product.setStorageCapacity(dto.getStorageCapacity());
        product.setDescription(dto.getDescription());
        product.setColor(dto.getColor());
        product.setScreenSize(dto.getScreenSize());
        product.setRam(dto.getRam());
        product.setCategory(dto.getCategory());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        log.info("Create product");
        return prodRepo.save(product);
    }

    @Override
    public List<Product> getProductCategory(String cat) {
        log.info("product category shown");
        return prodRepo.findByCategory(cat);
    }

    @Override
    public void delete(Long id) {
        prodRepo.deleteById(id);
        log.info("product id: {}  deleted", id);
    }

    @Transactional
    @Override
    public Product updateProduct(Long id, ProductDto dto) {
        Optional<Product> optionalProduct = prodRepo.findById(id);
        Product updateProduct = optionalProduct.get();
        updateProduct.setBrand(dto.getBrand());
        updateProduct.setModel(dto.getModel());
        updateProduct.setSerialNumber(dto.getSerialNumber());
        updateProduct.setStorageCapacity(dto.getStorageCapacity());
        updateProduct.setDescription(dto.getDescription());
        updateProduct.setColor(dto.getColor());
        updateProduct.setScreenSize(dto.getScreenSize());
        updateProduct.setRam(dto.getRam());
        updateProduct.setCategory(dto.getCategory());
        updateProduct.setQuantity(dto.getQuantity());
        updateProduct.setPrice(dto.getPrice());
        log.info("product id: {} update", id);
        return prodRepo.save(updateProduct);
    }

    @Override
    public List<Product> getFilter(String p1, int salary) {
        List<Product> filter = prodRepo.findByCategory(p1);
        if (filter.isEmpty()) {
            throw new RuntimeException("Not product to category");
        }
        filter = filter.stream()
                .filter(product -> product.getPrice() >= salary)
                .collect(Collectors.toList());
        log.info("product filter shown");
        return filter;
    }
}