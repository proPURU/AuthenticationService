package com.example.authenticationservice.Services;

import com.example.authenticationservice.Models.Session;
import com.example.authenticationservice.Models.User;
import org.springframework.stereotype.Service;


public interface AuthenticationService {

    String login(User user);
    Boolean validate(String token);

}
