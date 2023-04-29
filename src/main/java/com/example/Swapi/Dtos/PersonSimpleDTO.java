package com.example.Swapi.Dtos;

public class PersonSimpleDTO {
    private Long id;
    private String name;
    private Double height;
    private Double mass;
    private String gender;

    public PersonSimpleDTO() {
    }

    public PersonSimpleDTO(String name, Double height, Double mass, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
