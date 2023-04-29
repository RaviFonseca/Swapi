package com.example.Swapi.Dtos;

import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Planet;
import com.example.Swapi.entities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
@Component
@Service
public interface PlanetMapper {
    PlanetSimpleDTO toDTO(Planet planet);

    @Mapping(target = "films", source = "films", qualifiedByName = "mapFilmSetToLongSet")
    @Mapping(target = "residents", source = "residents", qualifiedByName = "mapPersonSetToLongSet")
    @Mapping(target = "species", source = "species", qualifiedByName = "mapSpeciesSetToLongSet")
    PlanetFullDTO toFullDTO(Planet planet);

    @Named("mapFilmSetToLongSet")
    default Set<Long> mapFilmSetToLongSet(Set<Film> filmSet) {
        return filmSet.stream()
                .map(Film::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapPersonSetToLongSet")
    default Set<Long> mapPersonSetToLongSet(Set<Person> personSet) {
        return personSet.stream()
                .map(Person::getId)
                .collect(Collectors.toSet());
    }
    @Named("mapSpeciesSetToLongSet")
    default Set<Long> mapSpeciesSetToLongSet(Set<Species> speciesSet) {
        return speciesSet.stream()
                .map(Species::getId)
                .collect(Collectors.toSet());
    }

    Planet toEntity(PlanetSimpleDTO planetSimpleDTO);

    @Mapping(target = "films", source = "films", qualifiedByName = "mapLongSetToFilmSet")
    @Mapping(target = "species", source = "species", qualifiedByName = "mapLongSetToSpeciesSet")
    @Mapping(target = "residents", source = "residents", qualifiedByName = "mapLongSetToPersonSet")
    Planet toFullEntity(PlanetFullDTO planetFullDTO);

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
}
