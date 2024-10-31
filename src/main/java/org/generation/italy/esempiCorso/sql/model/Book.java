package org.generation.italy.esempiCorso.sql.model;

public class Book {
    private int id,num_pages,publisher_id;
    private String title,category;
    private double weight;

    public Book(int id, int num_pages, int publisher_id, String title, String category, double weight) {
        this.id = id;
        this.num_pages = num_pages;
        this.publisher_id = publisher_id;
        this.title = title;
        this.category = category;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", num_pages=" + num_pages +
                ", publisher_id=" + publisher_id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                '}';
    }
}
