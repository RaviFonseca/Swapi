package com.example.Swapi.controller;


import com.example.Swapi.Dtos.VehicleFullDTO;
import com.example.Swapi.Dtos.VehicleMapper;
import com.example.Swapi.Dtos.VehicleSimpleDTO;
import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Vehicle;
import com.example.Swapi.services.VehicleService;
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
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleMapper vehicleMapper;

    @PostMapping
    public ResponseEntity<VehicleFullDTO> createVehicle(@RequestBody VehicleFullDTO vehicleFullDTO){
        Vehicle vehicle = vehicleMapper.toFullEntity(vehicleFullDTO);
        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        VehicleFullDTO createdVehicleFullDTO = vehicleMapper.toFullDTO(createdVehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicleFullDTO);
    }

    @GetMapping
    public ResponseEntity<List<VehicleSimpleDTO>> getAllVehicles(){
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        if(vehicles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List <VehicleSimpleDTO> vehicleSimpleDTOS = vehicles.stream().map(vehicleMapper::toSimpleDTO).collect(Collectors.toList());
        return ResponseEntity.ok(vehicleSimpleDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleFullDTO> getVehicleById(@PathVariable Long id){
        Vehicle vehicle = vehicleService.getVehicleId(id);
        if(vehicle == null){
            return ResponseEntity.notFound().build();
        }
        VehicleFullDTO vehicleFullDTO = vehicleMapper.toFullDTO(vehicle);

        Set<Long> filmIds = new HashSet<>();
        for (Film film : vehicle.getFilms()){
            filmIds.add(film.getId());
        }
        vehicleFullDTO.setFilms(filmIds);

        /////

        Set<Long> pilotIds = new HashSet<>();
        for (Person pilot : vehicle.getPilots()){
            pilotIds.add(pilot.getId());
        }
        vehicleFullDTO.setPilots(pilotIds);

        return ResponseEntity.ok(vehicleFullDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleFullDTO> updateVehicle(@PathVariable Long id, @RequestBody VehicleFullDTO vehicleFullDTO){
        try{
            Vehicle vehicle = vehicleMapper.toFullEntity(vehicleFullDTO);
            Vehicle updatedVehicle  = vehicleService.updateVehicle(id,vehicle);
            VehicleFullDTO updatedVehicleFullDTO = vehicleMapper.toFullDTO(updatedVehicle);
            return ResponseEntity.ok(updatedVehicleFullDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
