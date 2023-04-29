package com.example.Swapi.Dtos;

public class SpeciesSimpleDTO {
    private Long id;
    private String name;
    private String classification;
    private String designation;

    public SpeciesSimpleDTO() {
    }

    public SpeciesSimpleDTO(Long id, String name, String classification, String designation) {
        this.id = id;
        this.name = name;
        this.classification = classification;
        this.designation = designation;
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
}
