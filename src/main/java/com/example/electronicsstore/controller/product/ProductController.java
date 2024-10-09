package com.example.electronicsstore.controller.product;

import com.example.electronicsstore.models.dto.ProductDto;
import com.example.electronicsstore.models.entity.Product;
import com.example.electronicsstore.service.product.ProductService;
import com.example.electronicsstore.service.product.ProductServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ProductController", description = "Контроллер для работы с продукцией")
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImp prodServ;

    @Operation(summary = "Добавление товара")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар добавлен",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Некорректные данные", content = @Content)
    })
    @PostMapping("/new")
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDto dto) {
        return new ResponseEntity<>(prodServ.create(dto), HttpStatus.OK);
    }

    @Operation(summary = "Посмотреть все товары")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары по вашему запросу",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Товары не найдены", content = @Content)
    })
    @GetMapping("/show")
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(prodServ.getAllProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Показать товар по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары по вашему введеному вами ID",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Товар по вашему ID не найден", content = @Content)
    })
    @GetMapping("/get-id/{id}")
    public ResponseEntity<Product> showID(@PathVariable("id") Long id) {
        return new ResponseEntity<>(prodServ.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Фильтрация по цене")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары по вашему запросу",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Товары по вашему запросу не найдены", content = @Content)
    })
    @GetMapping("/get-p1")
    public ResponseEntity<List<Product>> getCat(@RequestParam String p1) {
        return new ResponseEntity<>(prodServ.getProductCategory(p1), HttpStatus.OK);
    }

    @Operation(summary = "Фильтрация по категории и цене")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары по вашему запросу",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Товары по вашему запросу не найдены", content = @Content)
    })
    @GetMapping("/temp")
    public List<Product> getProduct(String p1, int salary) {
        return prodServ.getFilter(p1, salary);
    }

    @Operation(summary = "Обновление товара по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар обновлен",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Некорректные данные", content = @Content)
    })
    @PatchMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDto dto) {
        Product product = prodServ.updateProduct(id, dto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Operation(summary = "Удаление товара по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар по ID удален",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Товар по вашему ID не найден", content = @Content)
    })
    @DeleteMapping("/delete")
    public void delete(Long id) {
        prodServ.delete(id);
    }
}