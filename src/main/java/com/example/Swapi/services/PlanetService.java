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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SpeciesRepository speciesRepository;


    public Planet createPlanet(Planet planet){

        Set<Film> filmSet = new HashSet<>();
        for(Film film : planet.getFilms()){
            Film film1 = filmRepository.findById(film.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Film not found with id: "+film.getId()));
            film1.getPlanets().add(planet);
            filmSet.add(film1);
        }
        planet.setFilms(filmSet);
//
//        /////
//
        Set<Person> residentSet = new HashSet<>();
        for (Person resident : planet.getResidents()){
            Person  resident1 =  personRepository.findById(resident.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Resident not found with id: " + resident.getId()));
            residentSet.add(resident1);
        }
        planet.setResidents(residentSet);

//        /////
//
        Set<Species> speciesSet = new HashSet<>();
        for (Species species : planet.getSpecies()){
            Species  species1 =  speciesRepository.findById(species.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Species not found with id: " + species.getId()));
            species1.getPlanets().add(planet);
            speciesSet.add(species1);
        }
        planet.setSpecies(speciesSet);

        planet.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return planetRepository.save(planet);
    }
    public List<Planet> getAllPlanets(){
        return planetRepository.findAll();
    }

    public Planet getPlanetId(Long id){
        return planetRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Planet not found with id: " + id)) ;
    }



    public  Planet updatePlanet(Long id, Planet updatedPlanet){
        Optional<Planet> planet = planetRepository.findById(id);
        if ( planet.isPresent()){
            Planet existingPlanet = planet.get();
            existingPlanet.setName(updatedPlanet.getName());
            existingPlanet.setRotationPeriod(updatedPlanet.getRotationPeriod());
            existingPlanet.setOrbitalPeriod(updatedPlanet.getOrbitalPeriod());
            existingPlanet.setDiameter(updatedPlanet.getDiameter());
            existingPlanet.setClimate(updatedPlanet.getClimate());
            existingPlanet.setGravity(updatedPlanet.getGravity());
            existingPlanet.setTerrain(updatedPlanet.getTerrain());
            existingPlanet.setSurfaceWater(updatedPlanet.getSurfaceWater());
            existingPlanet.setPopulation(updatedPlanet.getPopulation());
            existingPlanet.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            existingPlanet.setFilms(updatedPlanet.getFilms());
            existingPlanet.setResidents(updatedPlanet.getResidents());
            existingPlanet.setSpecies(updatedPlanet.getSpecies());

            return planetRepository.save(existingPlanet);
        }else{
            throw new RuntimeException("Planet not found with id: "+id);
        }
    }

    public void deletePlanet(Long id){
        Optional<Planet> planet = planetRepository.findById(id);
        if (planet.isPresent()) {
            planetRepository.delete(planet.get());
        } else {
            throw new RuntimeException("Planet not found with id " + id);
        }
    }
}
