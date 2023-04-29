package com.example.Swapi.controller;


import com.example.Swapi.Dtos.SpeciesFullDTO;
import com.example.Swapi.Dtos.SpeciesMapper;
import com.example.Swapi.Dtos.SpeciesSimpleDTO;
import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Planet;
import com.example.Swapi.entities.Species;
import com.example.Swapi.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private SpeciesMapper speciesMapper;



    @PostMapping
    public ResponseEntity<SpeciesFullDTO> createSpecies(@RequestBody SpeciesFullDTO speciesFullDTO){
        Species species = speciesMapper.toFullEntity(speciesFullDTO);
        Species createdSpecies = speciesService.createSpecies(species);
        SpeciesFullDTO createdSpeciesDTO = speciesMapper.toFullDTO(createdSpecies);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpeciesDTO);
    }

    @GetMapping
    public ResponseEntity<List<SpeciesSimpleDTO>> getAllSpecies(){
        List<Species> species =  speciesService.getAllSpecies();
        if(species.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <SpeciesSimpleDTO> speciesSimpleDTOS = species.stream().map(speciesMapper::toSimpleDTO).collect(Collectors.toList());
        return ResponseEntity.ok(speciesSimpleDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeciesFullDTO> getSpeciesById(@PathVariable Long id){
        Species species = speciesService.getSpeciesId(id);
        if(species == null){
            return ResponseEntity.notFound().build();
        }
        SpeciesFullDTO speciesFullDTO = speciesMapper.toFullDTO(species);


        Set<Long> filmIds = new HashSet<>();
        for (Film film : species.getFilms()){
            filmIds.add(film.getId());
        }
        speciesFullDTO.setFilms(filmIds);

        /////

        Set<Long> personIds = new HashSet<>();
        for (Person person : species.getPeople()){
            personIds.add(person.getId());
        }
        speciesFullDTO.setPeople(personIds);

        /////

        Set<Long> planetIds = new HashSet<>();
        for (Planet planet : species.getPlanets()){
            planetIds.add(planet.getId());
        }
        speciesFullDTO.setPlanets(planetIds);

        return ResponseEntity.ok(speciesFullDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SpeciesFullDTO> updateSpecies(@PathVariable Long id, @RequestBody SpeciesFullDTO speciesFullDTO){
        try{
            Species species = speciesMapper.toFullEntity(speciesFullDTO);
            Species updatedSpecies  = speciesService.updateSpecies(id,species);
            SpeciesFullDTO updatedSpeciesFullDTO = speciesMapper.toFullDTO(updatedSpecies);
            return ResponseEntity.ok(updatedSpeciesFullDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable Long id){
        speciesService.deleteSpecies(id);
        return ResponseEntity.noContent().build();
    }
}
