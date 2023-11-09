package com.example.authenticationservice.Services;

import com.example.authenticationservice.Models.Session;
import com.example.authenticationservice.Models.User;
import com.example.authenticationservice.Repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.security.SecureRandom;
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


    public String generate(){
        final String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;

        SecureRandom random = new SecureRandom();

        StringBuilder str1 = new StringBuilder(26);
        for (int i = 0; i < 26; i++)
            str1.append(str.charAt(random.nextInt(str.length())));
        return str1.toString();
    }


    @Override
    public String login(User user) {
       String token=generate();


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
