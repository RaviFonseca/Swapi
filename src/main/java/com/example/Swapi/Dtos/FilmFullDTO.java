package com.example.Swapi.Dtos;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class FilmFullDTO {

    private Long id;
    private String title;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private Date releaseDate;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;
    private Set<Long> characters= new HashSet<>();
    private Set<Long> planets= new HashSet<>();
    private Set<Long> species= new HashSet<>();
    private Set<Long> starships= new HashSet<>();
    private Set<Long> vehicles= new HashSet<>();

    public FilmFullDTO() {
    }

    public FilmFullDTO(Long id, String title, String director, String producer, Date releaseDate, Timestamp createdAt,
                       Timestamp updatedAt, Set<Long> characters, Set<Long> planets, Set<Long> species, Set<Long> starships, Set<Long> vehicles) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.characters = characters;
        this.planets = planets;
        this.species = species;
        this.starships = starships;
        this.vehicles = vehicles;
    }
    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonGetter("director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    @JsonGetter("producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @JsonGetter("release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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
    @JsonGetter("characters")
    public Set<Long> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Long> characters) {
        this.characters = characters;
    }

    @JsonGetter("planets")
    public Set<Long> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Long> planets) {
        this.planets = planets;
    }

    @JsonGetter("species")
    public Set<Long> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Long> species) {
        this.species = species;
    }

    @JsonGetter("starships")
    public Set<Long> getStarships() {
        return starships;
    }

    public void setStarships(Set<Long> starships) {
        this.starships = starships;
    }

    @JsonGetter("vehicles")
    public Set<Long> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Long> vehicles) {
        this.vehicles = vehicles;
    }
}
