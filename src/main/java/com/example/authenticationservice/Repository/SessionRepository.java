package com.example.authenticationservice.Repository;

import com.example.authenticationservice.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
     Session findSessionByToken(String token);

}
