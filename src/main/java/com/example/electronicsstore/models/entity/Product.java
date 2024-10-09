package com.example.electronicsstore.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column ( name = "brand")
    private String brand;
    @Column ( name = "model")
    private String model;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column ( name = "storage_capacity")
    private int storageCapacity;
    @Column ( name = "description")
    private String description;
    @Column ( name = "color")
    private String color;
    @Column ( name = "screen_size")
    private String screenSize;
    @Column ( name = "ram")
    private int ram;
    @Column ( name = "category")
    private String category;
    @Column ( name = "quantity")
    private int quantity;
    @Column ( name = "price")
    private int price;
}
