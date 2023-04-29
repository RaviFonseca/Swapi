package com.example.Swapi.controller;


import com.example.Swapi.Dtos.FilmFullDTO;
import com.example.Swapi.Dtos.FilmMapper;
import com.example.Swapi.Dtos.FilmSimpleDTO;
import com.example.Swapi.entities.*;
import com.example.Swapi.services.FilmService;
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
@RequestMapping("/api/films") //caminho base para todas as rotas dentro deste controlador
public class FilmController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmMapper filmMapper;

    @PostMapping
    public ResponseEntity<FilmFullDTO> createFilm(@RequestBody FilmFullDTO filmFullDTO){
        Film film = filmMapper.toFullEntity(filmFullDTO);
        Film createdFilm = filmService.createFilm(film);
        FilmFullDTO createdFilmFullDTO = filmMapper.toFullDTO(createdFilm);
///        Set<Person> person = new HashSet<>();
////        if(filmFullDTO.getCharacters()  != null){
////            for(Long personId: filmFullDTO.getCharacters()){
////                Person person1 = personService.getPersonById(personId);
////                if(person1 == null){
////                    return ResponseEntity.badRequest().build();
////                }
////                person.add(person1);
////            }
////        }
////        film.setCharacters(person);
////
////        /////
////
////        Set<Planet> planet = new HashSet<>();
////        if(filmFullDTO.getPlanets()  != null){
////            for(Long planetId: filmFullDTO.getPlanets()){
////                Planet planet1 = planetService.getPlanetId(planetId);
////                if(planet1 == null){
////                    return ResponseEntity.badRequest().build();
////                }
////                planet.add(planet1);
////            }
////        }
////        film.setPlanets(planet);
////
////        /////
////
////        Set<Species> species = new HashSet<>();
////        if(filmFullDTO.getSpecies()  != null){
////            for(Long speciesId: filmFullDTO.getSpecies()){
////                Species species1 = speciesService.getSpeciesId(speciesId);
////                if(species1 == null){
////                    return ResponseEntity.badRequest().build();
////                }
////                species.add(species1);
////            }
////        }
////        film.setSpecies(species);
////
////        /////
////
////        Set<Starship> starship = new HashSet<>();
////        if(filmFullDTO.getStarships()  != null){
////            for(Long starshipId: filmFullDTO.getStarships()){
////                Starship starship1 = starshipService.getStarshipId(starshipId);
////                if(starship1 == null){
////                    return ResponseEntity.badRequest().build();
////                }
////                starship.add(starship1);
////            }
////        }
////        film.setStarships(starship);
////
////        /////
////
////        Set<Vehicle> vehicle = new HashSet<>();
////        if(filmFullDTO.getVehicles()  != null){
////            for(Long vehicleId: filmFullDTO.getVehicles()){
////                Vehicle vehicle1 = vehicleService.getVehicleId(vehicleId);
////                if(vehicle1 == null){
////                    return ResponseEntity.badRequest().build();
////                }
////                vehicle.add(vehicle1);
////            }
////        }
////        film.setVehicles(vehicle);
//
//        createdFilmFullDTO.setCharacters(film.getCharacters().stream().map(Person::getId).collect(Collectors.toSet()));
//        createdFilmFullDTO.setPlanets(film.getPlanets().stream().map(Planet::getId).collect(Collectors.toSet()));
//        createdFilmFullDTO.setSpecies(film.getSpecies().stream().map(Species::getId).collect(Collectors.toSet()));
//        createdFilmFullDTO.setStarships(film.getStarships().stream().map(Starship::getId).collect(Collectors.toSet()));
//        createdFilmFullDTO.setVehicles(film.getVehicles().stream().map(Vehicle::getId).collect(Collectors.toSet()));

        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilmFullDTO);
    }

    @GetMapping
    public ResponseEntity<List<FilmSimpleDTO>> getAllFilms(){
        List<Film> films = filmService.getAllFilms();
        if(films.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <FilmSimpleDTO> filmSimpleDTOS = films.stream().map(filmMapper::toSimpleDTO).collect(Collectors.toList());
        return ResponseEntity.ok(filmSimpleDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmFullDTO> getFilmById(@PathVariable Long id){
        Film film = filmService.getFilmById(id);
        if(film == null ){
            return ResponseEntity.notFound().build();
        }
        FilmFullDTO filmFullDTO = filmMapper.toFullDTO(film);

        Set<Long> peopleIds = new HashSet<>();
        for(Person person : film.getCharacters()){
            peopleIds.add(person.getId());
        }
        filmFullDTO.setCharacters(peopleIds);

        /////

        Set<Long> planetIds = new HashSet<>();
        for (Planet planet : film.getPlanets()){
            planetIds.add(planet.getId());
        }
        filmFullDTO.setPlanets(planetIds);

        /////

        Set<Long> speciesIds = new HashSet<>();
        for (Species species : film.getSpecies()){
            speciesIds.add(species.getId());
        }
        filmFullDTO.setSpecies(speciesIds);

        /////

        Set<Long> starshipIds = new HashSet<>();
        for (Starship starship : film.getStarships()){
            starshipIds.add(starship.getId());
        }
        filmFullDTO.setStarships(starshipIds);

        /////

        Set<Long> vehicleIds = new HashSet<>();
        for (Vehicle vehicle : film.getVehicles()){
            vehicleIds.add(vehicle.getId());
        }
        filmFullDTO.setVehicles(vehicleIds);

        return ResponseEntity.ok(filmFullDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<FilmFullDTO> updateFilm(@PathVariable Long id, @RequestBody FilmFullDTO filmFullDTO){
        try{
            Film film = filmMapper.toFullEntity(filmFullDTO);
            Film updatedFilm  = filmService.updateFilm(id,film);
            FilmFullDTO updatedFilmFullDTO = filmMapper.toFullDTO(updatedFilm);
            return ResponseEntity.ok(updatedFilmFullDTO);
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id){
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
