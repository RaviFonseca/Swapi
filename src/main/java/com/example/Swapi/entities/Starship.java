package com.example.Swapi.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "starship")
public class Starship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "cost_in_credits")
    private String costInCredits;
    @Column(name = "length")
    private Double length;
    @Column(name = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @Column(name = "passengers")
    private String passengers;
    @Column(name = "cargo_capacity")
    private Integer cargoCapacity;
    @Column(name = "consumables")
    private String consumables;
    @Column(name = "hyperdrive_rating")
    private Double hyperDriveRating;
    @Column(name = "MGLT")
    private Double MGLT;
    @Column(name = "starship_class")
    private String starshipClass;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToMany
    @JoinTable(
            name = "person_starship",
            joinColumns = @JoinColumn(name = "starship_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> pilots = new HashSet<>();


    @ManyToMany(mappedBy = "starships")
    private Set<Film> films = new HashSet<>();

    public Starship() {
    }

    public Starship(Long id, String name, String model, String manufacturer, String costInCredits, Double length, String maxAtmospheringSpeed, String passengers, Integer cargoCapacity, String consumables, Double hyperDriveRating, Double MGLT, String starshipClass, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperDriveRating = hyperDriveRating;
        this.MGLT = MGLT;
        this.starshipClass = starshipClass;
        this.createdAt = createdAt;
    }

    public Starship(Long id) {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public Integer getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Integer cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public Double getHyperDriveRating() {
        return hyperDriveRating;
    }

    public void setHyperDriveRating(Double hyperDriveRating) {
        this.hyperDriveRating = hyperDriveRating;
    }

    public Double getMGLT() {
        return MGLT;
    }

    public void setMGLT(Double MGLT) {
        this.MGLT = MGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
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

    public Set<Person> getPilots() {
        return pilots;
    }

    public void setPilots(Set<Person> pilots) {
        this.pilots = pilots;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
