package com.example.Swapi.services;


import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Starship;
import com.example.Swapi.repositories.FilmRepository;
import com.example.Swapi.repositories.PersonRepository;
import com.example.Swapi.repositories.StarshipRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StarshipService {

    @Autowired
    private StarshipRepository starshipRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private PersonRepository personRepository;



    public Starship createStarship(Starship starship){


        Set<Film> filmSet = new HashSet<>();
        for(Film film : starship.getFilms()){
            Film film1 = filmRepository.findById(film.getId()) //filmService.getFilmById(film.getId());
                    .orElseThrow(() -> new EntityNotFoundException("Film not found with id: "+film.getId()));
            film1.getStarships().add(starship);
            filmSet.add(film1);
        }
        starship.setFilms(filmSet);

        /////

        Set<Person> pilotSet = new HashSet<>();
        for (Person pilot : starship.getPilots()){
            Person  pilot1 =  personRepository.findById(pilot.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Pilot not found with id: " + pilot.getId()));
            pilot1.getStarships().add(starship);
            pilotSet.add(pilot1);
        }
        starship.setPilots(pilotSet);

        starship.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return starshipRepository.save(starship);
    }

    public List<Starship> getAllStarships(){
        return starshipRepository.findAll();
    }

    public Starship getStarshipId(Long id){
        return starshipRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Starship not found with id: " + id));

    }


    public Starship updateStarship(Long id, Starship updatedStarship){
        Optional<Starship> starship = starshipRepository.findById(id);
        if ( starship.isPresent()){
            Starship existingStarship = starship.get();
            existingStarship.setName(updatedStarship.getName());
            existingStarship.setModel(updatedStarship.getModel());
            existingStarship.setManufacturer(updatedStarship.getManufacturer());
            existingStarship.setCostInCredits(updatedStarship.getCostInCredits());
            existingStarship.setLength(updatedStarship.getLength());
            existingStarship.setMaxAtmospheringSpeed(updatedStarship.getMaxAtmospheringSpeed());
            existingStarship.setPassengers(updatedStarship.getPassengers());
            existingStarship.setCargoCapacity(updatedStarship.getCargoCapacity());
            existingStarship.setConsumables(updatedStarship.getConsumables());
            existingStarship.setHyperDriveRating(updatedStarship.getHyperDriveRating());
            existingStarship.setMGLT(updatedStarship.getMGLT());
            existingStarship.setStarshipClass(updatedStarship.getStarshipClass());
            existingStarship.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            existingStarship.setFilms(updatedStarship.getFilms());
            existingStarship.setPilots(updatedStarship.getPilots());

            return starshipRepository.save(existingStarship);
        }else{
            throw new RuntimeException("Starship not found with id: "+id);
        }
    }

    public void deleteStarship(Long id){
        Optional<Starship> starship = starshipRepository.findById(id);
        if (starship.isPresent()) {
            starshipRepository.delete(starship.get());
        } else {
            throw new RuntimeException("Starship not found with id " + id);
        }
    }
}
