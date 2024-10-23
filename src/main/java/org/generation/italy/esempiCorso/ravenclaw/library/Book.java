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

    public double getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }


    public List<String> getBookLanguages() {
        return bookLanguages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public boolean isPublishedBetween(LocalDate start, LocalDate end){
        return start.minusDays(1).isBefore(publicationDate) && end.isAfter(publicationDate);
    }

    public boolean titleContains(String word){
        return title.contains(word);
    }

    public boolean isWrittenBy(int authorId){
        return authors.stream().anyMatch(author -> author.getAuthorId()==authorId);
    }

    public int getAuthorCount(){
        return authors.size();
    }

    public int getnPages(){
        return nPages;
    }

    @Override
    public String toString() {
        return String.format(
                        "%nTitle: %s%n" +
                        "Number of Pages: %d%n" +
                        "Cost: $%.2f%n" +
                        "Publication Date: %s%n" +
                        "Category: %s%n" +
                        "Languages: %s%n" +
                        "Author: %s%n",
                         title, nPages, cost, publicationDate, category, bookLanguages, authors
        );
    }
}
