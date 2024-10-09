package com.example.electronicsstore.controller.product;

import com.example.electronicsstore.models.dto.ProductDto;
import com.example.electronicsstore.models.entity.Product;
import com.example.electronicsstore.service.product.ProductService;
import com.example.electronicsstore.service.product.ProductServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class WebProductController {

    private final ProductServiceImp prodServ;

    @GetMapping("/temp")
    public String showProducts(Model model) {
        model.addAttribute("products", prodServ.getAllProducts());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") ProductDto dto) {
        prodServ.create(dto);
        return "redirect:/web/temp";
    }

    @GetMapping("/show-id/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Product product = prodServ.findById(id);
        model.addAttribute("product", product);
        return "productDetails";

    }
    
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        prodServ.delete(id);
        return "redirect:/web/temp";
    }
}

