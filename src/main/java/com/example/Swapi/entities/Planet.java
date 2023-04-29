package com.example.Swapi.entities;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.io.IOException;
import java.io.Serializable;
import java.net.http.HttpRequest;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planet")
public class Planet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "rotation_period")
    private Integer rotationPeriod;
    @Column(name = "orbital_period")
    private Integer orbitalPeriod;
    @Column(name = "diameter")
    private Float diameter;
    @Column(name = "climate")
    private String climate;
    @Column(name = "gravity")
    private String gravity;
    @Column(name = "terrain")
    private String terrain;
    @Column(name = "surface_water")
    private String surfaceWater;
    @Column(name = "population")
    private String population;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;


//    @ManyToMany
//    @JoinTable(
//            name = "species_planet",
//            joinColumns = @JoinColumn(name = "planet_id"),
//            inverseJoinColumns = @JoinColumn(name = "species_id")
//    )
//    private Set<Species> species = new HashSet<>();

    @ManyToMany(mappedBy = "planets")
    private Set<Species> species= new HashSet<>();

    @ManyToMany(mappedBy = "planets")
    private Set<Film> films= new HashSet<>();


    @OneToMany(mappedBy = "homeworld")
    private Set<Person> residents =  new HashSet<>();



    public Planet() {
    }

    public Planet(Long id, String name, Integer rotationPeriod, Integer orbitalPeriod, Float diameter, String climate, String gravity, String terrain,
                  String surfaceWater, String population) {
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
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Planet(Long id) {
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

    public Integer getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Integer rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Species> species) {
        this.species = species;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Set<Person> getResidents() {
        return residents;
    }

    public void setResidents(Set<Person> residents) {
        this.residents = residents;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
