package com.example.Swapi.Dtos;


import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Planet;
import com.example.Swapi.entities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface SpeciesMapper {


    SpeciesSimpleDTO toSimpleDTO(Species species);

    @Mapping(target = "films", source = "films", qualifiedByName = "mapFilmSetToLongSet")
    @Mapping(target = "people", source = "people", qualifiedByName = "mapPersonSetToLongSet")
    @Mapping(target = "planets", source = "planets", qualifiedByName = "mapPlanetSetToLongSet")
    SpeciesFullDTO toFullDTO(Species species);

    @Named("mapPersonSetToLongSet")
    default Set<Long> mapPersonSetToLongSet(Set<Person> personSet) {
        return personSet.stream()
                .map(Person::getId)
                .collect(Collectors.toSet());
    }
    @Named("mapFilmSetToLongSet")
    default Set<Long> mapFilmSetToLongSet(Set<Film> filmSet) {
        return filmSet.stream()
                .map(Film::getId)
                .collect(Collectors.toSet());
    }
    @Named("mapPlanetSetToLongSet")
    default Set<Long> mapPlanetSetToLongSet(Set<Planet> planetSet) {
        return planetSet.stream()
                .map(Planet::getId)
                .collect(Collectors.toSet());
    }


    Species toEntity(SpeciesSimpleDTO speciesSimpleDTO);

    @Mapping(target = "films", source = "films", qualifiedByName = "mapLongSetToFilmSet")
    @Mapping(target = "people", source = "people", qualifiedByName = "mapLongSetToPersonSet")
    @Mapping(target = "planets", source = "planets", qualifiedByName = "mapLongSetToPlanetSet")
    Species toFullEntity(SpeciesFullDTO speciesFullDTO);//, @Context PlanetRepository planetRepository);

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


}
