package org.generation.italy.esempiCorso.ravenclaw.library;

import org.generation.italy.esempiCorso.ravenclaw.library.Category;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Book {
    private String title;
    private int weight, nPages;
    private double cost;
    private Category category;
    private LocalDate date;
    private List<String> languages;
    private List<Author> author;

    public Book(String title, int weight, int nPages, double cost, Category category, LocalDate date, List<String> languages, List<Author> author) {
        this.title = title;
        this.weight = weight;
        this.nPages = nPages;
        this.cost = cost;
        this.category = category;
        this.date = date;
        this.languages = new ArrayList<>(languages);
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getNPages() {
        return nPages;
    }
    public void setNPages(int nPages) {
        this.nPages = nPages;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public List<String> getLanguages() {
        return languages;
    }
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    public List<Author> getAuthor() {
        return author;
    }
    public void setAuthor(List<Author> author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", weight=" + weight +
                ", nPages=" + nPages +
                ", cost=" + cost +
                ", category=" + category +
                ", date=" + date +
                ", languages=" + languages +
                ", author=" + author +
                '}';
    }
}
