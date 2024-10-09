package com.example.electronicsstore.models.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column(name = "buyer_name")
    private String buyerName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String eMail;
    @Column(name = "bill")
    private int bill;
}
