package com.example.Swapi.repositories;


import com.example.Swapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { // com o Long garanto que cada registo tem um identificador unico e exclusivo

}
