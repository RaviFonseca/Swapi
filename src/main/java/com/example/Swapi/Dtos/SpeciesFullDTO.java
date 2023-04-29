package com.example.Swapi.Dtos;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class SpeciesFullDTO {
    private Long id;
    private String name;
    private String classification;
    private String designation;
    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("skin_colors")
    private String skinColors;
    @JsonProperty("hair_colors")
    private String hairColors;
    @JsonProperty("eye_colors")
    private String eyeColors;
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    private String language;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;
    @JsonProperty("films")
    private Set<Long> films= new HashSet<>();
    @JsonProperty("people")

    private Set<Long> people =  new HashSet<>();
    @JsonProperty("homeworld")
    private Set<Long> planets =  new HashSet<>();




    public SpeciesFullDTO() {
    }

    public SpeciesFullDTO(Long id, String name, String classification, String designation, String averageHeight, String skinColors,
                          String hairColors, String eyeColors, String averageLifespan, String language, Timestamp createdAt, Timestamp updatedAt, Set<Long> planets  ) {
        this.id = id;
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageHeight = averageHeight;
        this.skinColors = skinColors;
        this.hairColors = hairColors;
        this.eyeColors = eyeColors;
        this.averageLifespan = averageLifespan;
        this.language = language;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.planets = planets;
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

    @JsonGetter("classification")
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @JsonGetter("designation")
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonGetter("average_height")
    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    @JsonGetter("skin_colors")
    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    @JsonGetter("hair_colors")
    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    @JsonGetter("eye_colors")
    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    @JsonGetter("average_lifespan")
    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    @JsonGetter("language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
    @JsonGetter("people")
    public Set<Long> getPeople() {
        return people;
    }

    public void setPeople(Set<Long> people) {
        this.people = people;
    }

    @JsonGetter("homeworld")
    public Set<Long> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Long> planets) {
        this.planets = planets;
    }
}
