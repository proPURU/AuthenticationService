package com.example.authenticationservice.Controller;

import com.example.authenticationservice.Dtos.LoginDTO;
import com.example.authenticationservice.Models.User;
import com.example.authenticationservice.Services.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService)
    {
     this.authenticationService=authenticationService;
    }
    //Converter
    User convertDTO_to_Model(LoginDTO loginDTO)
    {
        User user=new User();
        user.setEmail(loginDTO.getEmailid());
        user.setPassword(loginDTO.getPassword());

        return user;
    }

    @PostMapping("/login")
    String login(LoginDTO loginDTO)
    {
        User user=convertDTO_to_Model(loginDTO);
        String token=authenticationService.login(user);
        return token;
    }

    @GetMapping("{token}")
    Boolean validate(@PathVariable ("token") String token)
    {
        return authenticationService.validate(token);
    }

}
