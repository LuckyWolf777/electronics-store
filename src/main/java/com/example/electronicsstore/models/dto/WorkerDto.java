package com.example.electronicsstore.models.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class WorkerDto {
    private int id;
    private String name;
    private String phoneNumber;
    @Email
    private String eMail;
}
