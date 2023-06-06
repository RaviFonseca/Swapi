package com.example.Swapi.SpringSecurity.configs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {


    private final SessionCreationService sessionCreationService;

    public TokenAuthenticationFilter(SessionCreationService sessionCreationService) {
        this.sessionCreationService = sessionCreationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Authentication authentication = sessionCreationService.getAuthentication(request);// authentication esta a vir a null
            if ( authentication != null){
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("Successfully authenticated user for token: " + token);
                System.out.println("Authentication: "+authentication);
            }else {
                System.out.println("Failed to authenticate user for token: " + token);
            }
        }
        filterChain.doFilter(request,response);
    }
}
