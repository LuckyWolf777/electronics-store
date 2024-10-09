package com.example.electronicsstore.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "worker_name")
    private String name;
    @Column (name = "phone_number")
    private String phoneNumber;
    @Column (name = "email")
    private String eMail;
}
//todo сделать: возможнсть добавлять в корзину товар и далее покупать. так же связи таблиц и журнал дпокупок. и настройка ролей
