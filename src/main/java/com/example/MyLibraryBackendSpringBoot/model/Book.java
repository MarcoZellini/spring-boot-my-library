package com.example.MyLibraryBackendSpringBoot.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book {

    /* Properties */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private long userId;

    @NotNull
    @Column(name = "title")
    public String title;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "plot")
    private String plot;

    @NotNull
    @Column(name = "total_readings")
    @JsonProperty("total_readings")
    private int totalReadings;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Timestamp updatedAt;

    /* Constructors */
    public Book() {
    }

    public Book(long id, long userId, String title, String author, String isbn, String plot, int totalReadings) {
        this.setId(id);
        this.setUserId(userId);
        this.setTitle(title);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPlot(plot);
        this.setTotalReadings(totalReadings);
        this.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        this.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

    }

    /* Getters & Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getTotalReadings() {
        return totalReadings;
    }

    public void setTotalReadings(int totalReadings) {
        this.totalReadings = totalReadings;
    }

    public void setTotalReadings(Book totalReadings) {
        this.totalReadings = totalReadings.getTotalReadings();
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

        if (!(obj instanceof Book)) {
            return false;
        }

        Book book = (Book) obj;

        return this.getId() == book.getId() &&
                this.getUserId() == book.getUserId() &&
                this.getTitle() == book.getTitle() &&
                this.getAuthor().equals(book.getAuthor()) &&
                this.getIsbn().equals(book.getIsbn()) &&
                this.getPlot().equals(book.getPlot()) &&
                this.getTotalReadings() == book.totalReadings &&
                this.getCreatedAt().equals(book.getCreatedAt()) &&
                this.getUpdatedAt().equals(book.getUpdatedAt());
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "<br>" +
                "userId: " + this.getUserId() + "<br>" +
                "title: " + this.getTitle() + "<br>" +
                "author: " + this.getAuthor() + "<br>" +
                "isbn: " + this.getIsbn() + "<br>" +
                "plot: " + this.getPlot() + "<br>" +
                "totalReadings: " + this.getTotalReadings() + "<br>" +
                "createdAt: " + this.getCreatedAt() + "<br>" +
                "updatedAt: " + this.getUpdatedAt() + "<br>";
    }
}
