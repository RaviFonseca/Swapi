package com.example.Swapi.services;

import com.example.Swapi.entities.*;
import com.example.Swapi.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private StarshipRepository starshipRepository;
    @Autowired
    private VehicleRepository  vehicleRepository;



    public Film createFilm (Film film){

        Set<Person> personSet = new HashSet<>();
        for (Person person : film.getCharacters()){
            Person  person1 =  personRepository.findById(person.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + person.getId()));
            person1.getFilms().add(film);
            personSet.add(person1);
        }
        film.setCharacters(personSet);

        /////

        Set<Planet> planetSet = new HashSet<>();
        for (Planet planet : film.getPlanets()){
            Planet  planet1 =  planetRepository.findById(planet.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Planet not found with id: " + planet.getId()));
            planet1.getFilms().add(film);
            planetSet.add(planet1);
        }
        film.setPlanets(planetSet);

        /////

        Set<Species> speciesSet = new HashSet<>();
        for (Species species : film.getSpecies()){
            Species  species1 =  speciesRepository.findById(species.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Species not found with id: " + species.getId()));
            species1.getFilms().add(film);
            speciesSet.add(species1);
        }
        film.setSpecies(speciesSet);

        /////

        Set<Vehicle> vehicleSet = new HashSet<>();
        for(Vehicle vehicle : film.getVehicles()){
            Vehicle vehicle1 =    vehicleRepository.findById(vehicle.getId())   //vehicleService.getVehicleId(vehicle.getId());
                    .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id"+ vehicle.getId()));
            vehicle1.getFilms().add(film);
            vehicleSet.add(vehicle1);
        }
        film.setVehicles(vehicleSet);

        /////

        Set<Starship> starshipSet = new HashSet<>();
        for(Starship starship : film.getStarships()){
            Starship starship1 = starshipRepository.findById(starship.getId())           //starshipService.getStarshipId(starship.getId());
                    .orElseThrow(()  -> new EntityNotFoundException("Starship not found with id"+ starship.getId()));
            starship1.getFilms().add(film);
            starshipSet.add(starship1);
        }
        film.setStarships(starshipSet);


        film.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return filmRepository.save(film);
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Film not found with id: "+id));
    }



    public Film updateFilm(Long id, Film updatedFilm){
        Optional<Film> film = filmRepository.findById(id);
        if(film.isPresent()){
            Film existingFilm = film.get();
            existingFilm.setTitle(updatedFilm.getTitle());
            existingFilm.setDirector(updatedFilm.getDirector());
            existingFilm.setProducer(updatedFilm.getProducer());
            existingFilm.setReleaseDate(updatedFilm.getReleaseDate());
            existingFilm.setCharacters(updatedFilm.getCharacters());
            existingFilm.setPlanets(updatedFilm.getPlanets());
            existingFilm.setSpecies(updatedFilm.getSpecies());
            existingFilm.setStarships(updatedFilm.getStarships());
            existingFilm.setVehicles(updatedFilm.getVehicles());
            existingFilm.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return filmRepository.save(existingFilm);
        }else {
            throw new RuntimeException("Film not found with id " +id);
        }
    }

    public void deleteFilm(Long id){
        Optional<Film> film = filmRepository.findById(id);
        if(film.isPresent()){
            filmRepository.delete(film.get());
        }else {
            throw new RuntimeException("Film not found with id " +id);
        }
    }
}
