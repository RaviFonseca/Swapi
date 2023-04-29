package com.example.Swapi.entities;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @Column(name = "episode_id", nullable = false)
//    private Integer episodeId;
    @Column(name = "title", unique = true)
    private String title;
    @Column(name = "director")
    private String director;
    @Column(name = "producer")
    private String producer;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToMany
    @JoinTable(
            name = "film_planet",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "planet_id")
    )
    private Set<Planet> planets= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "film_species",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    private Set<Species> species = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "film_starship",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "starship_id")
    )
    private Set<Starship> starships= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "film_vehicle",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "person_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> characters = new HashSet<>();



    public Film() {
    }

    public Film(Long id , String title, String director, String producer, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Film(Long id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public Set<Person> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Person> characters) {
        this.characters = characters;
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    public Set<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Species> species) {
        this.species = species;
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
