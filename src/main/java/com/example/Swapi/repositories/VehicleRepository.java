package com.example.Swapi.repositories;

import com.example.Swapi.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

