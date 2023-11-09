package com.example.authenticationservice.Services;

import com.example.authenticationservice.Models.Session;
import com.example.authenticationservice.Models.User;
import com.example.authenticationservice.Repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

@Service
public class SelftAuthenticationService implements AuthenticationService{
    SessionRepository sessionRepository;

    public SelftAuthenticationService(SessionRepository sessionRepository)
    {
        this.sessionRepository=sessionRepository;
    }

    String random()
    {
        byte[] array = new byte[20];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }




    @Override
    public String login(User user) {
       String token="check";


        Session session=new Session();
        session.setToken(token);
        session.setUser(user);
        session.setId(user.getId());
        sessionRepository.save(session);

        return token;
    }






    @Override
    public Boolean validate(String token)
    {
        //call and check
        Session session= sessionRepository.findSessionByToken(token);
        if(session!=null && (session.getToken()).equals(token)) return true;
        return false;
    }
}
