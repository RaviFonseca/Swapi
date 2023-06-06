package com.example.Swapi.SpringSecurity.configs;

import com.example.Swapi.SpringSecurity.entities.User;
import com.example.Swapi.SpringSecurity.repositories.UserRepository;
import com.example.Swapi.SpringSecurity.repositories.UserTokenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final SessionCreationService sessionCreationService;
    ///////
    private final UserTokenRepository userTokenRepository;
    private final UserRepository userRepository;

    public LoginController(AuthenticationManager authenticationManager, SessionCreationService sessionCreationService, UserTokenRepository userTokenRepository, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.sessionCreationService = sessionCreationService;
        ////
        this.userTokenRepository = userTokenRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = sessionCreationService.createSession(authentication);
            System.out.println("Created session with token: " + token);
            User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(()-> new EntityNotFoundException("User not found"));
            LocalDateTime expiryDate = LocalDateTime.now().plusHours(1);
            UserToken userToken = new UserToken(user,token,expiryDate);
            userTokenRepository.save(userToken);
            return ResponseEntity.ok(new TokenResponse(token));
        } catch (AuthenticationException e){
            System.out.println("Failed to authenticate user: " + loginRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
