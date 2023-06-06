package com.example.Swapi.SpringSecurity.repositories;

import com.example.Swapi.SpringSecurity.configs.UserToken;
import com.example.Swapi.SpringSecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserTokenRepository extends JpaRepository<UserToken, Long> {
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM UserToken t WHERE t.token = :token")
    boolean existsByToken(@Param("token") String token);

    @Query("SELECT t FROM UserToken t WHERE t.token = :token")
    Optional<UserToken> findByToken(@Param("token") String token);

    @Query("SELECT t FROM UserToken t WHERE t.user = :user")
    Optional<UserToken> findByUser(@Param("user") User user);
}
