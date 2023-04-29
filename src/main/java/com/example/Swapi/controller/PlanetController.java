package com.example.Swapi.controller;


import com.example.Swapi.Dtos.PlanetFullDTO;
import com.example.Swapi.Dtos.PlanetMapper;
import com.example.Swapi.Dtos.PlanetSimpleDTO;
import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Planet;
import com.example.Swapi.entities.Species;
import com.example.Swapi.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {
    @Autowired
    private PlanetService planetService;
    @Autowired
    private PlanetMapper planetMapper;



    @PostMapping
    public ResponseEntity<PlanetFullDTO> createPlanet(@RequestBody PlanetFullDTO planetFullDTO){
        System.out.println("pin para o createPlanet do controller");
        Planet planet = planetMapper.toFullEntity(planetFullDTO);

        /////

//        Set<Film> film = new HashSet<>();
//        if(planetFullDTO.getFilms()  != null){
//            for(Long filmId: planetFullDTO.getFilms()){
//                Film film1 = filmService.getFilmById(filmId);
//                if(film1 == null){
//                    return ResponseEntity.badRequest().build();
//                }
//                film.add(film1);
//            }
//        }
//        planet.setFilms(film);
//
//        /////
//
//        Set<Person> resident = new HashSet<>();
//        if(planetFullDTO.getResidents()  != null){
//            for(Long residentId: planetFullDTO.getResidents()){
//                Person resident1 = personService.getPersonById(residentId);
//                if(resident1 == null){
//                    return ResponseEntity.badRequest().build();
//                }
//                resident.add(resident1);
//            }
//        }
//        planet.setResidents(resident);
//
//        /////
//
//        Set<Species> species = new HashSet<>();
//        if(planetFullDTO.getSpecies()  != null){
//            for(Long speciesId: planetFullDTO.getSpecies()){
//                Species species1 = speciesService.getSpeciesId(speciesId);
//                if(species1 == null){
//                    return ResponseEntity.badRequest().build();
//                }
//                species.add(species1);
//            }
//        }
//        planet.setSpecies(species);

        Planet createdPlanet = planetService.createPlanet(planet);
        PlanetFullDTO createdPlanetFullDTO = planetMapper.toFullDTO(createdPlanet);
//        createdPlanetFullDTO.setFilms(planet.getFilms().stream().map(Film::getId).collect(Collectors.toSet()));
//        createdPlanetFullDTO.setResidents(planet.getResidents().stream().map(Person::getId).collect(Collectors.toSet()));
//        createdPlanetFullDTO.setSpecies(planet.getSpecies().stream().map(Species::getId).collect(Collectors.toSet()));

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlanetFullDTO);
    }

    @GetMapping
    public ResponseEntity<List<PlanetSimpleDTO>> getAllPlanets(){
        List<Planet> planets = planetService.getAllPlanets();
        if(planets.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <PlanetSimpleDTO> planetSimpleDTOS = planets.stream().map(planetMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(planetSimpleDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlanetFullDTO> getPlanetById(@PathVariable Long id){
        Planet planet = planetService.getPlanetId(id);
        if(planet == null){
            return ResponseEntity.notFound().build();
        }
        PlanetFullDTO planetFullDTO = planetMapper.toFullDTO(planet);

        /////

        Set<Long> filmIds = new HashSet<>();
        for (Film film : planet.getFilms()){
            filmIds.add(film.getId());
        }
        planetFullDTO.setFilms(filmIds);

        /////

        Set<Long> residentIds = new HashSet<>();
        for (Person resident : planet.getResidents()){
            residentIds.add(resident.getId());
        }
        planetFullDTO.setResidents(residentIds);

        /////

        Set<Long> speciesIds = new HashSet<>();
        for (Species species : planet.getSpecies()){
            speciesIds.add(species.getId());
        }
        planetFullDTO.setSpecies(speciesIds);

        return ResponseEntity.ok(planetFullDTO);

    }



    @PutMapping("/{id}")
    public ResponseEntity<PlanetFullDTO> updatePlanet(@PathVariable Long id, @RequestBody PlanetFullDTO planetFullDTO){
        System.out.println("pin para o updatePlanet do controller");

        try{
            Planet planet = planetMapper.toFullEntity(planetFullDTO);
            planet = planetService.updatePlanet(id,planet);
            PlanetFullDTO updatedPlanetFullDTO = planetMapper.toFullDTO(planet);
            return ResponseEntity.ok(updatedPlanetFullDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable Long id){
        planetService.deletePlanet(id);
        return ResponseEntity.noContent().build();
    }
}
