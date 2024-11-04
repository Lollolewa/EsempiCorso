package org.generation.italy.esempiCorso.sql.model;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
    private int id, num_pages, publisher_id;
    private String title, category;
    private double weight;

//    private static final String INSERT_SQL = """
//            insert into books(id, title, num_pages, category, weight)
//            values(?, ?, ?, ?, ?);
//            """;

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

    public int getId() {
        return id;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
