package com.example.Swapi.repositories;

import com.example.Swapi.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {// ENTIDADES EM SINGULAR

}
