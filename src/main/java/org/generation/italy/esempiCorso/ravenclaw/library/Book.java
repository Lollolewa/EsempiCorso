package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int weight, nPages;
    private double cost;
    private LocalDate publicationDate;
    private Category category;
    private List<String> bookLanguages;
    private List<Author> authors;

    public Book(String title, int weight, int nPages, double cost, LocalDate publicationDate, Category category, List<String> languages, List<Author> authors) {
        this.title = title;
        this.weight = weight;
        this.nPages = nPages;
        this.cost = cost;
        this.publicationDate = publicationDate;
        this.category = category;
        this.bookLanguages = new ArrayList<>(languages);
        this.authors = authors;
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

    public int getnPages() {
        return nPages;
    }

    public void setnPages(int nPages) {
        this.nPages = nPages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getBookLanguages() {
        return bookLanguages;
    }

    public void setBookLanguages(List<String> bookLanguages) {
        this.bookLanguages = bookLanguages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public boolean isPublishedBetween(LocalDate start, LocalDate end){
        return start.minusDays(1).isBefore(publicationDate) && end.isAfter(publicationDate);
    }

    public boolean titleContains (String word){
        return title.contains(word);
    }



    @Override
    public String toString() {
        return String.format(
                "\nBook{" +
                        "Title: '%s'\n" +
                        "Number of Pages: %d\n" +
                        "Cost: %.2f\n" +
                        "Publication Date: %s\n" +
                        "Category: %s\n" +
                        "Languages: %s\n" +
                        "Authors: %s\n" +
                        '}',
                title, nPages, cost, publicationDate, category, bookLanguages, authors
        );
    }

}
