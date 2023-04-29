package com.example.Swapi.Dtos;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class VehicleFullDTO {
    private Long id;
    private String name;
    private String model;
    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    private Double length;
    @JsonProperty("max_atmosphering_speed")
    private Integer maxAtmospheringSpeed;
    private Integer crew;
    private Integer passengers;
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @JsonProperty("vehicle_class")
    private String vehicleClass;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    private Set<Long> pilots = new HashSet<>();

    private Set<Long> films = new HashSet<>();

    public VehicleFullDTO() {
    }

    public VehicleFullDTO(Long id, String name, String model, String manufacturer, String costInCredits, Double length, Integer maxAtmospheringSpeed, Integer crew, Integer passengers, String cargoCapacity, String consumables, String vehicleClass, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.vehicleClass = vehicleClass;
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
    public Integer getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(Integer maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    @JsonGetter("cargo_capacity")
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    @JsonGetter("vehicle_class")
    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
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
