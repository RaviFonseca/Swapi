package com.example.Swapi.entities;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "height")
    private Double height;
    @Column(name = "mass")
    private Double mass;
    @Column(name = "hair_color")
    private String hairColor;
    @Column(name = "skin_color")
    private String skinColor;
    @Column(name = "eye_color")
    private String eyeColor;
    @Column(name = "birth_year")
    private String birthYear;
    @Column(name = "gender")
    private String gender;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "homeworld_id",nullable = true)
    private Planet homeworld;


    @Nullable
    @ManyToMany(mappedBy = "people")
    private Set<Species> species = new HashSet<>();

    @Nullable
    @ManyToMany(mappedBy = "characters")
    private Set<Film> films = new HashSet<>();

    @Column(nullable = true)
    @ManyToMany(mappedBy = "pilots")
    private Set<Starship> starships = new HashSet<>();

    @Nullable
    @ManyToMany(mappedBy = "pilots")
    private Set<Vehicle> vehicles = new HashSet<>();

    public Person() {
    }

    public Person(Long id, String name, Double height, Double mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, Timestamp createdAt, Timestamp updatedAt, Planet homeworld, Set<Species> species, Set<Film> films, Set<Starship> starships, Set<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.homeworld = homeworld;
        this.species = species;
        this.films = films;
        this.starships = starships;
        this.vehicles = vehicles;
    }


    public Person(Long id) {
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Planet getHomeworld() {
        return homeworld;
    }


    public void setHomeworld(Planet homeworld) {
        this.homeworld = homeworld;
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

    public Set<Starship> getStarships() {
        return starships;
    }

    public void setStarships(Set<Starship> starships) {
        this.starships = starships;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
