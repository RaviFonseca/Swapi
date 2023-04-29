package com.example.Swapi.repositories;

import com.example.Swapi.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long> {

    @Query("Select p.id FROM Planet p WHERE p.name = :name")
    Long findIdByName(@Param("name") String name);

//    @Query("Select p.id FROM Planet p WHERE p.id = :id")
//    Optional<Long> findPlanetId(@Param("name") Long id); // aplicar no PersonService

    @Query("SELECT p FROM Planet p WHERE p.name = :name")
    Optional<Planet> findPlanetByName(@Param("name") String name);



}
