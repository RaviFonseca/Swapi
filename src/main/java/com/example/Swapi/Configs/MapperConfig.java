package com.example.Swapi.Configs;

import com.example.Swapi.Dtos.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@org.mapstruct.MapperConfig
public class MapperConfig {

    @Bean
    public FilmMapper filmMapper(){
        return Mappers.getMapper(FilmMapper.class);
    }

    @Bean
    public PersonMapper personMapper(){
        return Mappers.getMapper(PersonMapper.class);
    }

    @Bean
    public PlanetMapper planetMapper(){
        return Mappers.getMapper(PlanetMapper.class);
    }

    @Bean
    public SpeciesMapper speciesMapper(){
        return Mappers.getMapper(SpeciesMapper.class);
    }

    @Bean
    public StarshipMapper starshipMapper(){
        return Mappers.getMapper(StarshipMapper.class);
    }

    @Bean
    public VehicleMapper vehicleMapper(){
        return Mappers.getMapper(VehicleMapper.class);
    }
}
