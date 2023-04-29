package com.example.Swapi.services;

import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Planet;
import com.example.Swapi.entities.Species;
import com.example.Swapi.repositories.FilmRepository;
import com.example.Swapi.repositories.PersonRepository;
import com.example.Swapi.repositories.PlanetRepository;
import com.example.Swapi.repositories.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PlanetRepository planetRepository;




    public Species createSpecies(Species species){
        System.out.println("pin createSpecies do service");

        Set<Film> filmSet = new HashSet<>();
        for (Film film : species.getFilms()){
            Film  film1 =  filmRepository.findById(film.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Film not found with id: " + film.getId()));
            film1.getSpecies().add(species);
            filmSet.add(film1);
        }
        species.setFilms(filmSet);
//
//        /////
//
        Set<Person> personSet = new HashSet<>();
        for (Person person : species.getPeople()){
            Person  person1 =  personRepository.findById(person.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + person.getId()));
            person1.getSpecies().add(species);
            personSet.add(person1);
        }
        species.setPeople(personSet);
//
//        /////
//
        Set<Planet> planetSet = new HashSet<>();
        for (Planet planet : species.getPlanets()){
            Planet  planet1 =  planetRepository.findById(planet.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Planet not found with id: " + planet.getId()));
            planet1.getSpecies().add(species);
            planetSet.add(planet1);
//            species.setPlanets(planetSet.stream().map(id -> new Planet(id)).collect(Collectors.toSet()));
        }
        species.setPlanets(planetSet);

        species.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return speciesRepository.save(species);
    }

    public List<Species> getAllSpecies(){
        return speciesRepository.findAll();
    }

    public Species getSpeciesId(Long id){
        return speciesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Species not found with id: " + id)) ;
    }

    public Species updateSpecies(Long id, Species updatedSpecies){
        Optional<Species> species = speciesRepository.findById(id);
        if ( species.isPresent()){
            Species existingSpecies = species.get();
            existingSpecies.setName(updatedSpecies.getName());
            existingSpecies.setDesignation(updatedSpecies.getDesignation());
            existingSpecies.setAverageHeight(updatedSpecies.getAverageHeight());
            existingSpecies.setSkinColors(updatedSpecies.getSkinColors());
            existingSpecies.setHairColors(updatedSpecies.getHairColors());
            existingSpecies.setEyeColors(updatedSpecies.getEyeColors());
            existingSpecies.setAverageLifespan(updatedSpecies.getAverageLifespan());
            existingSpecies.setLanguage(updatedSpecies.getLanguage());
            existingSpecies.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            existingSpecies.setFilms(updatedSpecies.getFilms());
            existingSpecies.setPeople(updatedSpecies.getPeople());
            existingSpecies.setPlanets(updatedSpecies.getPlanets());
            System.out.println(updatedSpecies.getPlanets());


            return speciesRepository.save(existingSpecies);
        }else{
            throw new RuntimeException("Species not found with id: "+id);
        }
    }

    public void deleteSpecies(Long id){
        Optional<Species> species = speciesRepository.findById(id);
        if (species.isPresent()) {
            speciesRepository.delete(species.get());
        } else {
            throw new RuntimeException("Species not found with id " + id);
        }    }
}
