package com.example.Swapi.Dtos;



import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;


import java.sql.Timestamp;
import java.util.Set;

public class PersonFullDTO{

    private Long id;
    private String name;
    private Double height;
    private Double mass;
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @JsonProperty("homeworld_id")
    private Long homeworldId;

    @JsonProperty("species_id")
    private Set<Long> species;

    @JsonProperty("films")
    private Set<Long> films;

    @JsonProperty("vehicles")
    private Set<Long> vehicles;

    @Nullable
    @JsonProperty("starships")
    private Set<Long> starships;


    public PersonFullDTO() {
    }

    public PersonFullDTO(Long id, String name, Double height, Double mass, String gender, String hairColor, String skinColor, String eyeColor, String birthYear, Timestamp createdAt, Timestamp updatedAt, Long homeworldId, Set<Long> species, Set<Long> films, Set<Long> vehicles, Set<Long> starships) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.homeworldId = homeworldId;
        this.species = species;
        this.films = films;
        this.vehicles = vehicles;
        this.starships = starships;
    }


    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("height")
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @JsonGetter("mass")
    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    @JsonGetter("hair_color")
    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    @JsonGetter("skin_color")
    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }
    @JsonGetter("eye_color")
    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    @JsonGetter("birth_year")
    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
    @JsonGetter("gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @JsonGetter("homeworld_id")
    public Long getHomeworldId() {
        return homeworldId;
    }

    public void setHomeworldId(Long homeworldId) {
        this.homeworldId = homeworldId;
    }

    @JsonGetter("species_id")
    public Set<Long> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Long> species) {
        this.species = species;
    }

    @JsonGetter("films")
    public Set<Long> getFilms() {
        return films;
    }

    public void setFilms(Set<Long> films) {
        this.films = films;
    }

    @JsonGetter("vehicles")
    public Set<Long> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Long> vehicles) {
        this.vehicles = vehicles;
    }

    @JsonGetter("starships")
    public Set<Long> getStarships() {
        return starships;
    }

    public void setStarships(Set<Long> starships) {
        this.starships = starships;
    }
}
