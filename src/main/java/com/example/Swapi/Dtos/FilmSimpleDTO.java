package com.example.Swapi.Dtos;


import com.fasterxml.jackson.annotation.JsonGetter;

import java.sql.Date;
import java.sql.Timestamp;

public class FilmSimpleDTO {
    private Long id;
    private String title;
    private String director;
    private String producer;
    private Date releaseDate;

    private Timestamp createdAt;

    private Timestamp updatedAt;


    public FilmSimpleDTO() {
    }
    public FilmSimpleDTO(Long id, String title, String director, String producer, Date releaseDate, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    @JsonGetter("release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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
}
