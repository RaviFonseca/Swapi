package com.example.Swapi.SpringSecurity.configs;

import com.example.Swapi.SpringSecurity.entities.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtTokenProvider {
    @Value("${app.jwtSecret}")
    private String jwtSecret;
    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(principal.getPassword())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            System.out.println("Invalid JWT signature");
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex ){
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT token");
        }catch (IllegalArgumentException ex ){
            System.out.println("JWT claims string is empty!");
        }
        return false;
    }
}
