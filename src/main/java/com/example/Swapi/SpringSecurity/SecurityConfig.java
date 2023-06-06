package com.example.Swapi.SpringSecurity;

import com.example.Swapi.SpringSecurity.configs.SessionCreationService;
import com.example.Swapi.SpringSecurity.configs.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    private final UserDetailsService userDetailsService;
    private final SessionCreationService sessionCreationService; // Gestão de sessões

    public SecurityConfig(UserDetailsService userDetailsService, SessionCreationService sessionCreationService) {
        this.userDetailsService = userDetailsService;
        this.sessionCreationService = sessionCreationService;
    }

    //responsável por criptografar senhas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //classe que carrega informações do usuário e
    // do algoritmo de codificação de senha específico para autenticação de usuários.
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManagerBean( HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{


            http

                    .authorizeHttpRequests()
                    .requestMatchers("/api/login").permitAll()
                    .requestMatchers(HttpMethod.GET,"/api/**").permitAll()
                    .requestMatchers(HttpMethod.POST,"/api/**").hasAnyAuthority("ADMIN","EDITOR")//*
                    .requestMatchers(HttpMethod.PUT,"/api/**").hasAnyAuthority("ADMIN","EDITOR")
                    .requestMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN")
                    //.anyRequest().authenticated()
                    .and()
                    .addFilterBefore(new TokenAuthenticationFilter(sessionCreationService), UsernamePasswordAuthenticationFilter.class)
//                                .and()
//                    .httpBasic()
//                    .and()
                    .csrf().disable()
                    .sessionManagement(session  -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                            .invalidSessionUrl("/logout?expired")
                            .maximumSessions(1)
                            .maxSessionsPreventsLogin(false))
                    .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true))
            ;

            return http.build();

        }

}
