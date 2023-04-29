package com.example.Swapi.controller;


import com.example.Swapi.Dtos.StarshipFullDTO;
import com.example.Swapi.Dtos.StarshipMapper;
import com.example.Swapi.Dtos.StarshipSimpleDTO;
import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Starship;
import com.example.Swapi.services.StarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/starships")
public class StarshipController {

    @Autowired
    private StarshipService starshipService;
    @Autowired
    private StarshipMapper starshipMapper;


    @PostMapping
    public ResponseEntity<StarshipFullDTO> createStarship(@RequestBody StarshipFullDTO starshipFullDTO){
        Starship starship = starshipMapper.toEntityFull(starshipFullDTO);
        Starship createdStarship = starshipService.createStarship(starship);
        StarshipFullDTO createdStarshipFullDTO = starshipMapper.toFullDTO(createdStarship);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStarshipFullDTO);
    }

    @GetMapping
    public ResponseEntity<List<StarshipSimpleDTO>> getAllStarships(){
        List<Starship> starships = starshipService.getAllStarships();
        if(starships.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <StarshipSimpleDTO> starshipSimpleDTOS = starships.stream().map(starshipMapper::toSimpleDTO).collect(Collectors.toList());
        return ResponseEntity.ok(starshipSimpleDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StarshipFullDTO> getStarshipById(@PathVariable Long id){
        Starship starship = starshipService.getStarshipId(id);
        if(starship == null){
            return ResponseEntity.notFound().build();
        }
        StarshipFullDTO starshipFullDTO = starshipMapper.toFullDTO(starship);

        Set<Long> filmIds = new HashSet<>();
        for (Film film : starship.getFilms()){
            filmIds.add(film.getId());
        }
        starshipFullDTO.setFilms(filmIds);

        /////

        Set<Long> pilotIds = new HashSet<>();
        for (Person pilot : starship.getPilots()){
            pilotIds.add(pilot.getId());
        }
        starshipFullDTO.setPilots(pilotIds);

        return ResponseEntity.ok(starshipFullDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StarshipFullDTO> updateStarship(@PathVariable Long id, @RequestBody StarshipFullDTO starshipFullDTO){
        try{
            Starship starship = starshipMapper.toEntityFull(starshipFullDTO);
            Starship updatedStarship  = starshipService.updateStarship(id,starship);
            StarshipFullDTO updatedStarshipFullDTO = starshipMapper.toFullDTO(updatedStarship);
            return ResponseEntity.ok(updatedStarshipFullDTO);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStarship(@PathVariable Long id){
        starshipService.deleteStarship(id);
        return ResponseEntity.noContent().build();
    }
}
