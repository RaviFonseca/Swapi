package com.example.Swapi.Dtos;


import java.util.UUID;

public class StarshipVehicleDTO {
    private UUID id;
    private String name;
    private String model;
    private String manufacturer;
    private Double costInCredits;
    private Double length;

    public StarshipVehicleDTO() {
    }

    public StarshipVehicleDTO(UUID id, String name, String model, String manufacturer, Double costInCredits, Double length) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Double getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(Double costInCredits) {
        this.costInCredits = costInCredits;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
