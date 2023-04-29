package com.example.Swapi.Dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class PlanetFullDTO{

    private Long id;
    private String name;
    @JsonProperty("rotation_period")
    private Integer rotationPeriod;
    @JsonProperty("orbital_period")
    private Integer orbitalPeriod;
    private Float diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String population;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    private Set<Long> films = new HashSet<>();
    private Set<Long> residents = new HashSet<>();
    private Set<Long> species = new HashSet<>();


    public PlanetFullDTO() {
    }

    public PlanetFullDTO(Long id, String name, Integer rotationPeriod, Integer orbitalPeriod, Float diameter, String climate, String gravity, String terrain,
                         String surfaceWater, String population, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.population = population;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("rotation_period")
    public Integer getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Integer rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    @JsonGetter("orbital_period")
    public Integer getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Integer orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @JsonGetter("surface_water")
    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @JsonGetter("created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @JsonGetter("updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonGetter("films")
    public Set<Long> getFilms() {
        return films;
    }

    public void setFilms(Set<Long> films) {
        this.films = films;
    }

    @JsonGetter("residents")
    public Set<Long> getResidents() {
        return residents;
    }

    public void setResidents(Set<Long> residents) {
        this.residents = residents;
    }

    @JsonGetter("species")
    public Set<Long> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Long> species) {
        this.species = species;
    }
}
