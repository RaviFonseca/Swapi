package com.example.Swapi.controller;


import com.example.Swapi.Dtos.PersonFullDTO;
import com.example.Swapi.Dtos.PersonMapper;
import com.example.Swapi.Dtos.PersonSimpleDTO;
import com.example.Swapi.SpringSecurity.AuthService;
import com.example.Swapi.SpringSecurity.entities.Object;
import com.example.Swapi.entities.*;
import com.example.Swapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/people")
public class PersonController  {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AuthService authService;
    @Autowired
    private PersonService personService;


    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PersonFullDTO> createPerson(@RequestBody PersonFullDTO personDTO) {
        Person person = personMapper.toFullEntity(personDTO);


        person = personService.createPerson(person);
        PersonFullDTO createdPersonDto = personMapper.toFullDTO(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersonDto);
    }


    @GetMapping
    public ResponseEntity<List<PersonSimpleDTO>> getAllPeople(Authentication authentication)/* throws AccessDeniedException*/ {
//        if(authService.hasPermission(authentication, 1,2)){
            List<Person> people = personService.getAllPeople();
            if (people.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            List<PersonSimpleDTO> peopleDTOs = people.stream()
                    .map(personMapper::toSimpleDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(peopleDTOs);
//        }else{
//            throw new AccessDeniedException("Access denied");
//        }



    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonFullDTO> getPerson(@PathVariable("id") Long id) {

        Person person = personService.getPersonById(id);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        PersonFullDTO personFullDTO = personMapper.toFullDTO(person);

        personFullDTO.setHomeworldId(person.getHomeworld().getId());

        Set<Long> speciesIds = new HashSet<>();
        for (Species species : person.getSpecies()){
            speciesIds.add(species.getId());
        }
        personFullDTO.setSpecies(speciesIds);
        /////

        Set<Long> filmIds = new HashSet<>();
        for (Film film : person.getFilms()){
            filmIds.add(film.getId());
        }
        personFullDTO.setFilms(filmIds);

        /////

        Set<Long> starshipIds = new HashSet<>();
        for (Starship starship : person.getStarships()){
            starshipIds.add(starship.getId());
        }
        personFullDTO.setStarships(starshipIds);

        /////

        Set<Long> vehicleIds = new HashSet<>();
        for (Vehicle vehicle : person.getVehicles()){
            vehicleIds.add(vehicle.getId());
        }
        personFullDTO.setVehicles(vehicleIds);

        return ResponseEntity.ok(personFullDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonFullDTO> updatePersonDTO(@PathVariable Long id, @RequestBody PersonFullDTO personDTO) {
        try{
            Person person = personMapper.toFullEntity(personDTO);
            person = personService.updatePerson(id, person);
            PersonFullDTO updatedPersonDTO2 = personMapper.toFullDTO(person);
            return ResponseEntity.ok(updatedPersonDTO2);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }


}
