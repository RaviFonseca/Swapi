package com.example.Swapi.SpringSecurity.configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionCreationService {


    private final HttpServletRequest request;

    public SessionCreationService(HttpServletRequest request) {
        this.request = request;
    }

    public String createSession (Authentication authentication){
        String token = UUID.randomUUID().toString();
        HttpSession session = request.getSession(true);
        session.setAttribute("token",token);
        session.setAttribute("authentication",authentication);

        System.out.println("Created session for user: " + authentication.getName());
        return token;
    }


    public Authentication getAuthentication(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            Authentication authentication = (Authentication) session.getAttribute("authentication");
            if (authentication != null) {
                System.out.println("Retrieved session for user: " + authentication.getName());
            } else {
                System.out.println("No session found for session ID: " + session.getId());
            }
            return authentication;
        }else{
            System.out.println("No session found for this request");
            return null;
        }
    }
}
