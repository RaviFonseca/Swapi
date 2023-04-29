package com.example.Swapi.repositories;

import com.example.Swapi.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface SpeciesRepository extends JpaRepository<Species,Long> {

    @Query("Select p.id FROM Species p WHERE p.name = :name")
    Long findIdByName(@Param("name") String name);
}
