package com.example.MyLibraryBackendSpringBoot.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    public User() {

    }

    public User(@NotNull String name, @NotNull String lastname, @NotNull String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    public User(long id, @NotNull String name, @NotNull String lastname, @NotNull String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    /* Overrides */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        User user = (User) obj;

        return this.getId() == user.getId() &&
                this.getName().equals(user.getName()) &&
                this.getLastname().equals(user.getLastname()) &&
                this.getEmail().equals(user.getEmail()) &&
                this.getCreatedAt().equals(user.getCreatedAt()) &&
                this.getUpdatedAt().equals(user.getUpdatedAt());
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "<br>" +
                "name: " + this.getName() + "<br>" +
                "lastname: " + this.getLastname() + "<br>" +
                "email: " + this.getEmail() + "<br>" +
                "createdAt: " + this.getCreatedAt() + "<br>" +
                "updatedAt: " + this.getUpdatedAt() + "<br>";
    }
}
