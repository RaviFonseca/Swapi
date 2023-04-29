package com.example.Swapi.Dtos;


import com.example.Swapi.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface FilmMapper {
    FilmSimpleDTO toSimpleDTO(Film film);
    Film toSimpleEntity(FilmSimpleDTO filmSimpleDTO);

    @Mapping(target = "characters", source = "characters", qualifiedByName = "mapPersonSetToLongSet")
    @Mapping(target = "planets", source = "planets", qualifiedByName = "mapPlanetSetToLongSet")
    @Mapping(target = "species", source = "species", qualifiedByName = "mapSpeciesSetToLongSet")
    @Mapping(target = "starships", source = "starships", qualifiedByName = "mapStarshipSetToLongSet")
    @Mapping(target = "vehicles", source = "vehicles", qualifiedByName = "mapVehicleSetToLongSet")
    FilmFullDTO toFullDTO(Film film);

    @Named("mapPersonSetToLongSet")
    default Set<Long> mapPersonSetToLongSet(Set<Person> personSet) {
        return personSet.stream()
                .map(Person::getId)
                .collect(Collectors.toSet());
    }
    @Named("mapPlanetSetToLongSet")
    default Set<Long> mapPlanetSetToLongSet(Set<Planet> planetSet) {
        return planetSet.stream()
                .map(Planet::getId)
                .collect(Collectors.toSet());
    }
    @Named("mapSpeciesSetToLongSet")
    default Set<Long> mapSpeciesSetToLongSet(Set<Species> speciesSet) {
        return speciesSet.stream()
                .map(Species::getId)
                .collect(Collectors.toSet());
    }
    @Named("mapVehicleSetToLongSet")
    default Set<Long> mapVehicleSetToLongSet(Set<Vehicle> vehicleSet) {
        return vehicleSet.stream()
                .map(Vehicle::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapStarshipSetToLongSet")
    default Set<Long> mapStarshipSetToLongSet(Set<Starship> starshipSet) {
        return starshipSet.stream()
                .map(Starship::getId)
                .collect(Collectors.toSet());
    }



    @Mapping(target = "characters", source = "characters", qualifiedByName = "mapLongSetToPersonSet")
    @Mapping(target = "planets", source = "planets", qualifiedByName = "mapLongSetToPlanetSet")
    @Mapping(target = "species", source = "species", qualifiedByName = "mapLongSetToSpeciesSet")
    @Mapping(target = "starships", source = "starships", qualifiedByName = "mapLongSetToStarshipSet")
    @Mapping(target = "vehicles", source = "vehicles", qualifiedByName = "mapLongSetToVehicleSet")
    Film toFullEntity(FilmFullDTO filmFullDTO);

    @Named("mapLongSetToPersonSet")
    default Set<Person> mapLongSetToPersonSet(Set<Long> personSet) {
        Set<Person> people = new HashSet<>();
        if ( personSet != null){
            for(Long personId : personSet){
                Person person = new Person();
                person.setId(personId);
                people.add(person);
            }
        }else{
            people = Collections.emptySet();
        }
        return people;
    }

    @Named("mapLongSetToPlanetSet")
    default Set<Planet> mapLongSetToPlanetSet(Set<Long> planetSet) {
        Set<Planet> planets = new HashSet<>();
        if(planetSet != null){
            for (Long planetId : planetSet) {
                Planet planet = new Planet();
                planet.setId(planetId);
                planets.add(planet);
            }
        }else{
            planets = Collections.emptySet();
        }

        return planets;
    }

    @Named("mapLongSetToSpeciesSet")
    default Set<Species> mapLongSetToSpeciesSet(Set<Long> speciesSet) {
        Set<Species> species = new HashSet<>();
        if(speciesSet != null){
            for (Long speciesId : speciesSet){
                Species species1 = new Species();
                species1.setId(speciesId);
                species.add(species1);
            }
        }else {
            species = Collections.emptySet();
        }

        return species;
    }
    @Named("mapLongSetToStarshipSet")
    default Set<Starship> mapLongSetToStarshipSet(Set<Long> starshipSet) {
        Set<Starship> starships = new HashSet<>();
        if(starshipSet != null){
            for (Long starshipId : starshipSet){
                Starship starship = new Starship();
                starship.setId(starshipId);
                starships.add(starship);
            }
        }else {
            starships = Collections.emptySet();
        }

        return starships;
    }

    @Named("mapLongSetToVehicleSet")
    default Set<Vehicle> mapLongSetToVehicleSet(Set<Long> vehicleSet) {

        Set<Vehicle> vehicles = new HashSet<>();
        if(vehicleSet != null){
            for(Long vehicleId : vehicleSet){
                Vehicle vehicle = new Vehicle();
                vehicle.setId(vehicleId);
                vehicles.add(vehicle);
            }
        }else {
            vehicles = Collections.emptySet();
        }

        return vehicles;
    }
}
