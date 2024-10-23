package org.generation.italy.esempiCorso.griffindor.eserciziCollection.Libreria;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private double weight;
    private int pageCount;
    private double cost;
    private LocalDate publicationDate;
    private Category category;
    private List<Author> authors;
    private String language;

    // Constructor, getters, and setters
    public Book(int id, String title, double weight, int pageCount, double cost, LocalDate publicationDate,
                Category category, List<Author> authors, String language) {
        this.id = id;
        this.title = title;
        this.weight = weight;
        this.pageCount = pageCount;
        this.cost = cost;
        this.publicationDate = publicationDate;
        this.category = category;
        this.authors = authors;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public Category getCategory() {
        return category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

