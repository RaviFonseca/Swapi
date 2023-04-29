package com.example.Swapi.repositories;

import com.example.Swapi.entities.Starship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StarshipRepository extends JpaRepository<Starship,Long> {
}