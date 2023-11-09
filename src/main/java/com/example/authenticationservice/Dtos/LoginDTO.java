package com.example.authenticationservice.Dtos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginDTO {

    private String emailid;
    private String password;
}
