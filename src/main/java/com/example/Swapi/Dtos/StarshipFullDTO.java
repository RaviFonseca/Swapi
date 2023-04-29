package com.example.Swapi.Dtos;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToMany;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class StarshipFullDTO {

    private Long id;
    private String name;
    private String model;
    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    private Double length;
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String passengers;
    @JsonProperty("cargo_capacity")
    private Integer cargoCapacity;
    private String consumables;
    @JsonProperty("hyperdrive_rating")
    private Double hyperDriveRating;

    @JsonProperty("MGLT")
    private Double MGLT;
    @JsonProperty("starship_class")
    private String starshipClass;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    //@JsonProperty("pilots")
    private Set<Long> pilots = new HashSet<>();

    private Set<Long> films = new HashSet<>();

    public StarshipFullDTO() {
    }

    public StarshipFullDTO(Long id, String name, String model, String manufacturer, String costInCredits, Double length, String maxAtmospheringSpeed, String passengers, Integer cargoCapacity, String consumables, Double hyperDriveRating, Double MGLT, String starshipClass, Timestamp createdAt, Timestamp updatedAt) {
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

    @JsonGetter("cost_in_credits")
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

    @JsonGetter("max_atmosphering_speed")
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

    @JsonGetter("cargo_capacity")
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

    @JsonGetter("hyperdrive_rating")
    public Double getHyperDriveRating() {
        return hyperDriveRating;
    }

    public void setHyperDriveRating(Double hyperDriveRating) {
        this.hyperDriveRating = hyperDriveRating;
    }
    @JsonGetter("MGLT")
    public Double getMGLT() {
        return MGLT;
    }

    public void setMGLT(Double MGLT) {
        this.MGLT = MGLT;
    }

    @JsonGetter("starship_class")
    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
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

    @JsonGetter("pilots")
    public Set<Long> getPilots() {
        return pilots;
    }

    public void setPilots(Set<Long> pilots) {
        this.pilots = pilots;
    }

    @JsonGetter("films")
    public Set<Long> getFilms() {
        return films;
    }

    public void setFilms(Set<Long> films) {
        this.films = films;
    }
}
