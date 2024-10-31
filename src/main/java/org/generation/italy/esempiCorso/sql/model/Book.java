package org.generation.italy.esempiCorso.sql.model;

public class Book {
    private int id, num_pages, publisher_id;
    private String titolo, category;
    private double weight;

    public Book(int id, String titolo, int num_pages, double weight, String category , int publisher_id) {
        this.id = id;
        this.num_pages = num_pages;
        this.publisher_id = publisher_id;
        this.titolo = titolo;
        this.category = category;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", num_pages=" + num_pages +
                ", publisher_id=" + publisher_id +
                ", titolo='" + titolo + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                '}';
    }
}
