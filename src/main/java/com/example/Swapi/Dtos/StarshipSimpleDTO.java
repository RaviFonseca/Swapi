package com.example.Swapi.Dtos;

import com.fasterxml.jackson.annotation.JsonGetter;

public class StarshipSimpleDTO {
    private Long id;
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private Double length;

    public StarshipSimpleDTO() {
    }

    public StarshipSimpleDTO(Long id, String name, String model, String manufacturer, String costInCredits, Double length) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
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
}
