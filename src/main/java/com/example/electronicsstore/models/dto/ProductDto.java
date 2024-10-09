package com.example.electronicsstore.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductDto {

    private Long id;

    @NotBlank(message = "The field must not be empty")
    private String brand;

    @NotBlank(message = "The field must not be empty")
    private String model;

    @NotBlank(message = "The field must not be empty")
    private String serialNumber;

    @NotNull(message = "The field must not be empty")
    private int storageCapacity;

    @NotBlank(message = "The field must not be empty")
    private String description;

    @NotBlank(message = "The field must not be empty")
    private String color;

    @NotBlank(message = "The field must not be empty")
    private String screenSize;

    @NotNull(message = "The field must not be empty")
    private int ram;

    @NotBlank(message = "The field must not be empty")
    private String category;

    @NotNull(message = "The field must not be empty")
    private int quantity;

    @NotNull(message = "The field must not be empty")
    private int price;
}
