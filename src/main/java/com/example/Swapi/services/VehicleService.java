package com.example.Swapi.services;


import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Vehicle;
import com.example.Swapi.repositories.FilmRepository;
import com.example.Swapi.repositories.PersonRepository;
import com.example.Swapi.repositories.VehicleRepository;
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
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private PersonRepository personRepository;



    public Vehicle createVehicle(Vehicle vehicle){

        Set<Film> filmSet = new HashSet<>();
        for(Film film : vehicle.getFilms()){
            Film film1 = filmRepository.findById(film.getId()) //filmService.getFilmById(film.getId());
                    .orElseThrow(() -> new EntityNotFoundException("Film not found with id: "+film.getId()));
            film1.getVehicles().add(vehicle);
            filmSet.add(film1);
        }
        vehicle.setFilms(filmSet);

        /////

        Set<Person> pilotSet = new HashSet<>();
        for (Person pilot : vehicle.getPilots()){
            Person  pilot1 =  personRepository.findById(pilot.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Pilot not found with id: " + pilot.getId()));
            pilot1.getVehicles().add(vehicle);
            pilotSet.add(pilot1);
        }
        vehicle.setPilots(pilotSet);

        vehicle.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleId(Long id){
        return vehicleRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Vehicle not found with the id: "+id));

    }



    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if ( vehicle.isPresent()){
            Vehicle existingVehicle = vehicle.get();
            existingVehicle.setName(updatedVehicle.getName());
            existingVehicle.setModel(updatedVehicle.getModel());
            existingVehicle.setManufacturer(updatedVehicle.getManufacturer());
            existingVehicle.setCostInCredits(updatedVehicle.getCostInCredits());
            existingVehicle.setLength(updatedVehicle.getLength());
            existingVehicle.setMaxAtmospheringSpeed(updatedVehicle.getMaxAtmospheringSpeed());
            existingVehicle.setCrew(updatedVehicle.getCrew());
            existingVehicle.setCrew(updatedVehicle.getCrew());
            existingVehicle.setPassengers(updatedVehicle.getPassengers());
            existingVehicle.setCargoCapacity(updatedVehicle.getCargoCapacity());
            existingVehicle.setConsumables(updatedVehicle.getConsumables());
            existingVehicle.setVehicleClass(updatedVehicle.getVehicleClass());
            existingVehicle.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            existingVehicle.setFilms(updatedVehicle.getFilms());
            existingVehicle.setPilots(updatedVehicle.getPilots());
            return vehicleRepository.save(existingVehicle);
        }else{
            throw new RuntimeException("Vehicle not found with id: "+id);
        }
    }

    public void deleteVehicle(Long id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            vehicleRepository.delete(vehicle.get());
        } else {
            throw new RuntimeException("Vehicle not found with id " + id);
        }    }
}
