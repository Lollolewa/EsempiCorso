package org.generation.italy.esempiCorso.sql.model;

public class Book {

    private String title,category;
    private int id,num_pages,publisher_id;
    private double weight;

    public Book(int id, int num_pages, int publisher_id, double weight, String title, String category) {
        this.id = id;
        this.num_pages = num_pages;
        this.publisher_id = publisher_id;
        this.weight = weight;
        this.title = title;
        this.category = category;

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", id=" + id +
                ", num_pages=" + num_pages +
                ", publisher_id=" + publisher_id +
                ", weight=" + weight +
                '}';
    }
}
