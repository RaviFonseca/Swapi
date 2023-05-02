package com.example.Swapi.SpringSecurity.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "object")
    private Set<Permission> permissions = new HashSet<>();

    public Object() {
    }

    public Object(String name) {
        this.name = name;
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
