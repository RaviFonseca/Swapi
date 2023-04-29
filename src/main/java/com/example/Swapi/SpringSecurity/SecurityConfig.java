//package com.example.Swapi.SpringSecurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/auth/**").permitAll()
//                .requestMatchers("/api/**").hasAnyRole("USER","ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/api/auth/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/api/auth/logout")
//                .permitAll()
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint()
//    }
//
//    @Autowired
//    public void configuredGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public Jwt
//
//}
