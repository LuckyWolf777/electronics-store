package com.example.electronicsstore.models.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "buyer_log")
public class BuyerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "buyer")
    private String buyer;
    @Column(name = "product")
    private String product;
    @Column(name = "date_sell", updatable = false)
    private LocalDateTime localDateTime;

    @PrePersist
    private void onCreate() {
        this.localDateTime = LocalDateTime.now();
    }
}
