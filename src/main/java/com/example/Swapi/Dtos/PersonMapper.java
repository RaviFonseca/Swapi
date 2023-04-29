package com.example.Swapi.Dtos;


import com.example.Swapi.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonSimpleDTO toSimpleDTO(Person person);

    @Mapping(target = "species", source = "species", qualifiedByName = "mapSpeciesSetToLongSet")
    @Mapping(target = "films", source = "films", qualifiedByName = "mapFilmSetToLongSet")
    @Mapping(target = "vehicles", source = "vehicles", qualifiedByName = "mapVehicleSetToLongSet")
    @Mapping(target = "starships", source = "starships", qualifiedByName = "mapStarshipSetToLongSet")
    @Mapping(source = "homeworld", target = "homeworldId", qualifiedByName = "mapPlanetToLong")
    PersonFullDTO toFullDTO(Person person);

    @Named("mapPlanetToLong")
    default Long mapPlanetToLong(Planet planet) {
        Long planetId = planet.getId();
        return planetId != null ? planet.getId() : null;
    }

    @Named("mapSpeciesSetToLongSet")
    default Set<Long> mapSpeciesSetToLongSet(Set<Species> speciesSet) {
        return speciesSet.stream()
                .map(Species::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapFilmSetToLongSet")
    default Set<Long> mapFilmSetToLongSet(Set<Film> filmSet) {
        return filmSet.stream()
                .map(Film::getId)
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


    Person toEntity(PersonSimpleDTO personSimpleDTO);

    @Mapping(target = "species", source = "species", qualifiedByName = "mapLongSetToSpeciesSet")
    @Mapping(target = "films", source = "films", qualifiedByName = "mapLongSetToFilmSet")
    @Mapping(target = "starships", source = "starships", qualifiedByName = "mapLongSetToStarshipSet")
    @Mapping(target = "vehicles", source = "vehicles", qualifiedByName = "mapLongSetToVehicleSet")
    @Mapping(source = "homeworldId", target = "homeworld", qualifiedByName = "mapLongToPlanet")
    Person toFullEntity(PersonFullDTO personDTO);

    @Named("mapLongToPlanet")
    default Planet mapLongToPlanet(Long planetId) {
        Planet planet = new Planet();
        if (planetId != null){
            planet.setId(planetId);
        }
        return planet;
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

    @Named("mapLongSetToFilmSet")
    default Set<Film> mapLongSetToFilmSet(Set<Long> filmeSet) {
        Set<Film> films = new HashSet<>();
        if(filmeSet != null){
            for(Long filmId : filmeSet){
                Film film = new Film();
                film.setId(filmId);
                films.add(film);
            }
        }else{
            films = Collections.emptySet();
        }

        return films;
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


    Planet toPlanet(PlanetSimpleDTO planetSimpleDTO);
    PlanetSimpleDTO toPlanetDTO(Planet planet);

    Species toSpecies(SpeciesSimpleDTO speciesSimpleDTO);
    SpeciesSimpleDTO toSpeciesDTO(Species species);

}
