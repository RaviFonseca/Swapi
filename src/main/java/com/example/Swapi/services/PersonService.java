package com.example.Swapi.services;

import com.example.Swapi.entities.*;
import com.example.Swapi.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private StarshipRepository starshipRepository;


    public Person createPerson(Person person) {

        Planet planet =  planetRepository.findById(person.getHomeworld().getId()) // busca do planet através do id
                .orElseThrow(() -> new EntityNotFoundException("Planet not found with id: "+person.getHomeworld().getId()));
        person.setHomeworld(planet); // passagem desse planet/homeworld ao person


        Set<Species> speciesSet = new HashSet<>();
        for (Species species : person.getSpecies()){
            Species  species1 =  speciesRepository.findById(species.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Species not found with id: " + species.getId()));
            species1.getPeople().add(person);
            speciesSet.add(species1);
        }
        person.setSpecies(speciesSet);

        /////

        Set<Film> filmSet = new HashSet<>();
        for(Film film : person.getFilms()){
            Film film1 = filmRepository.findById(film.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Film not found with id: "+film.getId()));
            film1.getCharacters().add(person);
            filmSet.add(film1);
        }
        person.setFilms(filmSet);

        /////

        Set<Vehicle> vehicleSet = new HashSet<>();
        for(Vehicle vehicle : person.getVehicles()){
            Vehicle vehicle1 =    vehicleRepository.findById(vehicle.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id"+ vehicle.getId()));
            vehicle1.getPilots().add(person);
            vehicleSet.add(vehicle1);
        }
        person.setVehicles(vehicleSet);

        /////

        Set<Starship> starshipSet = new HashSet<>();
        for(Starship starship : person.getStarships()){
            Starship starship1 = starshipRepository.findById(starship.getId())
                    .orElseThrow(()  -> new EntityNotFoundException("Starship not found with id"+ starship.getId()));
            starship1.getPilots().add(person);
            starshipSet.add(starship1);
        }
        person.setStarships(starshipSet);

        person.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return personRepository.save(person);
    }

    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));
    }


    public Person updatePerson(Long id, Person updatedPerson){
        Optional<Person> person = personRepository.findById(id);


        if ( person.isPresent()){
            Person existingPerson = person.get();
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setHeight(updatedPerson.getHeight());
            existingPerson.setMass(updatedPerson.getMass());
            existingPerson.setHairColor(updatedPerson.getHairColor());
            existingPerson.setSkinColor(updatedPerson.getSkinColor());
            existingPerson.setEyeColor(updatedPerson.getEyeColor());
            existingPerson.setBirthYear(updatedPerson.getBirthYear());
            existingPerson.setGender(updatedPerson.getGender());
            existingPerson.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            existingPerson.setHomeworld(updatedPerson.getHomeworld());
            existingPerson.setSpecies(updatedPerson.getSpecies());
            existingPerson.setFilms(updatedPerson.getFilms());
            existingPerson.setVehicles(updatedPerson.getVehicles());
            existingPerson.setStarships(updatedPerson.getStarships());



            return personRepository.save(existingPerson);
        }else{
            throw new RuntimeException("Person not found with id: "+id);
        }

    }


    public void deletePerson(Long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.delete(person.get());
        } else {
            throw new RuntimeException("Person not found with id " + id);
        }
    }




}
