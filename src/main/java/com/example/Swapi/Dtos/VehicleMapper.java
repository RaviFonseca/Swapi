package com.example.Swapi.Dtos;



import com.example.Swapi.entities.Film;
import com.example.Swapi.entities.Person;
import com.example.Swapi.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface VehicleMapper {
    VehicleSimpleDTO toSimpleDTO(Vehicle vehicle);

    @Mapping(target = "pilots", source = "pilots", qualifiedByName = "mapPersonSetToLongSet")
    @Mapping(target = "films", source = "films", qualifiedByName = "mapFilmSetToLongSet")
    VehicleFullDTO toFullDTO(Vehicle vehicle);

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
    Vehicle toEntity(VehicleSimpleDTO vehicleSimpleDTO);

    @Mapping(target = "films", source = "films", qualifiedByName = "mapLongSetToFilmSet")
    @Mapping(target = "pilots", source = "pilots", qualifiedByName = "mapLongSetToPersonSet")
    Vehicle toFullEntity(VehicleFullDTO vehicleFullDTO);

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
}
