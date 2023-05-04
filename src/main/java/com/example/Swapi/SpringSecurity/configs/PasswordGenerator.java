package com.example.Swapi.SpringSecurity.configs;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main ( String[] args){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPwd = "free";
        String encodedPwd = encoder.encode(rawPwd);
        System.out.println(encodedPwd);
    }
}
