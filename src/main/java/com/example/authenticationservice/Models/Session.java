package com.example.authenticationservice.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Session extends BaseModel {
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private User user;
    private String token;
}

