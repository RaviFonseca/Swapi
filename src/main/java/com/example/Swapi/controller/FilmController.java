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
