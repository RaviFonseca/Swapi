package com.example.Swapi.entities;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "classification")
    private String classification;
    @Column(name = "designation")
    private String designation;
    @Column(name = "average_height")
    private String averageHeight;
    @Column(name = "skin_colors")
    private String skinColors;
    @Column(name = "hair_colors")
    private String hairColors;
    @Column(name = "eye_colors")
    private String eyeColors;
    @Column(name = "average_lifespan")
    private String averageLifespan;


    @Column(name = "language")
    private String language;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;


    @ManyToMany(mappedBy = "species")
    private Set<Film> films= new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "species_planet",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "planet_id")
    )
    private Set<Planet> planets = new HashSet<>();

//    @ManyToMany(mappedBy = "species")
//    private Set<Planet> planets= new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "PERSON_SPECIES",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> people = new HashSet<>();

    public Species() {
    }

    public Species(Long id, String name, String classification, String designation, String averageHeight, String skinColors, String hairColors,
                   String eyeColors, String averageLifespan, String language, Timestamp createdAt, Timestamp updatedAt) {
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
    }

    public Species(Long id) {
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
